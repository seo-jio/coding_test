import math

v, e = map(int, input().split())
grid = [
    [math.inf] * (v+1)
    for _ in range(v+1)
]

for i in range(e):
    s, e, w = map(int, input().split())
    grid[s][e] = w

for k in range(1, v+1):
    for i in range(1, v+1):
        for j in range(1, v+1):
            grid[i][j] = min(grid[i][j], grid[i][k] + grid[k][j])

min_cycle = math.inf
for x in range(1, v+1):
    for y in range(1, v+1):
        if x == y:
            continue
        min_cycle = min(min_cycle, grid[x][y] + grid[y][x])

if min_cycle != math.inf:
    print(min_cycle)
else:
    print(-1)