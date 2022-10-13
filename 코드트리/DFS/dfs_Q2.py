n, m = map(int, input().split())
grid = [  #뱀의 위치를 저장할 격자
    list(map(int, input().split()))
    for _ in range(n)
]

visited = [  #방문 여부를 관리할 격자
    [False for _ in range(m)]
    for _ in range(n)
]


dxs = [1, 0]
dys = [0, 1]

def in_range(x, y): #격자 내 좌표인지 확인
    return x >= 0 and x < n and y >= 0 and y < m

def can_go(x, y):  #다음 위치가 갈 수 있는 위치인지 확인
    if not in_range(x, y): #범위 조건 부터 먼저 확인한다
        return False
    if visited[x][y] or grid[x][y] == 0: #방문했거나 뱀이 있을 경우
        return False
    return True

flag = 0

def dfs(x, y):
    global flag
    if x == n-1 and y == m-1:
        flag = 1
        return
    for dx, dy in zip(dxs, dys):
        nx, ny = x + dx, y + dy
        if can_go(nx, ny):
            visited[nx][ny] = True
            dfs(nx, ny)

visited[0][0] = True
dfs(0, 0)

if flag == 1:
    print(1)
else:
    print(0)