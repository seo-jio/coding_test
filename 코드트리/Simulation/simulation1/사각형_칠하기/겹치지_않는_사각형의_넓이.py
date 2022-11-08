grid = [
    [0] * 2000
    for _ in range(2000)
]
arr = []
for i in range(3):
    arr.append(tuple(map(int, input().split())))

def paint(x1, y1, x2, y2, num):
    x1, y1, x2, y2 = x1 + 1000, y1 + 1000, x2 + 1000, y2 + 1000
    for x in range(x1, x2):
        for y in range(y1, y2):
            grid[x][y] = num


for i in range(3):
    x1, y1, x2, y2 = arr[i]
    if i != 2: #처음 두개 사각형
        paint(x1, y1, x2, y2, 1)
    else:
        paint(x1, y1, x2, y2, 2)

cnt = 0
for x in range(2000):
    for y in range(2000):
        if grid[x][y] == 1:
            cnt += 1

print(cnt)
