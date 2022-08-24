import sys

n = int(input())
li = list(map(int, input().split()))
arr = []
min_dif = sys.maxsize
#cur_num : 현재 가리키는 곳이 앞에서 부터 몇 번째 자리 수 인지

def cal_subtract():
    sum = 0
    for i in range(len(arr)):
        if arr[i] == 1:
            sum += li[i]
        else:
            sum -= li[i]
    return abs(sum)

def find_combination(cur_num, cnt):  #cur_num번째 위치에 0또는 1을 넣어준다.
    global min_dif
    if cur_num == len(li)+1:
        if cnt == n:
            for elem in arr:
                print(elem, end=' ')
            print()
            dif = cal_subtract()
            if dif < min_dif:
                min_dif = dif
        return

    #선택되지 않는 경우
    arr.append(0)
    find_combination(cur_num + 1, cnt)
    arr.pop()

    # 선택되는 경우
    arr.append(1)
    find_combination(cur_num + 1, cnt + 1)
    arr.pop()

find_combination(1, 0)
print(min_dif)