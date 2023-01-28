from collections import deque

n, k = map(int, input().split())
grid = [
    list(map(int, input().split()))
    for _ in range(n)
]

r, c = map(int, input().split())
r, c = r-1, c-1

def in_range(x, y):
    return x >= 0 and x < n and y >= 0 and y < n

def can_go(x, y):
    if not in_range(x, y) or visited[x][y] or grid[x][y] >= grid[r][c]:
        return False
    return True

def bfs():
    global max_num
    while que:
        x, y = que.popleft()
        for dx, dy in zip(dxs, dys):
            nx, ny = x + dx, y + dy
            if can_go(nx, ny):
                max_num = max(max_num, grid[nx][ny])
                visited[nx][ny] = True
                que.append((nx, ny))


def can_move(x, y): #현재 이동할 수 있는 칸이 있는 지 확인
    flag = 1
    for dx, dy in zip(dxs, dys):
        nx, ny = x + dx, y + dy
        if in_range(nx, ny) and grid[nx][ny] < grid[x][y]:
            flag = 0
    if flag == 0:
        return True
    else:
        return False

def find(): #최댓값 중 우선순위가 높은 위치 찾기
    global max_num
    for x in range(n): #(0,0)에서 부터 오른 쪽 밑으로 쭉 확인하며 가장 먼저 마주한느 최댓값이 우선순위가 가장 높다.
        for y in range(n):
            if grid[x][y] == max_num and visited[x][y]:
                return x, y

dxs = [0, 1, 0, -1]
dys = [1, 0, -1, 0]
for i in range(k):
    visited = [
        [False] * n
        for _ in range(n)
    ]
    if not can_move(r, c):
        break
    que = deque()
    que.append((r, c))
    visited[r][c] = True
    max_num = -1
    bfs() #bfs를 통해 이동할 수 있는 모든 칸들을 찾음
    r, c = find()

print(r+1, c+1)