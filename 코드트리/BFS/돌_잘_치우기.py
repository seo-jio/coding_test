from collections import deque
from itertools import combinations

n, k, m = map(int, input().split())
grid = [
    list(map(int, input().split()))
    for _ in range(n)
]

starts = []
for i in range(k):
    x, y = map(int, input().split())
    starts.append((x,y))

def in_range(x, y):
    return x >= 0 and x < n and y >= 0 and y < n

def can_go(x, y):
    if in_range(x, y) and new_grid[x][y] == 0 and not visited[x][y]:
        return True
    return False

def bfs():
    dxs = [-1, 1, 0, 0]
    dys = [0, 0, -1, 1]

    while len(dq) != 0:
        x, y = dq.popleft()  # tuple unpacking
        for dx, dy in zip(dxs, dys):
            nx, ny = x + dx, y + dy
            if can_go(nx, ny):
                dq.append((nx, ny))
                visited[nx][ny] = True

rocks = []
for x in range(n):
    for y in range(n):
        if grid[x][y] == 1:
            rocks.append((x, y))

combinations = list(combinations(rocks, m)) #지울 돌을 뽑음

max_count = 0
for i in range(len(combinations)):
    new_grid = [item[:] for item in grid] #grid 복사
    for tup in combinations[i]:  #돌을 제거한 격자 새로 생성
        x, y = tup
        new_grid[x][y] = 0

    visited = [
        [False] * n
        for _ in range(n)
    ]

    dq = deque()
    for x, y in starts:
        dq.append((x - 1, y - 1))  # 0,0 부터 시작하므로 1씩 뺴줌
        visited[x - 1][y - 1] = True
    bfs()

    count = 0
    for row in visited:
        for elem in row:
            if elem:
                count += 1

    max_count = max(max_count, count)
print(max_count)

