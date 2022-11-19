import sys
sys.setrecursionlimit(10**6) #dfs 사용시 필요, 10**6으로 하면 pypy3에서 돌릴 때 메모리 초과가 나서 10**5으로 바꾸거나 python3에서 돌려야 한다.
from collections import deque

T = int(input())

def in_range(x, y):
    return x >= 0 and x < n and y >= 0 and y < m

def can_go(x, y):
    if in_range(x, y) and grid[x][y] == 1 and not visited[x][y]:
        return True
    return False

def dfs(x, y):
    for dx, dy in zip(dxs, dys):
        nx, ny = x + dx, y + dy
        if can_go(nx, ny):
            visited[nx][ny] = True
            dfs(nx, ny)

def bfs():
    while len(q) != 0:
        x, y = q.popleft()
        for dx, dy in zip(dxs, dys):
            nx, ny = x + dx, y + dy
            if can_go(nx, ny):
                visited[nx][ny] = True
                q.append((nx, ny))

for tc in range(1, T+1):
    m, n, k = map(int, input().split())
    dxs = [-1, 0, 1, 0]
    dys = [0, 1, 0, -1]
    grid = [
        [0] * m
        for _ in range(n)
    ]
    visited = [
        [False] * m
        for _ in range(n)
    ]
    for i in range(k):
        y, x = map(int, input().split())
        grid[x][y] = 1

    cnt = 0
    for x in range(n):
        for y in range(m):
            if not visited[x][y] and grid[x][y] == 1:
                cnt += 1
                # dfs(x, y)
                q = deque()
                q.append((x, y))
                visited[x][y] = True
                bfs()
    print(cnt)
