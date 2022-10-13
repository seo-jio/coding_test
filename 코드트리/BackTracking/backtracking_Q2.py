k, n = map(int, input().split())
#k이하의 수로 이루어진 n자리수가 되는 모든 경우의 수 1부터 출력

arr = []
#cur_num : 현재 가리키는 곳이 앞에서 부터 몇 번째 자리 수 인지
def solve(cur_num):  #cur_num번째 위치에 1,2,3 중 하나를 선택하는 함수
    if cur_num == n+1:
        for elem in arr:
            print(elem, end=' ')
        print()
        return
    for i in range(1, k+1):
        if cur_num >= 3 and arr[-2] == arr[-1] == i: # 조건 추가(cur_num ==3이라고 두면 n이 3보다 큰 경우 오류 발생)
            continue
        arr.append(i)
        solve(cur_num+1) #재귀 호출
        arr.pop() #원래 상태로 다시 돌려줌
#cur_num 1부터 시작
solve(1)
