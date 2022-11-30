#다익스트라에 경로 표현 추가
import math, heapq
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
                path[idx] = min_idx #경로 기록

n, m = map(int, input().split())
dic = defaultdict(list)
for i in range(m):
    s, e, d = map(int, input().split())
    dic[s].append((e, d))
    dic[e].append((s, d))
A, B = map(int, input().split())

dist = [math.inf] * (n+1)
dist[A] = 0
hq = []
heapq.heappush(hq, (A, 0))
path = [0] * (n+1) # 최단 경로로 갔을 때 바로 직전에 들르는 노드의 번호를 기록
dijkstra()

cur = B
ans = []
while cur != A:
    ans.append(cur)
    cur = path[cur]
ans.append(A)
print(dist[B])
for i in range(len(ans)-1, -1, -1):
    print(ans[i], end=' ')