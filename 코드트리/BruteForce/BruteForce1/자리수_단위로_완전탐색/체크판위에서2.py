r, c = map(int, input().split())
grid = [
    list(input().split())
    for _ in range(r)
]
count = 0
if grid[0][0] != grid[r-1][c-1]:
    for i in range(1, r-1):
        for j in range(1, c-1):
            for k in range(i+1, r-1):
                for l in range(j+1, c-1):
                    if grid[i][j] != grid[0][0] and grid[k][l] == grid[0][0]:
                        count += 1

print(count)