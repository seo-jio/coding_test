# 다익스트라 by 인접 행렬 O(V^2)
import math

def dijkstra(start):
    for i in range(1, n+1): #노드의 수 만큼 반복
        min_idx = -1
        for j in range(1, n+1): #최소 dist값을 갖는 노드 선택
            if visited[j]: #방문했던 노드라면 넘어감
                continue
            if min_idx == -1 or dist[min_idx] > dist[j]: #최소 dist를 갖는 노드 선택
                min_idx = j

        visited[min_idx] = True #방문 처리

        for j in range(1, n+1): #dist 업데이트
            if grid[min_idx][j] != 0:
                dist[j] = min(dist[j], dist[min_idx] + grid[min_idx][j])


n, m = map(int, input().split())
grid = [
    [0] * (n+1)
    for _ in range(n+1)
]
for i in range(m):
    x, y, w = map(int, input().split())
    grid[x][y] = w

visited = [False] * (n+1) #방문 배열 처리를 위한 초기화
dist = [math.inf] * (n+1) #각 노드에 도달하는 최단 거리를 기록할 배열
dist[1] = 0 # 시작점 초기화
dijkstra(1)
for i in range(2, n+1):
    if dist[i] != math.inf:
        print(dist[i])
    else:
        print(-1)

