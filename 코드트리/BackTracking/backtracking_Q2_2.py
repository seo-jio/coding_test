n, m, k = map(int, input().split())
dist = list(map(int, input().split()))
arr = []
max_point = 0
horse = [1 for _ in range(k+1)] #1번 인덱스 부터 말의 이동 후 위치를 저장, 말들의 위치는 1부터 시작
#1~n번째 자리의 인덱스에 dist값이 순서대로 존재한다고 생각하고 인덱스에 해당하는 값에 1~k까지의 말을 선택한다고 생각

def cal_point():
    point = 0
    for i in range(1, k+1):  #점수 계산
        if horse[i] >= m:
            point += 1
    return point

def choose(cur_num): #1~n번째 자리에 1~k 까지 값 중 하나를 선택하는 함수
    global max_point
    point = cal_point()
    #10 57 1
    #13 17 13 31 34 24 38 36 20 17
    #이 예제를 돌려보면 말이 한마리인 경우 n번의 턴이 돌기 전에 끝부분에 도달할 수 있기 때문에 최대값 갱신 확인을 종료 조건 밖에 둔다.
    if point > max_point:
        max_point = point
    if cur_num == n+1:
        return
    for i in range(1, k+1):
        if horse[i] >= m:
            continue
        arr.append(i)
        horse[i] += dist[cur_num-1]
        choose(cur_num + 1)
        horse[i] -= dist[cur_num-1]
        arr.pop()

choose(1)
print(max_point)

###################모든 경우를 다 확인하는 경우 코드############################
# n, m, k = map(int, input().split())
# dist = list(map(int, input().split()))
# arr = []
# max_point = 0
# #1~n번째 자리의 인덱스에 dist값이 순서대로 존재한다고 생각하고 인덱스에 해당하는 값에 1~k까지의 말을 선택한다고 생각
#
# def cal_point():
#     point = 0
#     horse = [1 for _ in range(k+1)] #1번 인덱스 부터 말의 이동 후 위치를 저장, 말들의 위치는 1부터 시작
#     for i in range(n):  #말의 위치 이동
#         horse[arr[i]] += dist[i]
#     for i in range(1, k+1):  #점수 계산
#         if horse[i] >= m:
#             point += 1
#     return point
#
# def choose(cur_num): #1~n번째 자리에 1~k 까지 값 중 하나를 선택하는 함수
#     global max_point
#     if cur_num == n+1:
#         point = cal_point()
#         if point > max_point:  #최대 포인트를 갱신할 경우 point 증가
#             max_point = point
#         return
#     for i in range(1, k+1):
#         arr.append(i)
#         choose(cur_num + 1)
#         arr.pop()
#
# choose(1)
# print(max_point)