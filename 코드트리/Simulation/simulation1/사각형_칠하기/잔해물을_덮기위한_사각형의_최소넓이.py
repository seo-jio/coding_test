grid = [
    [0] * 2000
    for _ in range(2000)
]

arr = [0]
for i in range(2):
    arr.append(tuple(map(int, input().split())))

def paint(x1, y1, x2, y2, num):
    x1, y1, x2, y2 = x1 + 1000, y1 + 1000, x2 + 1000, y2 + 1000
    for x in range(x1, x2):
        for y in range(y1, y2):
            grid[x][y] = num

for i in range(1, len(arr)):
    x1, y1, x2, y2 = arr[i]
    paint(x1, y1, x2, y2, i)

flag = 0
min_x, min_y = 2000, 2000
max_x, max_y = 0, 0
for x in range(2000):
    for y in range(2000):
        if grid[x][y] == 1:
            flag = 1
            min_x = min(min_x, x)
            min_y = min(min_y, y)
            max_y = max(max_y, y)
            max_x = max(max_x, x)

if flag == 0:
    print(0)
else:
    print((max_x - min_x + 1) * (max_y - min_y + 1))