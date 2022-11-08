n = int(input())
grid = [
    [0] * 200
    for _ in range(200)
]
arr = []
for i in range(n):
    x1, y1, x2, y2 = map(int, input().split())
    arr.append((x1, y1, x2, y2))

for x1, y1, x2, y2 in arr:
    x1, y1, x2, y2 = x1 + 100, y1 + 100, x2 + 100, y2 + 100
    for x in range(x1, x2):
        for y in range(y1, y2):
            grid[x][y] = 1

cnt = 0
for row in grid:
    for elem in row:
        if elem == 1:
            cnt += 1

print(cnt)