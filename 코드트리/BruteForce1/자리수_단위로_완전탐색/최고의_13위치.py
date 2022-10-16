n = int(input())
grid = [
    list(map(int, input().split()))
    for _ in range(n)
]
count = 0

for x in range(n):
    for y in range(n-2):
        count = max(count, grid[x][y] + grid[x][y+1] + grid[x][y+2])

print(count)
