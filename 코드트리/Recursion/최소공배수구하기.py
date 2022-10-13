# 최소 공배수 뜻을 제대로 몰랐었다...
# 최소 공배수 = a * b // gcd(최대공약수)

def lcm(a, b):
    for i in range(min(a, b), a*b+1):
        if i % a == 0 and i % b == 0:
            return i

def solve(n):
    if n == 0:
        return arr[0]
    return lcm(solve(n-1), arr[n])

n = int(input())
arr = list(map(int, input().split()))
print(solve(n-1))
