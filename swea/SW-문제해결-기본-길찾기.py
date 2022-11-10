from collections import deque
from collections import defaultdict

def bfs():
    while len(q) != 0:
        cur = q.popleft()
        for v in nodes[cur]:
            if not visited[v]:
                visited[v] = True
                q.append(v)

T = 10
for tc in range(T):
    t, m = map(int, input().split())
    arr = list(map(int, input().split()))

    nodes = defaultdict(list)
    visited = [False] * 100
    for i in range(0, len(arr)-1, 2):
        nodes[arr[i]].append(arr[i+1])
    q = deque()
    q.append(0)
    visited[0] = True
    bfs()
    if visited[99]:
        print(f"#{t} {1}")
    else:
        print(f"#{t} {0}")
