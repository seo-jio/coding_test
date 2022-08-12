n = int(input())
arr = [
    list(map(int, input().split()))
    for _ in range(n)
]

dp = [
    [0 for _ in range(n)]
    for _ in range(n)
]

def init():  #초기화
    dp[0][0] = arr[0][0]
    for i in range(1, n):
        dp[i][0] = dp[i-1][0] + arr[i][0]
    for i in range(1, n):
        dp[0][i] = dp[0][i-1] + arr[0][i]

init()
for x in range(1, n):
    for y in range(1, n):
        dp[x][y] = max(dp[x][y-1], dp[x-1][y]) + arr[x][y] #점화식 

print(dp[n-1][n-1])