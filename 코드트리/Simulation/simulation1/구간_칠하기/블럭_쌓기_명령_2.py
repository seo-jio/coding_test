n, k = map(int, input().split())
block = [0] * (n + 1)
arr = []
for i in range(k):
    arr.append(tuple(map(int, input().split())))

for a in arr:
    start, end = a
    for i in range(start, end + 1):
        block[i] += 1


print(max(block))