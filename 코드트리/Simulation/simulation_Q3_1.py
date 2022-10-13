n = int(input())
arr = []
for i in range(n):
    arr.append(int(input()))
end_array = n


def cut(start, end):
    global end_array
    temp = [0 for _ in range(end_array)]
    end_temp = 0

    for i in range(start, end + 1):  # 삭제한 위치의 값으로 0으로 변경
        arr[i] = 0

    for elem in arr:
        if elem != 0:  # 삭제되지 않은 곳들을 temp 리스트의 값으로 넣어준다.
            # print(f"end_temp : {end_temp}")
            temp[end_temp] = elem
            end_temp += 1

    # temp와 arr을 일치 시킨다.
    for k in range(end_array):
        arr[k] = temp[k]
    end_array = end_temp


for _ in range(2):
    start, end = map(int, input().split())
    start, end = start - 1, end - 1  # 인덱스가 0부터 시작하기 때문에 1씩 빼줌
    cut(start, end)

print(end_array)
for i in range(end_array):
    print(arr[i])
