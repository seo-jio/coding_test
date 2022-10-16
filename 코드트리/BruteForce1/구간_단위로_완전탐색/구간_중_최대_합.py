import sys

n, k = map(int, input().split())
nums = list(map(int, input().split()))
max_sum = -sys.maxsize

for i in range(n-k+1):
    total_sum = 0
    for j in range(i, i+k):
        total_sum += nums[j]
    print(f"j : {j} / total_sum: {total_sum}")
    max_sum = max(max_sum, total_sum)

print(max_sum)