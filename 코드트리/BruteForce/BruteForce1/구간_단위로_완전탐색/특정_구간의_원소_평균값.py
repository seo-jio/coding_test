n = int(input())
arr = list(map(int, input().split()))

count = 0
for i in range(n):
    for j in range(i, n):
        temp = arr[i:j+1]
        mean = sum(temp) / len(temp)
        if mean in temp:
            count += 1

print(count)