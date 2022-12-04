#특정 정점을 잘 잡아 정점 a, b, c 중 가장 가까운 정점까지의 거리가 최대가 되도록 하는 프로그램을 작성
#=> a,b,c를 시작점으로 다익스트라를 수행 후 나온 dist 3개를 비교하여 각 자리마다 dist 3개 중 최솟값을 원소로 갖는 abc_dist를 생성!!

import heapq, math
from collections import defaultdict

def dijkstra(k):
    global max_dis
    start = k
    dist = [math.inf] * (n + 1)
    dist[start] = 0
    hq = []
    heapq.heappush(hq, (0, start))

    while hq:
        min_dis, min_idx = heapq.heappop(hq)
        if min_dis != dist[min_idx]:
            continue
        for idx, dis in dic[min_idx]:
            new_dis = dist[min_idx] + dis
            if new_dis < dist[idx]:
                dist[idx] = new_dis
                heapq.heappush(hq, (new_dis, idx))

    # print(dist)
    for i in range(1, n+1):
        abc_dis[i] = min(abc_dis[i], dist[i])

n, m = map(int, input().split())
a, b, c = map(int, input().split())
dic = defaultdict(list)
for i in range(m):
    s, e, w = map(int, input().split())
    dic[s].append((e, w))
    dic[e].append((s, w))

abc_dis = [math.inf] * (n+1)

dijkstra(a)
dijkstra(b)
dijkstra(c)

# print(abc_dis)
abc_dis[0] = -math.inf
print(max(abc_dis))