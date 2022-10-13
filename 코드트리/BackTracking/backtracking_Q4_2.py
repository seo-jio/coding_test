n = int(input())
arr = []
visited = [0 for _ in range(11)] #선택 여부를 확인하기 위한 배열 선언


def solve(cur_num): #1~n까지의 숫자 중 앞에서 선택되지 않은 수를 선택
    if cur_num == n+1:
        for elem in arr:
            print(elem, end=' ')
        print()
        return
    for i in range(n, 0, -1):
        if visited[i] == 1: #현재 선택하려는 숫자가 이미 선택했던 숫자라면 continue
            continue
        else:
            visited[i] = 1
            arr.append(i)
            solve(cur_num+1)
            arr.pop()
            visited[i] = 0

solve(1)