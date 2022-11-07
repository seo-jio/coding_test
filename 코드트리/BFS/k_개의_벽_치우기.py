import itertools
from collections import deque
from itertools import combinations

n, k = map(int, input().split())
grid = [
    list(map(int, input().split()))
    for _ in range(n)
]
sx, sy = map(int, input().split())
sx, sy = sx-1, sy-1
ex, ey = map(int, input().split())
ex, ey = ex-1, ey-1

wall = []
for x in range(n):
    for y in range(n):
        if grid[x][y] == 1:
            wall.append((x,y))
nCr = combinations(wall, k)


def in_range(x, y):
    return x >= 0 and x < n and y >= 0 and y < n

def can_go(x, y):
    if in_range(x, y) and not visited[x][y] and ngrid[x][y] != 1:
        return True
    return False

def bfs():
    dxs = [-1, 1, 0, 0]
    dys = [0, 0, -1, 1]
    while len(q) != 0:
        x, y = q.popleft()
        if x == ex and y == ey:
            return True
        for dx, dy in zip(dxs, dys):
            nx, ny = x + dx, y + dy
            if can_go(nx, ny):
                q.append((nx, ny))
                visited[nx][ny] = True
                step[nx][ny] = step[x][y] + 1
    return False

mstep = n * n
for tup in nCr:
    ngrid = [row[:] for row in grid] #슬라이싱으로 2차원 배열 깊은 복사

    visited = [
        [False] * n
        for _ in range(n)
    ]

    step = [
        [0] * n
        for _ in range(n)
    ]
    for t in tup:
        x, y = t
        ngrid[x][y] = 0
    q = deque()
    q.append((sx, sy))
    visited[sx][sy] = True
    if bfs():
        mstep = min(mstep, step[ex][ey])
    # for row in step:
    #     for elem in row:
    #         print(elem, end=' ')
    #     print()
    # print("==============")

if mstep == n*n:
    print(-1)
else:
    print(mstep)

