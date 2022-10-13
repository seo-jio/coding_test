n, m = map(int, input().split())
arr = [
    list(map(int, input().split()))
    for _ in range(n)
]

dxs = [-1, -1, -1, 1, 1, 1, 0, 0]
dys = [-1, 0, 1, -1, 0, 1, -1, 1]

def find_one_pos(num): #해당하는 숫자의 격자에서의 위치 return
    for r in range(n):
        for c in range(n):
            if arr[r][c] == num:
                return r, c

def in_range(x, y): #격자 내 있는지 판단하는 방어함수
    return x >= 0 and x < n and y >= 0 and y < n

for i in range(m):
    for num in range(1, n*n+1):
        x, y = find_one_pos(num)
        max_val = 0
        for dx, dy in zip(dxs, dys): #8방향 모두 확인하면서 최대 위치를 찾음
            nx, ny = x + dx, y + dy
            if in_range(nx, ny) and arr[nx][ny] > max_val:
                max_val = arr[nx][ny]
                temp_x, temp_y = nx, ny
        #위치 전환
        temp = arr[x][y]
        arr[x][y] = arr[temp_x][temp_y]
        arr[temp_x][temp_y] = temp

for row in arr:
    for elem in row:
        print(elem, end=' ')
    print()
