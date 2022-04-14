def countDiagonal(row, col, n): #현재 q1과 겹치는 대각선의 개수를 세어준다.
    count = 0
    x, y = row, col
    while x < n-1 and y > 0:  #왼쪽 밑의 대각선의 개수 구하기
        x += 1
        y -= 1
        count += 1

    x, y = row, col
    while x < n-1 and y < n-1:  #오른쪽 밑의 대각선의 개수 구하기
        x += 1
        y += 1
        count += 1
    return count

n = int(input())
count = 0
if n%2 == 0:  #n이 짝수인 경우
    for row in range(n-1):
        for col in range(n//2):  #대칭구조를 띄기 떄문에 n//2열까지만 수행한다.
            diagonal = countDiagonal(row, col, n)
            temp = row + 1  # row가 0부터 시작하기 때문에 1행을 표현하기 위해 1을 더해준다.
            count += n*n - (temp*n + (n-temp) + diagonal)  #q2가 놓일 수 있는 위치의 개수
    count = count * 2  #n//2열까지 수행 후 그 값을 두배한다.
    print(count)

else:  #n이 홀수인 경우
    for row in range(n-1):
        for col in range(n//2):  #대칭구조를 띄기 때문에 n//2열까지만 수행한다.
            diagonal = countDiagonal(row, col, n)
            temp = row + 1  # row가 0부터 시작하기 때문에 1행을 표현하기 위해 1을 더해준다.
            count += n * n - (temp * n + (n - temp) + diagonal) #q2가 놓일 수 있는 위치의 개수
    count = count * 2  #n//2열 까지 수행 후 그 값을 두배한다.

    col = n // 2   #n이 홀수인경우 n//2열을 중심으로 대칭을 이루기 때문에 n//2열만 따로 q2의 개수를 구해준다.
    for row in range(n-1):
        diagonal = countDiagonal(row, col, n)
        temp = row + 1  # row가 0부터 시작하기 때문에 1행을 표현하기 위해 1을 더해준다.
        count += n * n - (temp * n + (n - temp) + diagonal)  #q2가 놓일 수 있는 위치의 개수
    print(count)


# 구현 방법: n*n 격자 판에 q1을 (0, 0) 부터 한칸씩 옮겨가며 그때그때 q2가 위치할 수 있는 자리의 개수를 구한다. 
# 1. q1을 이중 for문을 사용하여 위치를 한칸씩 옮겨가는데 이 떄 n-2행 까지만 q2를 옮겨가면 된다. 그 이유는 n-1행은 맨 마지막 행으로 q2가 위치할        수 있는 경우가 이전에 구한 값들에 포함되어 있기 떄문이다.(q1, q2가 자리만 바꾸고 같은 위치에 있는 중복인 경우가 존재하기 떄문에)
# 2. conuntDiagonal 함수를 통해 현재 q1보다 밑에 행에 위치하지만 같은 대각선에 위치하는 칸의 개수를 구한다.
# 3. row가 0부터 시작하기 떄문에 temp라는 변수를 두고 row + 1을 저장해준다.
# 4. 총 칸의 개수에서 q1 과 같거나 위에 있는 행(temp*n), q1과 같은 열(n-temp), q1과 같은 대각선에 위치하는 칸(diagonal)의 개수를 빼준다.
# 5. 1~3의 과정을 n이 짝수와 홀수일 경우 다르게 진행하는데 짝수일 경우 대칭형을 띄기 때문에 n//2열 까지만 진행 후 두배를 해주고 n이 홀수일 경우        n//2열을 중심으로 대칭을 이루기 때문에 이를 고려하여 계산한다.


# 수행시간 : n이 짝수이던 홀수이던 수행시간을 빅오로 표현하면 동일한데 먼저 q1의 위치를 이중 for문을 사용하여 n*n 격자 판의 마지막행을 제외한 모든            위치에 놓기 때문에 빅오엔제곱이 걸리고 추가로 countDiagonal 함수를 살펴보면 최악의 경우 오른쪽 밑에 대각선에 위치한 칸의 개수를 구하            는데 빅오엔, 왼쪽 밑에 대각선에 위치한 칸의 개수를 구하는데 빅오엔이 걸려 총 O(2n)이 걸린다. 결과적으로 n^2 * n = n^3이므로 수행시간            은 O(n^3)이 걸린다. 