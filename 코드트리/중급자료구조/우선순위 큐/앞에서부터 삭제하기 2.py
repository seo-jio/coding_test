#문제 접근 방식이 새롭다!
import heapq
n = int(input())
arr = list(map(int, input().split()))
hq = []
heapq.heappush(hq, arr[n-1])

sum_val = arr[n-1]
max_avg = 0
for i in range(n-2, 0, -1):
    heapq.heappush(hq, arr[i])
    sum_val += arr[i]
    k = hq[0]
    temp_avg = (sum_val-k) / (n - i - 1)
    max_avg = max(max_avg, temp_avg)
print(f'{max_avg:.2f}')