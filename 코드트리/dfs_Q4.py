import sys
sys.setrecursionlimit(2500)
#일반적으로 재귀함수가 1000번 정도 돌아가면 "recursion depth exceed 오류가 뜬다." 따라서 재귀함수의 최대 깊이를 지정해줘야한다.
#n,m의 범위가 1~50이기 때문에 재귀함수의 최대 깊이는 50*50인 2500으로 잡아야한다.

n, m = map(int, input().split())
grid = [
    list(map(int, input().split()))
    for _ in range(n)
]

dxs = [0, 1, 0, -1]
dys = [1, 0, -1, 0]

def in_range(x, y):
    return x >= 0 and x < n and y >= 0 and y < m

def can_go(x, y):
    if not in_range(x, y):
        return False
    if visited[x][y] or grid[x][y] <= k:
        return False
    return True

def dfs(x, y):
    for dx, dy in zip(dxs, dys):
        nx, ny = x + dx, y + dy
        if can_go(nx, ny):
            visited[nx][ny] = True
            dfs(nx, ny)

max_k, max_num = -1, -1
for k in range(1, 101):
    visited = [
        [False for _ in range(m)]
        for _ in range(n)
    ]
    count = 0
    for x in range(n):
        for y in range(m):
            if can_go(x, y):
                count += 1
                visited[x][y] = True
                dfs(x, y)
    if max_num < count: #안정영역이 최대 인지 확인 후 최대라면 그 때의 k값과 영역 수를 기억
        max_k = k
        max_num = count

    # 마을 내 가장 높은 집의 높이까지만 for문이 돌도록 break
    if count == 0: #최대 높이 도달 시 count는 0이 나올것이다.
        break

print(max_k, max_num)
