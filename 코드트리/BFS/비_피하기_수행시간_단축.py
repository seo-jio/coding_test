from collections import deque

n, h, m = map(int, input().split())
grid = [
    list(map(int, input().split()))
    for _ in range(n)
]

visited = [
    [False] * n
    for _ in range(n)
]

step = [
    [0] * n
    for _ in range(n)
]

safe = []
for x in range(n):
    for y in range(n):
        if len(safe) == m:
            break
        if grid[x][y] == 3:
            safe.append((x,y))


def in_range(x, y):
    return x >= 0 and x < n and y >= 0 and y < n

def can_go(x, y):
    if in_range(x, y) and grid[x][y] != 1 and not visited[x][y]:
        return True
    return False

def bfs(): #비를 피할 가까운 장소 return
    dxs = [-1, 1, 0, 0]
    dys = [0, 0, -1, 1]
    while len(q) != 0:
        x, y = q.popleft()
        for dx, dy in zip(dxs, dys):
            nx, ny = x + dx, y + dy
            if can_go(nx, ny):
                visited[nx][ny] = True
                q.append((nx,ny))
                step[nx][ny] = step[x][y] + 1
    return -1

q = deque()
for x, y in safe:
    q.append((x, y))
    visited[x][y] = True

bfs()

for x in range(n):
    for y in range(n):
        if grid[x][y] != 2:
            print(0, end=' ')
            continue
        if not visited[x][y]:
            print(-1, end=' ')
        else:
            print(step[x][y], end=' ')
    print()

