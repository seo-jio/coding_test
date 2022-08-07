n, m = map(int, input().split())
arr = [
    list(map(int, input().split()))
    for _ in range(n)
]

#격자 내 값인지 확인하는 방어 함수
def in_range(r, c):
    return r >= 0 and r < n and c >= 0 and c < n

#특정 행 안에서 m개의 연속된 값을 갖는지 확인
def is_continuos_row(r):
    global n, m
    for c in range(n-m+1): #격자 내 범위 까지만 확인
        flag = 1
        for i in range(1, m): #열을 늘려주면서 연속성 확인
            #첫 번째 값과 연속된 다음 값이 다르면 flag 0으로 변환
            if in_range(r, c + i) and arr[r][c] != arr[r][c + i]:
                flag = 0
        if flag == 1: #m개의 연속된 값을 갖는 행이 존재 한다면 True return
            return True
    return False

def cal_in_row():
    global n, m
    count = 0
    for r in range(n):
        if is_continuos_row(r):
            count += 1
    return count

def is_continuos_col(c):
    global n, m
    for r in range(n-m+1):
        flag = 1
        for i in range(1, m): #행을 늘려주면서 연속성 확인
            if in_range(r+i, c) and arr[r][c] != arr[r+i][c]:
                flag = 0
        if flag == 1:
            return True
    return False

def cal_in_col():
    global n, m
    count = 0
    for c in range(n):
            if is_continuos_col(c):
                count += 1
    return count

if m == 1:
    print(n*2)
else:
    print(cal_in_row() + cal_in_col())