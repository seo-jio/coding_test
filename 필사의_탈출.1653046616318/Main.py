u = int(input())
u_list = list(map(int, input().split()))
m = int(input())
m_list = list(map(int, input().split()))
l = int(input())
l_list = list(map(int, input().split()))

listM = [False for i in range(60001)]
for m_num in m_list:
    listM[m_num+30000] = True

def Solution(u_list, m_list, l_list):
    answer = 0
    for u_num in u_list:
        for l_num in l_list:
            if (u_num + l_num) % 2 != 0:
                continue
            if listM[int((u_num + l_num) / 2) + 30000] == True:
                answer += 1
    return answer

print(Solution(u_list, m_list, l_list))

#구현 방법
#1. 인덱스는 될수 있는 구멍의 x좌표 +30000, 인덱스의 해당하는 값은 x좌표에서의 구멍의 존재유무를 의미하는 listM을 만든다. 첫번째로 구멍의 x좌표가 될 수 있는 범위는 -30000~30000이고 리스트의 인덱스는 0부터 시작하므로 0~60000까지의 인덱스를 가지며 False로 초기화된 리스트를 만든다. 그 후 입력받은 가운데 선분 내 구멍의 x좌표들을 살펴보며 listM[해당x좌표] = True로 바꿔준다. 
#2. Solution(): needle이 세 선분을 통과하기 위해서는 needle이 통과하는 세 구멍의 기울기가 일치해야 하는데 이를 각 needle이 통과하는 세 구멍의 좌표를 a, b, c 라고 두면 "a+c = 2*b"라는 식을 구해낼 수 있다. 위 식을 만족하는 b값을 찾기 위해 a, c를 이중 for문으로 돌아가며 먼저 (a+b)/2 값이 소수인지를 판별하고 소수일 경우 c값은 정수이기에 continue하고 소수가 아닐 경우 listM[int((u_num + l_num) / 2) + 30000]이 True인지 False인지를 사용하여 a+c = 2*b를 만족하는 c값이 있는지 찾는다. 

#수행시간
#-> listM을 만들기위해 60000개의 원소를 갖는 리스트 생성을 위해 O(60000), 중간 장벽의 선분의 구멍을 체크하기 위해 걸리는 O(m), 이중 for문을 돌며 u_list, l_list 원소를 모두 살펴보기에 O(ul)이 걸린다. 최종적으로 O(ul) + O(m)의 수행시간이 걸린다.

# 처음에 다양한 방법으로 진행하다가 테케 몇개가 timeout이 떠, 수행시간은 줄어들지만 메모리 효율성이 낮은 코드로 수정하였습니다.