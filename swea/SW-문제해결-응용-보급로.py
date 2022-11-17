from collections import deque
import math

def in_range(x, y):
    return x >= 0 and x < n and y >= 0 and y < n

def bfs():
    global ans
    s = 0
    while len(q) != 0:
        x, y = q.popleft()
        s += grid[x][y]
        if x == n-1 and y == n-1:
            ans = min(ans, s)
            continue
        for dx, dy in zip(dxs, dys):
            nx, ny = x + dx, y + dy
            if in_range(nx, ny):
                q.append((nx, ny))
                visited[nx][ny] = True


T = int(input())
dxs = [-1, 0, 1, 0]
dys = [0, 1, 0, -1]

for tc in range(1, T+1):
    n = int(input())
    grid = [
        list(input())
        for _ in range(n)
    ]
    visited = [
        [False] * n
        for _ in range(n)
    ]
    q = deque()
    q.append((0, 0))
    visited[0][0] = True
    ans = math.inf
    bfs()
