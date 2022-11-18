from collections import deque

m, n = map(int, input().split())
grid = [
    list(map(int, input().split()))
    for _ in range(n)
]
visited = [
    [False] * m
    for _ in range(n)
]

dxs = [-1, 0, 1, 0]
dys = [0, 1, 0, -1]

def in_range(x, y):
    return x >= 0 and x < n and y >= 0 and y < m

def can_go(x, y):
    if in_range(x, y) and grid[x][y] == 0:
        return True
    return False

def find_start():
    for x in range(n):
        for y in range(m):
            if grid[x][y] == 1:
                start.append((x, y))

def bfs():
    global max_day
    while len(q) != 0:
        x, y, day = q.popleft()
        max_day = max(max_day, day)
        for dx, dy in zip(dxs, dys):
            nx, ny = x + dx, y + dy
            if can_go(nx, ny) and not visited[nx][ny]:
                visited[nx][ny] = True
                q.append((nx, ny, day+1))

start = []
find_start()
q = deque()
for x, y in start:
    q.append((x, y, 0))
    visited[x][y] = True
max_day = 0
bfs()

flag = 1
for x in range(n):
    for y in range(m):
        if grid[x][y] == 0 and not visited[x][y]:
            flag = 0
if flag:
    print(max_day)
else:
    print(-1)

for row in visited:
    print(*row)