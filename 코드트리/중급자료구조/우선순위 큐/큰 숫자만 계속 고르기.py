import heapq

n, m = map(int, input().split())
arr = list(map(int, input().split()))
hq = []
for i in range(n):
    heapq.heappush(hq, -arr[i])

for i in range(m):
    re = heapq.heappop(hq)
    re += 1
    heapq.heappush(hq, re)
print(-hq[0])