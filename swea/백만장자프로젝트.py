T = int(input())
for test_case in range(1, T + 1):
    n = int(input())
    arr = list(map(int, input().split()))
    profit = 0
    num = arr[n-1]
    for i in range(n-1, 0, -1):
        if arr[i-1] <= num:
            profit += num - arr[i-1]
        else:
            num = arr[i-1]
    print(f"#{test_case} {profit}")
