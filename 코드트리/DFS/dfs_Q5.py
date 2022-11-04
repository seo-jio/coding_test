n = int(input())
grid = [
    list(map(int, input().split()))
    for _ in range(n)
]

visited= [
    [False] * n
    for _ in range(n)
]

dxs = [0, 1, 0, -1]
dys = [1, 0, -1, 0]

def in_range(x, y):
    return x >= 0 and x < n and y >= 0 and y < n

def can_go(x, y):
    if in_range(x, y) and not visited[x][y]:
        return True
    return False

def dfs(x, y):
    global cnt
    for dx, dy in zip(dxs, dys):
        nx, ny = x + dx, y + dy
        if can_go(nx, ny) and grid[x][y] == grid[nx][ny]:
            cnt += 1
            visited[nx][ny] = True
            dfs(nx, ny)

block_cnt = 0
max_cnt = 0
for x in range(n):
    for y in range(n):
        if not visited[x][y]:
            cnt = 1
            visited[x][y] = True
            dfs(x, y)
            if cnt >= 4:
                block_cnt += 1
            max_cnt = max(max_cnt, cnt)

print(block_cnt, max_cnt)