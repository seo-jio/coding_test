import heapq

# A[1] 부터 시작
# change => A[i] = max(A[i] + idx, idx), 특정 원소에 적용
# change 몇번을 해야지 len(list_) = n,    sum(list) >= 2*n
# change는 원소당 한 번만 가능
#
# pypy 20초
#
# 4 <= N <= 1000

T = int(input())
for tc in range(1, T+1):
    n = int(input())
    list1 = [-12, -12, -12, -11, -10, -8, -8, -6, -6, -5, -3, -2, 0, 1, 1, 2, 2, 2, 3, 5]
    list2 = []
    print(sum(list1))
    for i in range(len(list1)):
        list2.append((-(max(list1[i] + i+1, i+1) - list1[i]), i))

    print(list2)
    heapq.heapify(list2)
    result = sum(list1)

    n = len(list1)
    cnt = 0
    while result < 2*n:
        x = heapq.heappop(list2)
        list1[x[1]] -= x[0]
        cnt += 1
        result -= x[0]
        print(f"# result : {result}")
    print(f"#{tc} {cnt}")


