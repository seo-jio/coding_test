T = int(input())
for test_case in range(1, T + 1):
    tup = tuple(input().split())
    count = int(tup[1]) #교환 횟수
    nums = (list(map(int, tup[0]))) #숫자 판
    nums.sort() #숫자 판 정렬


