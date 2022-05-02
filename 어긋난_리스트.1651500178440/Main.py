def findGap(a, b):
	if a < 0 and b < 0:
		return a*(-1) - b*(-1)
	elif a < 0 and b > 0:
		return b + a*(-1)
	elif a > 0 and b < 0:
		return a + b*(-1)
	else:
		return abs(a-b)
	
def findK(A):
	if A[0] < A[-1]: #k가 0인지를 판단한다.
		return 0
	else:
		start = 0
		end = len(A) - 1
		while start <= end:
			if end - start == 1:  #start와 end 사이에 존재하는 값이 두 개일 경우
				if A[start] < A[end]:
					return len(A) - start
				else:
					return len(A) - end
			else:  #start와 end 사이에 존재하는 값이 세 개 이상일 경우
				mid = (start + end) // 2  #start와 end 정 가운데에 있는 인덱스를 가리킨다.
				if A[mid -1] > A[mid]:  #A[mid]값의 양쪽을 보면서 오름차순이 깨져있는지 확인한다.
					return len(A) - mid
				elif A[mid] > A[mid + 1]:
					return len(A) - (mid + 1)
				else:  #A[mid] 값의 양쪽을 확인한 후 오름차순이 지켜져 있다면 A[start]와 A[mid]값의 차이와 A[mid]와 A[end]값의 차이를 구한 후 차이가 더 작은 쪽은 버리고 차이가 더 큰 쪽에서 앞선 과정을 반복한다.
					if findGap(A[start], A[mid]) > findGap(A[mid], A[end]): #이진탐색과 유사하게 start와 end값을 조정
						end = mid - 1 
					else:
						start = mid + 1
						
A = list(map(int, input().split()))
print(findK(A))

#구현 방법
#1. findGap() : 두 수를 입력 받아 음수 양수일 경우를 고려하여 두 수의 차이를 구한다.
#2. findK() -> 이진탐색과 유사, k = (A값의 총 개수 - 오름차순이 깨지는 위치 중 작은값의 인덱스)
#2-1 : A[0]과 A[-1] 두 값을 비교하여 먼저 k가 0인지 아닌지를 판단한다. 만약 A[0] < A[-1]이 크다면 오름차순이 깨지지 않았다는 뜻이므로 0을 return
#2-2 : start와 end변수를 두고 start <== end일 경우까지 while문을 돈다
#2-3 : while문 내부를 살펴보면 먼저 start와 end 사이에 존재하는 값이 두 개일경우 따로 고려
#2-4 : start와 end 사이에 존재하는 값이 두 개 초과일 경우 mid라는 중간 값을 두고 mid의 양쪽을 확인하여 오름차순이 유지되는지를 확인하고, 오름차순이 아닐 경우 k값을 구하여 return하고 오름차순일 경우 A[start]와 A[mid]값의 차이와 A[mid]값과 A[end]값의 차이를 살펴 차이가 더 작은쪽은 버리고 더 큰쪽에서 앞선 과정을 반복한다. 

#수행시간
#-> findGap()함수는 단순 연산으로만 이루어지므로 상수시간이 걸리고, findK()함수를 살펴보면 k가 0이 아닐 경우 리스트의 중간값을 지정하고 A[start], A[end]와 비교 후 둘 중 차이가 더 큰 쪽에서 다시 중간 값을 찾고 앞선 과정을 반복하는 형태로 반절을 살펴보고, 다음 반절을 살피는 이진탐색과 유사하다. 따라서 O(logn)의 수행시간이 걸린다.
