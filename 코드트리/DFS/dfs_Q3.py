n = int(input())
grid = [
    list(map(int, input().split()))
    for _ in range(n)
]

visited = [
    [False for _ in range(n)]
    for _ in range(n)
]

dxs = [0, 1, 0, -1]
dys = [1, 0, -1, 0]

def in_range(x, y):
    return x >= 0 and x < n and y >= 0 and y < n

def can_go(x, y):
    if not in_range(x, y):
        return False
    if visited[x][y] or grid[x][y] == 0:
        return False
    return True

def dfs(x, y):
    global count
    for dx, dy in zip(dxs, dys): #우하좌상 확인하며 갈 수 있는지 확인
        nx, ny = x + dx, y + dy
        if can_go(nx, ny):
            count += 1
            visited[nx][ny] = True
            dfs(nx, ny)

#전체 격자를 돌면서 갈 수 있는 지점에서 총 갈 수 있는 칸의 개수를 찾는다.
nums = []
for x in range(n):
    for y in range(n):
        if grid[x][y] == 1 and not visited[x][y]:
            visited[x][y] = True
            count = 1
            dfs(x, y)
            nums.append(count)

print(len(nums))
nums.sort()
for n in nums:
    print(n)