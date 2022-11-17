from collections import defaultdict
from collections import deque



def bfs():
    global max_depth, ans
    while len(q) > 0:
        parent, depth = q.popleft()

        if depth > max_depth:
            max_depth = depth
            ans = parent
        elif depth == max_depth:
            ans = max(ans, parent)

        if len(dic[parent]) == 0:
            continue
        for child in dic[parent]:
            if not visited[child]:
                q.append((child, depth+1))
                visited[child] = True

T = 10
for tc in range(1, T+1):
    n, s = map(int, input().split())
    nodes = list(map(int, input().split()))
    dic = defaultdict(list)
    for i in range(0, n-1, 2):
        dic[nodes[i]].append(nodes[i+1])
    visited = [False] * 101

    q = deque()
    max_depth = 0
    ans = s
    depth_dic = {}

    q.append((s, 0))
    visited[s] = True

    bfs()

    print(f"#{tc} {ans}")



