from collections import defaultdict

T = int(input())


def dfs(vertex, depth):
    global max_depth
    max_depth = max(max_depth, depth)
    for child in nodes[vertex]:
        if not visited[child]:
            visited[child] = True
            dfs(child, depth + 1)
            visited[child] = False


for tc in range(1, T+1):
    n, m = map(int, input().split())
    if n == 1:
        print(f"#1 1")
        continue
    nodes = defaultdict(list)
    for i in range(m):
        start, end = map(int, input().split())
        nodes[start].append(end)
        nodes[end].append(start)

    ans = 0
    max_depth = 0
    visited = [False] * (n + 1)  # 1번 노드부터 시작
    for i in range(1, n+1):
        visited[i] = True
        depth = 1
        dfs(i, depth)
        visited[i] = False
        ans = max(ans, max_depth)
    print(f"#{tc} {ans}")