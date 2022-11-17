from collections import Counter
import math

n = int(input())
grid = [
    list(map(int, input().split()))
    for _ in range(n)
]

visited = [
    [False] * n
    for _ in range(n)
]

def is_possible(x, y):
    for dx, dy in zip(dxs, dys):
        nx, ny = x + dx, y + dy
        if visited[nx][ny]:
            return False
    return True

def backtrack(cnt):
    global n, min_sum, temp_sum
    if cnt == 3:
        min_sum = min(min_sum, temp_sum)
        return

    for x in range(1, n-1):
        for y in range(1, n-1):
            if is_possible(x, y):
                for dx, dy in zip(dxs, dys):
                    nx, ny = x + dx, y + dy
                    visited[nx][ny] = True
                    temp_sum += grid[nx][ny]

                backtrack(cnt + 1)

                for dx, dy in zip(dxs, dys):
                    nx, ny = x + dx, y + dy
                    visited[nx][ny] = False
                    temp_sum -= grid[nx][ny]




dxs = [0, 0, 1, 0, -1]
dys = [0, 1, 0, -1, 0]

min_sum = math.inf
temp_sum = 0
backtrack(0)
print(min_sum)