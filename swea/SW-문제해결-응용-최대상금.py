# T = int(input())
# for test_case in range(1, T + 1):
#     tup = tuple(input().split())
#     count = int(tup[1]) #교환 횟수
#     nums = (list(map(int, tup[0]))) #숫자 판
#     nums.sort() #숫자 판 정렬
#

arr = [[1, 2], [1, 1], [2, 1], [3, 1]]
arr.sort(key = lambda x: x[0]) #내부 리스트의 첫 번째 원소를 기준으로 오름차순 정렬
print(arr)
arr.sort(key = lambda x: -x[0]) #내부 리스트의 첫 번째 원소를 기준으로 내림차순 정렬
print(arr)
arr.sort(key = lambda x: (x[0], x[1])) #내부 리스트의 첫번째 원소를 기준으로 오름차순 정렬을 하는데 같을 경우 두 번쨰 원소를 비교하여 정렬
print(arr)