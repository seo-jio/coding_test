import sys

MAX_SIZE = 400
n, k = map(int, input().split())
lines = [0] * (MAX_SIZE + 1)
for i in range(n):
    temp = tuple(map(int, input().split()))
    lines[temp[1]] += temp[0]
max_count = -sys.maxsize

# 바구니의 위치 제한이 없을 경우
# length = max(arr, key= lambda x:x[1])
# candies = [0] * length + 1

for i in range(k, MAX_SIZE-k):
    count = 0
    for j in range(i - k, i + k + 1):
        count += lines[j]
    print(f"i:{i}, count:{count}")
    max_count = max(max_count, count)
print(max_count)