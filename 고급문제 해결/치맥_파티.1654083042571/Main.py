import math

def solve_temp(a, b, t):
    if b >= a:  #a와 b중 큰 값은 bigger, 작은 값은 smaller에 넣어준다.
        bigger = b
        smaller = a
    else:
        bigger = a
        smaller = b
    bigger_count = 0  #큰 값의 개수를 의미
    result = []  #인덱스는 큰 값의 개수, 값은 [작은값의 개수, 남은시간]을 의미한다.
    while bigger*bigger_count <= t: #큰 값의 개수를 하나씩 늘려가며 작은 값이 몇개 들어가고 그에 따른 남은 시간은 얼마인지 구한다.
        left = t - bigger*bigger_count
        smaller_count = left // smaller
        beer = left % smaller
        result.append([smaller_count, beer])
        bigger_count += 1

    max_count = 0  #남은 시간이 없을 경우 최대 치킨 개수를 저장할 변수
    min_beer = math.inf #남은 시간이 있을 경우 남은 시간의 최솟값을 저장할 변수
    min_beer_max = 0 #남은 시간이 있으며 동일할 경우 최대 치킨 개수를 저장할 변수
    temp = -1  #남은 시간이 있는 경우 어떤 조합이 가장 많은 치킨을 먹을 수 있는지를 저장할 변수
    for i in range(len(result)):
        if result[i][1] == 0:  #남은 시간이 없을 경우
            if i + result[i][0] > max_count:
                max_count = i + result[i][0]
        else:  #남은시간이 있을 경우
            if result[i][1] < min_beer:  #result 값을 돌며 남은 시간이 더 작을경우 값을 교체
                min_beer = result[i][1]
                min_beer_max = i + result[i][0]
                temp = i
            elif result[i][1] == min_beer: #result 값을 돌며 남은 시간이 같을 경우 최대 치킨 수 업데이트
                if i + result[i][0] > min_beer_max:
                    min_beer_max = i + result[i][0]
                    temp = i
    return max_count, temp, result

a, b, t = [int(x) for x in input().split()]
k, j, temp_list = solve_temp(a, b, t)
if k != 0:
    print(k)
else:
    print(j + temp_list[j][0], temp_list[j][1])
    
#구현 방법
#-> a와 b중 큰 값을 먼저 골라낸 후 인덱스는 먹는데 더 오랜 시간이 걸리는 치킨의 개수, 해당하는 값은 [먹는데 덜 오래 걸리는 치킨의 개수, 남은시간]을 저장하는 result 리스트에 먹는데 더 오랜 시간이 걸리는 치킨을 하나씩 늘려가며 result 리스트 값 업데이트. 그 후 result 리스틀 확인하며 남은 시간이 0인 경우 남은시간이 0인 경우 중 먹을 수 있는 치킨의 수가 최대인 경우를 찾아주고, result 리스트에 남은시간이 0이 아닐 경우 0이 아닌 경우 중 먹을 수 있는 치킨이 최대인 경우를 찾아준다. 위 두 과정을 시간 단축을 위해 하나의 for문안에서 수행하였다. 

#수행시간
#-> while문을 통해 인덱스는 먹는데 더 오랜 시간이 걸리는 치킨의 개수, 해당하는 값은 [먹는데 덜 오래 걸리는 치킨의 개수, 남은시간]을 저장하는 result 리스트에 먹는데 더 오랜 시간이 걸리는 치킨을 하나씩 늘려가며 result 리스트 값을 업데이트 할 때 최악의 경우 먹는데 걸리는 시간이 둘다 1초일 경우 O(n), result리스틀 돌며 남은 시간이 0인 경우, 남은 시간이 0이 아닌 경우를 구분하여 최대 먹을 수 있는 치킨을 찾는데 최악의 경우 먹는데 걸리는 시간이 둘 다 1초이면 남은 시간도 없으므로 O(n)이 걸려 총 수행시간은 O(2n)이 걸린다. 