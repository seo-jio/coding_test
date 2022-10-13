from collections import deque

n, k = map(int, input().split())
grid = [
    list(map(int, input().split()))
    for _ in range(n)
]

visited = [
    [False for _ in range(n)]
    for _ in range(n)
]

dxs = [0, 1, 0, -1]
dys = [1, 0, -1, 0]

q = deque()

def in_range(x, y):
    return x >= 0 and x < n and y >= 0 and y < n

def can_go(x, y):
    if not in_range(x, y):
        return False
    if visited[x][y] or grid[x][y] == 1:
        return False
    return True

def bfs():
    global count
    while q:
        x, y = q.popleft()
        for dx, dy in zip(dxs, dys):
            nx, ny = x + dx, y + dy
            if can_go(nx, ny):
                count += 1
                visited[nx][ny] = True
                q.append((nx, ny))

count = 0
for i in range(k):
    r, c = map(int, input().split())
    r, c = r-1, c-1
    if can_go(r, c):
        count += 1
        visited[r][c] = True
        q.append((r, c))
        bfs()

print(count)