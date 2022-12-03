#최단 경로를 사전 순으로 출력
import math, heapq
from collections import defaultdict

def dijkstra():
    while hq:
        min_idx, min_dis = heapq.heappop(hq)
        if dist[min_idx] != min_dis:
            continue
        for idx, dis in dic[min_idx]:
            new_dis = dist[min_idx] + dis
            if dist[idx] > new_dis:
                dist[idx] = new_dis
                heapq.heappush(hq, (idx, new_dis))

n, m = map(int, input().split())
dic = defaultdict(list)
for i in range(m):
    s, e, d = map(int, input().split())
    dic[e].append((s, d)) #거꾸로 뒤집어 줌
    dic[s].append((e, d))
# print(dic)

start, end = map(int, input().split())
dist = [math.inf] * (n+1)
dist[end] = 0

hq = []
heapq.heappush(hq, (end, 0))

dijkstra()
# print(dist)

ans = []
x = start
ans.append(x)
while x != end:
    flag = 0
    for i in range(1, n+1):
        for idx, dis in dic[i]:
            if idx == x and dist[x] == (dist[i] + dis):
                x = i
                ans.append(x)
                flag = 1
                break
        if flag == 1:
            break
# print(ans)

print(dist[start])
for i in ans:
    print(i, end=' ')


