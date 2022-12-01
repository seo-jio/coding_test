import heapq, math
from collections import defaultdict

def dijkstra():
    while hq:
        min_idx, min_dis = heapq.heappop(hq)
        if dist[min_idx] != min_dis:
            continue
        for idx, dis in dic[min_idx]:
            new_dis = dist[min_idx] + dis
            if new_dis < dist[idx]:
                dist[idx] = new_dis
                heapq.heappush(hq, (idx, new_dis))

n, m = map(int, input().split())
dic = defaultdict(list)
for i in range(m):
    s, e, w = map(int, input().split())
    dic[e].append((s, w))

dist = [math.inf] * (n+1)
dist[n] = 0
hq = []
heapq.heappush(hq, (n, 0))
dijkstra()

max_dis = 0
for i in range(1, n+1):
    max_dis = max(max_dis, dist[i])
print(max_dis)