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

dxs = [-1, 1, 0, 0]
dys = [0, 0, -1, 1]

q = deque() #deque 사용(import 필요)

def in_range(x, y): #격자 내 좌표인지 확인
    return x >= 0 and x < n and y >= 0 and y < m

def can_go(x, y):  #다음 위치가 갈 수 있는 위치인지 확인
    if not in_range(x, y): #범위 조건 부터 먼저 확인한다
        return False
    if visited[x][y] or grid[x][y] == 0: #방문했거나 뱀이 있을 경우
        return False
    return True

def bfs():
    while q:
        x, y = q.popleft()  #q에 가장 앞에 있는 값을 가져와 현재 위치로 지정
        for dx, dy in zip(dxs, dys):
            nx, ny = x + dx, y + dy
            if can_go(nx, ny):
                visited[nx][ny] = True
                q.append((nx, ny))  #갈 수 있을 경우 q에 가장 뒤에 추가

visited[0][0] = True
q.append((0, 0))
bfs()

if visited[n-1][m-1] == True:
    print(1)
else:
    print(0)