import sys

n, k = map(int, input().split())
arr = list(map(int, input().split()))

def is_possible(i):
    possible = []
    for idx, elem in enumerate(arr):
        if elem <= i:
            possible.append(idx)
    for i in range(1, len(possible)):
        if possible[i] - possible[i-1] > k:
            return False
    return True

# max_num = 0
for i in range(max(arr[0], arr[-1]), 101): #시작점과 끝점은 무조건 가야만 함을 생각!
    if is_possible(i):
        print(i)
        break
