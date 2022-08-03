import copy, math
from collections import deque

n, L, k = map(int, input().split())
initial_values = []

for i in range(n):
    temp = list(map(int, input().split()))  #(index, id)
    initial_values.append(temp)

def finalSign(new_values, n):  #절벽으로 떨어지기 전 좀비 id의 마지막 부호를 구한다.
    values = []
    count = 0
    for i in range(len(new_values)):  #아이디 값이 음수인 좀비의 수를 센다.
        if new_values[i][1] < 0:
            count += 1
    for left in range(count):  #0번 인덱스 부터 count-1 번째 좀비까지의 최종 부호는 마이너스이다.
        values.append(-1 * abs(new_values[left][1]))
    for right in range(count, n):  #count번째 좀비부터 마지막 좀비까지의 최종 부호는 플러스이다.
        values.append(abs(new_values[right][1]))
    return values

def timeOnCliff(initial_values, n, L):  #좀비가 절벽에 끝에 서 있는데 까지 걸리는 최종시간을 구함
    values = finalSign(initial_values, n)  #좀비의 최종 부호를 구한다.
    left_count, right_count = noCrash(initial_values, n)  #충돌 없이(방향전환없이) 낭떠러지에 떨어지는 좀비의 수를 구한다.
    result = [0 for i in range(n)]  #좀비가 절벽 끝에 서 있는데 까지 걸린 시간을 저장할 리스트

    ## 다른 좀비와 충돌하지 않는 경우(방향전환이 없는 경우)
    for i in range(left_count):
        result[i] = initial_values[i][0]

    for i in range(n-1, n-right_count-1, -1):
        result[i] = L - initial_values[i][0]

    #다른 좀비와 충돌하는 경우(방향 전환이 있는 경우)
    if left_count + right_count != n:
        plus_dq = deque()
        minus_dq = deque()
        for i in range(left_count, n - right_count):  #인덱스 0번부터 순서대로 아이디 값이 플러스인 좀비들의 초기 인덱스는 plus_dq, 마이너스인 좀비들은 minus_dq에 저장
            if initial_values[i][1] > 0:
                plus_dq.append(initial_values[i][0])
            else:
                minus_dq.append(initial_values[i][0])

        for i in range(left_count, n - right_count):
            if values[i] < 0: #최종 부호가 마이너스 인경우 가장 가까운 초기 id가 마이너스인 좀비의 인덱스가 절벽 끝에 도달하는데 걸리는 시간이다.
                result[i] = minus_dq.popleft()
            else:  #최종 부호가 플러스 인경우 가장 먼 초기 id가 플러스인 좀비의 인덱스가 절벽 끝에 도달하는데 걸리는 시간이다.
                result[i] = L - plus_dq.popleft()
    return result

def noCrash(initial_values, n):  #단 한번의 방향 전환도 없이 왼쪽, 오른쪽 낭떠러지에 떨어지는 좀비의 수를 구한다.
    left_count = 0  #방향 전환 없이 왼쪽 낭떠러지로 떨어지는 좀비
    right_count = 0  #방향 전환 없이 오른쪽 낭떠러지로 떨어지는 좀비
    for i in range(n):
        if initial_values[i][1] < 0:
            left_count += 1
        else:
            break
    for j in range(n-1, 0, -1):
        if initial_values[j][1] > 0:
            right_count += 1
        else:
            break
    return left_count, right_count



