from bisect import bisect_left, bisect_right

n = int(input())
A = []
for i in range(n):
    A.append(int(input()))

A.sort()
count = 0

for i in range(n):
    for k in range(i+1, n):
        a = A[i]  #a값 지정
        b = A[k]  #b값 지정
        section = (2*b-a, 3*b-2*a)  #c의 유효범위의 최솟값과 최댓값을 저장
        left = bisect_left(A, section[0])  #최솟값이 리스트 A에 들어갈 수 있는 인덱스를 찾는다.
        right = bisect_right(A, section[1])  #최댓값이 리스트 A에 들어갈 수 있는 인덱스를 찾는다.
        count += right - left  #최댓값이 들어갈 수 있는 인덱스와 최솟값이 들어갈 수 있는 인덱스 사이에 존재하는 원소의 개수를 찾는다.
print(count)

#구현방법
#1. 이중 for문을 사용해 리스트 A를 돌며 a와 b값을 결정한다.
#2. 결정된 a와 b값을 통해 주어진 조건을 만족시킬 수 있는 c값의 범위를 찾는다. (2*b-a <= c <= 3*b-2*a)
#3. c값의 범위 중 최솟값과 최댓값을 튜플 변수 section에 저장
#4. 이진탐색을 통해 주어진 값이 리스트 내 어느 인덱스에 위치하는지 알려주는 파이썬 내장함수인 bisect_left, bisect_right를 사용하여 최솟값과 최댓값이 리스트 A에 들어갈 경우 해당되는 인덱스를 구하고 이들을 left, right 변수에 저장한다.
#5. 최댓값과 최솟값이 들어갈 수 있는 사이에 존재하는 원소들은 주어진 조건을 만족하는 것이기 떄문에 right - left를 통해 리스트 A내 조건을 만족하는 c값의 개수를 구한다.

#시간복잡도 : 우선 이중 for문을 통해 a와 b값을 결정하기에 빅오 엔제곱이 걸리고 bisect_left와 bisect_right는 이진탐색을 활용하기 때문에 둘 다 O(logn)의 수행시간이 소모되어 총 수행시간은 n^2 * 2 * logn이 걸리고 이를 빅오로 나타내면 O(n^2*logn)의 수행시간이 걸린다.  