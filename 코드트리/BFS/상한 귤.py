from collections import deque

n, k = map(int, input().split())
grid = [
    list(map(int, input().split()))
    for _ in range(n)
]

visited = [
    [False] * n
    for _ in range(n)
]

ans = [
    [-1] * n
    for _ in range(n)
]

def in_range(x, y):
    return x >= 0 and x < n and y >= 0 and y < n

def can_go(x, y):
    if not in_range(x, y) or grid[x][y] != 1 or visited[x][y]:
        return False
    return True

def bfs():
    while que:
        x, y = que.popleft()
        for dx, dy in zip(dxs, dys):
            nx, ny = x + dx, y + dy
            if can_go(nx, ny):
                que.append((nx, ny))
                visited[nx][ny] = True
                ans[nx][ny] = ans[x][y] + 1


dxs = [0, 1, 0, -1]
dys = [1, 0, -1, 0]

que = deque()
cnt = 0
for x in range(n):
    for y in range(n):
        if cnt == k:
            break
        if grid[x][y] == 2:
            que.append((x, y))
            visited[x][y] = True
            ans[x][y] = 0
            cnt += 1

bfs()

for x in range(n):
    for y in range(n):
        if grid[x][y] == 1 and not visited[x][y]:
            ans[x][y] = -2

for row in ans:
    print(*row)