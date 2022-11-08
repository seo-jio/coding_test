n = int(input())
line = [0] * 200
arr = []
for i in range(n):
    start, end = map(int, input().split())
    start, end = start + 100, end + 100
    arr.append((start, end))

for a in arr:
    start, end = a
    for i in range(start, end):
        line[i] += 1

print(max(line))