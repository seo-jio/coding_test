n, m = map(int, input().split())
arr = [
    [0 for _ in range(n+1)]
    for _ in range(n+1)
]

visited = [False for _ in range(n+1)] #방문 여부 관리

for i in range(m):  #간선 정보 이차원 배열에 입력
    start, end = map(int, input().split())
    arr[start][end] = 1
    arr[end][start] = 1

count = 0

def dfs(vertex):
    global count
    for cur_v in range(1, n+1):
        if arr[vertex][cur_v] and not visited[cur_v]:
            visited[cur_v] = True
            count += 1
            dfs(cur_v)

root_vertex = 1
visited[root_vertex] = True
dfs(root_vertex)
print(count)