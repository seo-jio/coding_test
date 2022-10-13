n = int(input())
arr = [list(map(int, input().split())) for _ in range(n)]

#우하좌상
dxs = [0, 1, 0, -1]
dys = [1, 0, -1, 0]

def in_range(x, y):
    return x >= 0 and x <n and y >= 0 and y < n

result = 0
for x in range(n):
    for y in range(n):
        count = 0
        for dx, dy in zip(dxs, dys):
            nx, ny = x + dx, y + dy
            if in_range(nx, ny) and arr[nx][ny] == 1:
                count += 1
            if count == 3:
                result += 1
                break
print(result)