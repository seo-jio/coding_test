n = int(input())
grid = [
    list(map(int, input().split()))
    for _ in range(n)
]

dp = [
    [0 for _ in range(n)]
    for _ in range(n)
]

def init():
    dp[0][0] = grid[0][0]
    for i in range(1, n):
        dp[0][i] = min(dp[0][i-1], grid[0][i])
    for i in range(1, n):
        dp[i][0] = min(dp[i-1][0], grid[i][0])

init()
for r in range(1, n):
    for c in range(1, n):
        dp[r][c] = min(max(dp[r-1][c], dp[r][c-1]), grid[r][c])

print(dp[n-1][n-1])
