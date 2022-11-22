n, m = map(int, input().split())
grid = [
    [0] * m
    for _ in range(n)
]

def in_range(x, y):
    return x >= 0 and x < n and y >= 0 and y < m

def can_go(x, y):
    if in_range(x, y) and grid[x][y] == 0:
        return True
    return False

dxs = [0, 1, 0, -1]
dys = [1, 0, -1, 0]

cur = 1
grid[0][0] = cur
dir_num = 0
x, y = 0, 0

while cur != n*m:
    nx, ny = x + dxs[dir_num], y + dys[dir_num]
    if not can_go(nx, ny):
        dir_num = (dir_num + 1) % 4
        nx, ny = x + dxs[dir_num], y + dys[dir_num]
    cur += 1
    grid[nx][ny] = cur
    x, y = nx, ny

for row in grid:
    print(*row)
