import math

r, c = map(int, input().split())
grid = [
    list(input())
    for _ in range(r)
]

ans = [row[:] for row in grid]

def in_range(x, y):
    return x >= 0 and x < r and y >= 0 and y < c

def is_sink(x, y):
    dxs = [0, 1, 0, -1]
    dys = [1, 0, -1, 0]
    cnt = 0
    for dx, dy in zip(dxs, dys):
        nx, ny = x + dx, y + dy
        if not in_range(nx, ny) or grid[nx][ny] == '.':
            cnt += 1
    if cnt == 3 or cnt == 4:
        return True
    else:
        return False

for x in range(r):
    for y in range(c):
        if grid[x][y] == 'X':
            if is_sink(x, y):
                ans[x][y] = '.'


min_x, min_y = math.inf, math.inf
max_x, max_y = -math.inf, -math.inf
for x in range(r):
    for y in range(c):
        if ans[x][y] == 'X':
            min_x = min(min_x, x)
            min_y = min(min_y, y)
            max_x = max(max_x, x)
            max_y = max(max_y, y)

for x in range(min_x, max_x + 1):
    for y in range(min_y, max_y + 1):
        print(ans[x][y], end='')
    print()