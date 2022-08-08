n, m = map(int, input().split())

arr = []
#cur_num : 현재 가리키는 곳이 앞에서 부터 몇 번째 자리 수 인지

def find_combination(cur_num, cnt):  #cur_num번째 위치에 0또는 1을 넣어준다.
    if cur_num == n+1:
        if cnt == m:
            for elem in arr:
                print(elem, end=' ')
            print()
        return

    #선택되는 경우
    arr.append(cur_num)
    find_combination(cur_num+1, cnt+1)
    arr.pop()

    #선택되지 않는 경우
    find_combination(cur_num + 1, cnt)

find_combination(1, 0)