def findAnswer(initial_values, n, L, k):
    result = timeOnCliff(initial_values, n, L)
    resultWithId = []
    for i in range(n): #절벽에 떨어지기 전 좀비 id의 최종 부호와 절벽에 서는데 까지 껄리는 시간을 저장한 이차원 리스트 생성
        temp = []
        temp.append(initial_values[i][1])
        temp.append(result[i])
        resultWithId.append(temp)

    count = 0
    answer = 0
    left = 0
    right = n - 1
    while count != k:  # 구한 이차원 리스트의 양쪽 끝에서 부터 시작하여 k번째로 절벽 끝에 도달하는 좀비를 찾는다.
        if resultWithId[left][1] < resultWithId[right][1]:
            answer = resultWithId[left][0]
            left += 1
        elif resultWithId[left][1] > resultWithId[right][1]:
            answer = resultWithId[right][0]
            right -= 1
        elif resultWithId[left][1] == resultWithId[right][1]:
            if resultWithId[left][0] < resultWithId[right][0]:
                answer = resultWithId[left][0]
                left += 1
            else:
                answer = resultWithId[right][0]
                right -= 1
        count += 1
    return answer

print(findAnswer(initial_values, n, L, k))

#구현 방식 
#1. finalSign() : 절벽에 떨어지기 전 좀비의 방향(부호)를 결정하는데, 최종부호의 플러스 마이너스 개수는 초기 플러스, 마이너스 개수와 일치하게 되고, 왼쪽 절벽으로 부터 초기 마이너스 개수 만큼의 좀비가 최종 부호가 마이너스가 되게 되고 오른쪽 절벽으로 부터 초기 플러스 개수 만큼의 좀비가 최종 부호가 플러스가 되게 된다. 

# 2. noCrash() : 단 한번의 충돌(방향 전환)없이 왼쪽, 오른쪽 낭떠러지에 떨어지게 되는 좀비의 수를 구하여 각각 left_count, right_count에 저장한다. left_count는 왼쪽 낭떠러지 부터 초기 부호가 마이너스인 연속된 좀비의 수이며, right_count는 오른쪽 낭떠러지 부터 초기 부호가 플러스인 연속된 좀비의 수를 의미한다.

#3. timeOnCliff() : 좀비가 낭떠러지로 떨어지기 직전 절벽에 도달했을 때 까지 걸리는 시간을 구한다. 최종 부호가 마이너스 인경우 초기 id가 마이너스인 좀비 중 자신으로 부터 가장 가까운 좀비의 인덱스가 절벽 끝에 도달하는데 걸리는 시간이며, 최종 부호가 플러스 인경우 초기 id가 플러스인 자신으로부터 가장 먼 좀비의 인덱스가 절벽 끝에 도달하는데 걸리는 시간이다. 이러한 이유는 시간의 개념으로 접근한다면 좀비가 절벽에 도달할 때 까지 걸리는 시간은, 자신의 방향을 절벽쪽으로 바꾸는 좀비를 만나기 까지의 걸리는 시간과 일치하기 때문이다. 예를들어 왼쪽에 주어진 그림을 살펴보면 아이디가 +4인 좀비는 절벽에 도달하기 전 최종부호가 마이너스 이고, +5 좀비가 -1좀비와 충돌한 후 자신(+4좀비)와 충돌해야 절벽을 향해 갈 수 있는데 여기 까지 걸리는 시간은 19초 이고 이는 자신과 가장 가까운 좀비의 인덱스와 일치한다.

# 3-1 : finalSign()을 통해 최종부호를 구하고 noCrash()를 통해 방향전환 없이 양쪽 낭떠러지로 떨어지는 좀비의 수를 구한다.
# 3-2 : ressult 변수에 좀비가 절벽에 도달하는데 까지 걸리는 시간을 저장하는데 먼저 noCrash()를 통해 얻은 양쪽 절벽에 방향 전환 없이 떨어지는 좀비들의 절벽 도달시간을 먼저 구한다. 
# 3-3 : 그 후 다른 좀비들고 충돌하는 좀비들을 고려하는데, 충돌하는 종비들 중 가장 왼쪽의 좀비부터 오른쪽으로 가며 아이디 값이 플러스인 좀비들의 초기 인덱스는 plus_dq, 마이너스인 좀비들의 초기 인덱스는 minus_dq에 저장한다. dequeue를 사용하는 이유는 순서라는 개념이 생겨나 가장 멀거나 혹은 가장 가까운 좀비를 표현할 수 있기 때문이다. 
# 3-4 : 충돌한 좀비들을 순서대로 살펴보며 최종 부호가 마이너스 인경우 가장 가까운 초기 id가 마이너스인 좀비의 인덱스를 result에 저장하고 최종 부호가 플러스 인경우 가장 먼 초기 id가 플러스인 좀비의 인덱스를 result에 저장한다

