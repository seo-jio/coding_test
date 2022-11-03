import sys
n = int(sys.stdin.readline())
arr = [
    sys.stdin.readline().strip()
    for _ in range(n)
]

print(arr)

left, right = 0, 0

def is_pelindrome(string, L, R):
    global left, right
    while L < R:
        if string[L] != string[R]:
            left = L
            right = R
            return False
        L += 1
        R -= 1
    return True

for string in arr:
    if is_pelindrome(string, 0, len(string) - 1):
        print(0)
    else:
        temp = string[left:right+1]
        flag = 1
        cnt = 0
        for i in range(len(temp)):
            new = temp[:i] + temp[i+1:]
            if is_pelindrome(new, 0, len(new) - 1):
                break
            else:
                cnt += 1
            if cnt > 1:
                flag = 0
                break
        if flag == 1:
            print(1)
        else:
            print(2)