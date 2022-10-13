import sys

def solve(n):
    if n == 0:
        return arr[0]
    return max(solve(n-1), arr[n])

n = int(input())
arr = list(map(int, sys.stdin.readline().split()))
print(solve(n-1))