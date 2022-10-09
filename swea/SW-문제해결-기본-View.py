T = 10
for test_case in range(1, T + 1):
    n = int(input())
    arr = list(map(int, input().split()))
    count = 0
    for i in range(2, n-2):
        if max(arr[i-2], arr[i-1], arr[i], arr[i+1], arr[i+2]) == arr[i]:
            count += arr[i] - max(arr[i-2], arr[i-1], arr[i+1], arr[i+2])
    print(f"#{test_case} {count}")