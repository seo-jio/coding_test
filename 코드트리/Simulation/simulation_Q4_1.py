n, x, y = map(int, input().split())
x, y = x-1, y-1

arr = [
    list(map(int, input().split()))
    for _ in range(n)
]

#상하좌우 순으로 dxs,dys를 구성하여 우선순위를 순서대로 부여
dxs = [-1, 1, 0, 0]
dys = [0, 0, -1, 1]

history = []
history.append(arr[x][y])

def in_range(x, y):
    return x >= 0 and x < n and y >= 0 and y < n

flag = 0 #종료 조건을 위한 flag
while flag == 0:
    count = 0
    for dx, dy in zip(dxs, dys):
        count += 1
        nx, ny = x + dx, y + dy
        if in_range(nx, ny) and arr[nx][ny] > arr[x][y]:
            x, y = nx, ny
            history.append(arr[nx][ny])
            break
        if count == 4: #상하좌우 모두 확인 후 x,y가 이동하지 않는 경우(즉, 더 큰 값이 않는 경우)
            flag = 1

for h in history:
    print(h, end=' ')