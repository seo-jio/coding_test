#인접 리스트 사용, O(ElogV)

import heapq
from collections import defaultdict
import math

def dijkstra():
    while hq:
        min_idx, min_dis = heapq.heappop(hq)
        if dist[min_idx] != min_dis: #갱신된 후 남아있던 잔재일 경우
            continue

        for idx, dis in dic[min_idx]: #dist 갱신
            new_dis = dist[min_idx] + dis
            if dist[idx] > new_dis:
                dist[idx] = new_dis
                heapq.heappush(hq, (idx, new_dis))


n, m = map(int, input().split())
k = int(input()) #시작 위치

dic = defaultdict(list)
for i in range(m): #인접 리스트로 표현
    s, e, w = map(int, input().split())
    dic[s].append((e, w))
    dic[e].append((s, w))

hq = []
heapq.heappush(hq, (k, 0))

dist = [math.inf] * (n+1)
dist[k] = 0 #시작점 초기화
dijkstra()
for i in range(1, n+1):
    if dist[i] == math.inf:
        print(-1)
    else:
        print(dist[i])