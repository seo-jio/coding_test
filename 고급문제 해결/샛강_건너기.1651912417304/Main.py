import math

def findK(rocks, L, k):
	rocks.append(L)  #폭이 L이다 라는 건 L 위치에 마지막 돌이 놓여있다고 생각할 수 있으므로 L을 append해준다.
	start = 1 #될 수 있는 점프 값의 최솟값은 1
	end = L #될 수 있는 점프 값의 최댓값은 L이다.(n = k일 경우) 
	answer = 0 #정답을 저장할 변수
	while start <= end:  #가능한 점프 값의 범위에서 이진탐색을 수행한다.
		mid = (start + end) // 2 #현재 점프 값을 의미
		min_dis = math.inf  #현재 점프 값에서의 최솟값
		current = 0
		remove_count = 0 #삭제한 돌의 개수
		for rock in rocks: #현재 점프 갑(mid)보다 돌 사이의 거리가 작을 경우 현재 가리키는 돌을 삭제, 클 경우 current값을 현재 돌로 지정
			gap = rock - current
			if gap < mid:
				remove_count += 1
			else:
				current = rock
				min_dis = min(min_dis, gap)  #돌 사이의 거리 중 최솟값을 계속 구하여 min_dis에 저장한다.
		if remove_count > k:  #삭제한 돌의 개수가 주어진 k값 보다 클 경우 점프값을 줄인다.
			end = mid - 1
		else: #삭제한 돌의 개수가 주어진 k값보다 작거나 같다면 점프값을 늘린다
			answer = min_dis
			start = mid + 1
	return answer

#구현 방법 : 답을 미리 정하고 조건에 맞는지 찾는 방식으로 접근하여 점프값이 될 수 있는 값들의 범위를 구하고 범위 내에서 주어진 입력값과 비교해가며 이진탐색을 수행하여 답이 조건과 일치하는지를 판별한다. 
#1. 이진탐색을 하기 위하여 start와 end를 될수 있는 점프 값의 최솟값과 최댓값을 초기화 한다.
#2. start <= end일 경우까지 mid 값을 start와 end의 중간 값으로 지정하고 조건을 확인한다.
#3. 조건 확인을 위해 for문을 통해 돌 사이의 거리를 구하며 거리가 현재 답이라고 가정한 점프 값보다 작다면 그 돌을 삭제하고 삭제한 돌의 개수를 증가시키고, 크다면 거리의 최솟값을 업데이트하고 다음 돌들과 다시 거리를 구한다.
#4. 삭제한 돌의 개수가 주어진 k값보다 클 경우 점프값을 줄이기 위해 end = mid -1로 수정하고, 삭제한 돌의 개수가 주어진 k값보다 작거나 같다면 점프값을 늘린다. start = mid + 1
#5. mid값과 mind_dis값이 주어진 입력과 일치한다고 break하는 것이 아닌 나머지 뒤에 부분까지 확인해야 한다. -> 돌 사이의 간격이 최댓값이 아닐 수 있기 떄문에

#수행시간
#-> 첫번째 while문을 살펴보면 점프값의 범위이인 1~L 사이에서 이진탐색을 수행하기 때문에 logL의 수행시간이 걸리고 내부에 for문을 살펴보면 돌의 개수 만큼 for문이 돌아가기 때문에 O(n)의 수행시간이 추가로 걸리게 되어 O(nlogL)의 수행시간이 걸린다.








L, n, k = map(int, input().split())
rocks = list(map(int, input().split()))

print(findK(rocks, L, k))

