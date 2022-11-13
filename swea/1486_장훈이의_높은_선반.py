T = int(input())

def combination(cur):
    if cur == n:
        print(ans)
        return
    ans.append(height[cur])
    combination(cur+1)
    ans.pop()

for tc in range(1, T+1):
    n, b = map(int, input().split())
    height = list(map(int, input().split()))
    ans = []
    combination(0)

