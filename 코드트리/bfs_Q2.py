from collections import deque

n, m = map(int, input().split())
grid = [
    list(map(int, input().split()))
    for _ in range(n)
]

visited = [
    [False for _ in range(m)]
    for _ in range(n)
]

step = [  #각 칸마의 최단경로 값을 저장할 격자
    [0 for _ in range(m)]
    for _ in range(n)
]

q = deque()

dxs = [0, 1, 0, -1]
dys = [1, 0, -1, 0]


def in_range(x, y):
    return x >= 0 and x < n and y >= 0 and y < m


def can_go(x, y):
    if not in_range(x, y):
        return False
    if visited[x][y] or grid[x][y] == 0:
        return False
    return True


def bfs():
    while q:
        x, y = q.popleft()
        for dx, dy in zip(dxs, dys):
            nx, ny = x + dx, y + dy
            if can_go(nx, ny):
                visited[nx][ny] = True
                step[nx][ny] = step[x][y] + 1 #다음 이동할 칸에 현재 칸의 최단경로 값 + 1을 넣어줌
                q.append((nx, ny))


visited[0][0] = True
q.append((0, 0))
bfs()

if step[n-1][m-1] == 0:
    print(-1)
else:
    print(step[n-1][m-1])