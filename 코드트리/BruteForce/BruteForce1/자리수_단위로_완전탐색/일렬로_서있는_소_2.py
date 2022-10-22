n = int(input())
arr = [0] + list(map(int, input().split()))
count = 0

for i in range(1, n+1):
    for j in range(i+1, n+1):
        for k in range(j+1, n+1):
            if arr[i] <= arr[j] <= arr[k]:
                count += 1

print(count)