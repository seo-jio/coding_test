from itertools import combinations
import math

T = int(input())

for tc in range(1, T+1):
    n, b = map(int, input().split())
    height = list(map(int, input().split()))
    min_sum = math.inf
    for i in range(1, n+1):
        ans = []
        for tup in combinations(height, i):
            temp_sum = sum(tup)
            if temp_sum >= b:
                min_sum = min(min_sum, temp_sum)
        if min_sum == b:
            break
    print(f"#{tc} {min_sum - b}")



