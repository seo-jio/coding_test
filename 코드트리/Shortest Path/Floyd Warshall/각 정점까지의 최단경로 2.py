import math

n, m = map(int, input().split())
grid = [
    [math.inf] * (n+1)
    for _ in range(n+1)
]

for i in range(m):
    s, e, w = map(int, input().split())
    grid[s][e] = min(grid[s][e], w)

for i in range(1, n+1):
    grid[i][i] = 0

for k in range(1, n+1):
    for i in range(1, n+1):
        for j in range(1, n+1):
            grid[i][j] = min(grid[i][j], grid[i][k] + grid[k][j])

for x in range(1, n+1):
    for y in range(1, n+1):
        if grid[x][y] != math.inf:
            print(grid[x][y], end=' ')
        else:
            print(-1, end=' ')
    print()

