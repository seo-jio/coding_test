import heapq
n = int(input())
hq = []
for i in range(n):
    k = int(input())
    if k != 0:
        heapq.heappush(hq, k)
    if not hq and k == 0:
        print(0)
    elif hq and k == 0:
        print(heapq.heappop(hq))
