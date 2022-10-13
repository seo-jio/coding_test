from collections import deque

n = int(input())
r1, c1, r2, c2 = map(int, input().split())
r1, c1, r2, c2 = r1-1, c1-1, r2-1, c2-1


visited = [
    [False for _ in range(n)]
    for _ in range(n)
]

step = [  #각 칸마의 최단경로 값을 저장할 격자
    [0 for _ in range(n)]
    for _ in range(n)
]

q = deque()

dxs = [-2, -1, 1, 2, 2, 1, -1, -2]
dys = [1, 2, 2, 1, -1, -2, -2, -1]


def in_range(x, y):
    return x >= 0 and x < n and y >= 0 and y < n


def can_go(x, y):
    if not in_range(x, y):
        return False
    if visited[x][y]:
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


if r1 == r2 and c1 == c2: #시작점과 도착점이 같을 경우
    print(0)
else:
    visited[r1][c1] = True
    q.append((r1, c1))
    bfs()
    if step[r2][c2] != 0:
        print(step[r2][c2])
    else:
        print(-1)