#4. findAnswer() : timeOnCliff()함수를 통해 얻은 좀비들이 절벽에 도달하는데 걸리는 시간을 저장한 리스트와 초기에 주어진 좀비들의 id를 사용하여, 첫 번재 인덱스에는 좀비의 id, 두 번째 인덱스에는 좀비가 절벽에 도달하는데 걸리는 시간을 저장하는 이차원 리스트를 만들고, 이 리스트의 양쪽 끝을 확인하며 k번째로 떨어지는 좀비를 찾는다. 절벽에 도달하는 시간이 짧은 좀비가 먼저 떨어지고 도달 하는 시간이 일치하는 경우 id값이 더 작은 좀비가 떨어지도록 한다.

#수행시간 
#1. finalSign() : 모든 좀비를 돌며 id값이 음수인 좀비를 찾는데 n, 다시 한번 모든 좀비를 돌며 최종부호를 결정해주는데 n이 소모되어 O(2n)이 걸린다.

#2. noCrash() : 두개의 for문을 사용하지만 첫번째 for문은 왼쪽 부터 id가 마이너스인 연속된 좀비의 수, 두 번째 for문은 오른쪽 부터 id가 플러스인 좀비의 수를 구하므로 최악의 경우를 모든 좀비의 id가 마이너스일 경우라고 가정하면 두 번째 for문은 돌지 않기 때문에 O(n)이 걸린다. 최선의 경우인 모든 좀비들이 충돌할 경우에는 O(0)의 수행시간이 걸린다.

#3. timeOnCliff() : 먼저 다른 좀비와 충돌하지 않는 경우를 살펴보면 for문이 두 개지만 최악의 경우인 모든 좀비들이 충돌하지 않는 경우 앞서 noCrash()와 유사하게 O(n)이 걸린다. 다음으로 다른 좀비와 충돌하는 경우를 살펴보면 최악의 경우 모든 좀비가 충돌할 시 모든 좀비들을 돌며 plus_dq와 minus_dq에 저장할 값을 결정하는데 O(n), 모든 좀비를 돌며 result에 저장할 좀비가 절벽에 도달하는데 걸리는 시간을 결정하는데 O(n)이 걸린다. 이를 정리하면 먼저 finalSign() 수행으로 O(2n), 모든 좀비들이 충돌하지 않는 경우 noCrash()함수에서 O(n), 충돌하는 경우 수행되는 for문에서 O(n)이 걸려 총 O(4n)이 걸리고 모든 좀비들이 충돌하는 경우 먼저 finalSign() 수행으로 O(2n), noCrash()함수가 O(0)의 수행시간이 걸리므로 큐 값결저앟는데 O(n), result값 결정하는데 O(n)하여 O(4n)이 걸린다. 두 가지 경우 모두 고려하여도 timeOnCliff()함수는 O(4n)이 걸린다.

#4. findAnswer() : timeOnCliff()가 O(4n), 절벽에 떨어지기 전 좀비 id의 최종 부호와 절벽에 서는데 까지 껄리는 시간을 저장한 이차원 리스트 생성하기 위해 모든 좀비를 살펴보므로 O(n), 양쪽끝에서 부터 k 번째 떨어지는 좀비를 찾는데 만약 모든 좀비들이 한쪽 방향으로 정렬되어 있다면 최악의 경우 O(n)이 걸려 총 O(6n) -> O(n)이 걸린다.







