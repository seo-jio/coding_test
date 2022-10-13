n, m, k = map(int, input().split())
k = k - 1
arr = [
    list(map(int, input().split()))
    for _ in range(n)
]

flag = 1
row = 0
while flag == 1:
    if row == n-1:  #마지막 행에 도달 했을 경우 블록을 격자에 넣어줌
        for col in range(k, k+m):
            arr[row][col] = 1
        break
    inner_flag = 1
    for col in range(k, k+m):
        if arr[row][col] == 1:  # 블록이 놓일 위치에 이미 블록이 있는 경우
            inner_flag = 0
    if inner_flag == 1: #블록을 놓을 수 있는 경우
        row += 1
    else:  #블록을 놓을 수 없는 경우
        for col in range(k, k+m):
            arr[row-1][col] = 1
        flag = 0

for row in arr:
    for elem in row:
        print(elem, end=' ')
    print()