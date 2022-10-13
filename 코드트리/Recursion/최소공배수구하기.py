def solve(n):
    if n == 0:
        return arr[0]
    print(f"{arr[n - 1]}, {arr[n]}")
    if max(arr[n-1], arr[n]) % min(arr[n-1], arr[n]) != 0:
        print("first")
        return solve(n-1) * arr[n]
    else:
        print("second")
        return solve(n-1)

ans = 0
n = int(input())
arr = list(map(int, input().split()))
print(solve(n-1))