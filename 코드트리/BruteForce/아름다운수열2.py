# n, m = map(int, input().split())
# listA = list(map(int, input().split()))
# listB = list(map(int, input().split()))
#
# visited = [0] * 101
# temp = []
# permutations = []
#
# def permutation(cur_num):
#     print(f"cur_num ; {cur_num}")
#     if cur_num == len(listB) + 1:
#         permutations.append(temp[:]) # 슬라이싱을 통해 새로운 배열을 생성하여 append
#         return
#     for b in listB:
#         if visited[b] == 1:
#             continue
#         else:
#             visited[b] = 1
#             temp.append(b)
#             permutation(cur_num+1)
#             temp.pop()
#             visited[b] = 0
#
# def solve():
#     count = 0
#     for i in range(len(listA) - len(listB) + 1):
#         print(listA[i:i+len(listB)])
#         if listA[i:i+len(listB)] in permutations:
#             count += 1
#     return count
#
# permutation(1)
# print(permutations)
# print(solve())

#======================================#

n, m = map(int, input().split())
listA = list(map(int, input().split()))
listB = list(map(int, input().split()))

def solve():
    count = 0
    for i in range(len(listA) + len(listB) + 1):
        if sorted(listA[i:i+len(listB)]) == sorted(listB):\
            count += 1
    return count

print(solve())

