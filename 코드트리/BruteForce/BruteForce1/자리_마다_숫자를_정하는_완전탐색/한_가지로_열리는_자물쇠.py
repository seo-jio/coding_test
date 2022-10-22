n = int(input())
arr = list(map(int, input().split()))

count = 0
for i in range(1, n+1):
    for j in range(1, n+1):
        for k in range(1, n+1):
            if abs(arr[0] - i) <= 2 or abs(arr[1] - j) <= 2 or abs(arr[2] - k) <= 2:
                count += 1

print(count)