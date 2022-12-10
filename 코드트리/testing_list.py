import heapq
import sys

INT_MAX = sys.maxsize

# 변수 선언 및 입력:
# 정점의 수 : 5, 간선의 수 : 8인 그래프
n, m = 5, 8

graph = [[] for _ in range(n + 1)]
pq = []

# 그래프에 있는 모든 노드들에 대해
# 초기값을 전부 아주 큰 값으로 설정
dist = [INT_MAX] * (n + 1)

# 주어진 간선 정보 (x, y, z)
#               x -> y로 향하는 간선이 있으며, 가중치는 z
edges = [
    (-1, -1, -1),
    (2, 1, 3),
    (1, 4, 3),
    (4, 2, 1),
    (5, 2, 4),
    (5, 4, 2),
    (4, 3, 2),
    (3, 4, 1),
    (1, 3, 6)
]

# 그래프를 인접리스트로 표현합니다.
for i in range(1, m + 1):
    x, y, z = edges[i]
    graph[x].append((y, z))

# 시작위치에는 dist값을 0으로 설정
# 여기서는 시작위치를 5번으로 가정
dist[5] = 0

# 우선순위 큐에 시작점을 넣어줍니다.
# 거리가 가까운 곳이 먼저 나와야 하며
# 해당 지점이 어디인지에 대한 정보도 필요하므로
# (거리, 정점 번호) 형태로 넣어줘야 합니다.
heapq.heappush(pq, (0, 5))

# O(|E|log|V|) 다익스트라 코드
# 우선순위 큐에
# 원소가 남아있다면 계속 진행해줍니다.
while pq:
    # 가장 거리가 가까운 정보를 받아온 뒤, 원소를 제거해줍니다.
    min_dist, min_index = heapq.heappop(pq)

    # 우선순위 큐를 이용하면
    # 같은 정점의 원소가
    # 여러 번 들어가는 문제가 발생할 수 있어
    # min_dist가 최신 dist[min_index]값과 다르다면
    # 계산할 필요 없이 패스해줍니다.
    if min_dist != dist[min_index]:
        continue

    # 최솟값에 해당하는 정점에 연결된 간선들을 보며
    # 시작점으로부터의 최단거리 값을 갱신해줍니다.
    for target_index, target_dist in graph[min_index]:
        # 현재 위치에서 연결된 간선으로 가는 것이 더 작다면
        new_dist = dist[min_index] + target_dist
        if dist[target_index] > new_dist:
            # 값을 갱신해주고, 우선순위 큐에 해당 정보를 넣어줍니다.
            dist[target_index] = new_dist
            heapq.heappush(pq, (new_dist, target_index))

# 시작점(5번 정점)으로부터 각 지점까지의 최단거리 값을 출력합니다.
for i in range(1, n + 1):
    print(dist[i], end=" ")

