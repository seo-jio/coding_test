import sys

n = int(input())
nums = list(map(int, input().split()))
min_diff = sys.maxsize

for i in range(n):
    temp = nums[:]
    temp[i] *= 2
    for j in range(n):
        temp2 = []
        for k, elem in enumerate(temp):
            if j == k:
                continue
            temp2.append(elem)
        diff = 0
        for l in range(len(temp2)-1):
            diff += abs(temp2[l+1] - temp2[l])
        min_diff = min(min_diff, diff)
print(min_diff)