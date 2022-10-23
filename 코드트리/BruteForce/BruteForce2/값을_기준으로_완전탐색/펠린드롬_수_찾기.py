start, end = map(int, input().split())

def is_pelindrome(num):
    string = str(num)
    if len(string) % 2 == 0:
        front = string[:len(string)//2]
        back = string[len(string)//2:]
        back = back[::-1] #문자열 뒤집기
    else:
        front = string[:len(string)//2]
        back = string[len(string)//2 + 1:]
        back = back[::-1]
    if front == back:
        return True
    return False

count = 0
for i in range(start, end + 1):
    if is_pelindrome(i):
        count += 1
print(count)