n = int(input())
arr = []
temp = [0 for _ in range(11)]

def solve(cur_num): #1~n까지의 숫자 중 앞에서 선택되지 않은 수를 선택
    if cur_num == n+1:
        for elem in arr:
            print(elem, end=' ')
        print()
        return
    for i in range(1, n+1):
        if temp[i] == 1:
            continue
        else:
            temp[i] = 1
            arr.append(i)
            solve(cur_num+1)
            arr.pop()
            temp[i] = 0

solve(1)