import sys

n = int(input())
arr = [0] * 101 #0은 제외하고 1~100까지 가능
min_idx = sys.maxsize
max_idx = -sys.maxsize

for i in range(n):
    tup = tuple(input().split())
    idx = int(tup[0])
    arr[idx] = tup[1]
    if idx > max_idx:
        max_idx = idx
    if idx < min_idx:
        min_idx = idx

max_size = -sys.maxsize

def is_possible(start, k):
    end = start + k # 끝 지점
    if end > 100:
        return Falseㄱ허
    if arr[start] != 0 and arr[end] != 0: #시작 점과 끝 지점에 사람이 있는 경우
        g_count = 0
        h_count = 0
        for i in range(start, end+1):
            if arr[i] == "G":
                g_count += 1
            elif arr[i] == "H":
                h_count += 1
        if g_count == h_count or h_count == 0 or g_count == 0:
            return True
    return False

if n == 1: #k가 0인 경우
    print(0)
else:
    # 최대 거리 = 가장 뒤에 있는 사람과 가장 앞에 있는 사람 사이의 거리의 차
    for k in range(1, max_idx - min_idx): #k == 거리
        for i in range(min_idx, max_idx+1): #가장 앞에 있는 사람의 위치부터 가장 뒤에 있는 사람의 위치까지
            if is_possible(i, k):
                # print(f"i:{i}, k:{k}")
                max_size = k
    print(max_size)