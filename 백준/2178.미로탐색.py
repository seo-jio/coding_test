from collections import deque

def in_range(x, y):
    return x >= 0 and x < n and y >= 0 and y < m

def can_go(x, y):
    if not in_range(x, y) or grid[x][y] == '0' or visited[x][y]:
        return False
    return True

def bfs():
    while deq:
        x, y = deq.popleft()
        for dx, dy in zip(dxs, dys):
            nx, ny = x + dx, y + dy
            if can_go(nx, ny):
                grid[nx][ny] = grid[x][y] + 1
                visited[nx][ny] = True
                deq.append((nx, ny))


n, m = map(int, input().split())
grid = [
    list(input())
    for _ in range(n)
]

visited = [
    [False] * (m+1)
    for _ in range(n)
]

deq = deque()
deq.append((0, 0))
dxs = [0, 1, 0, -1]
dys = [1, 0, -1, 0]
grid[0][0] = 1
visited[0][0] = True
bfs()

print(grid[n-1][m-1])