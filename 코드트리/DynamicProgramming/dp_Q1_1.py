n = int(input())

dp = [0 for _ in range(n+1)]

def init():
    if n == 2:
        dp[2] = 1
    else: #n이 3보다 큰 경우
        dp[2] = 1
        dp[3] = 1

init()
for i in range(4, n+1):
    dp[i] = dp[i-2] + dp[i-3]

for elem in dp:
    print(elem, end=' ')
print()
print(dp[n])
