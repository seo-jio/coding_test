import heapq

n, m = map(int, input().split())
hq = []
for i in range(n):
    x, y = map(int, input().split())
    heapq.heappush(hq, ((abs(x) + abs(y), x, y)))

for i in range(m):
    s, x, y = heapq.heappop(hq)
    x, y = x+2, y+2
    heapq.heappush(hq, ((abs(x) + abs(y), x, y)))
print(hq[0][1], hq[0][2])