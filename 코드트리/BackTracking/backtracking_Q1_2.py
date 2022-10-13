n = int(input())
arr = []
count = 0

def is_beautiful():
    pos = 0 #현재 가리키는 인덱스
    while pos < n:
        if pos + arr[pos] - 1 >= n: #arr[pos]값이 남은 자리(len(arr) - pos)보다 클 경우
            return False
        else:
            flag = 1
            for k in range(pos, pos + arr[pos]): #같은 값이 연속되는지 확인
                if arr[pos] != arr[k]:
                    flag = 0
            if flag == 0:
                return False
            pos += arr[pos]
    return True

def choose(cur_num): #첫 번째 자리부터 1~n사이의 수를 고른 후 조건(is_beautiful)을 만족한다면 count값을 증가 시키는 함수
    global count
    if cur_num == n+1:
        if is_beautiful():
            count += 1
        return
    for i in range(1, 5):
        arr.append(i)
        choose(cur_num+1)
        arr.pop()

choose(1)
print(count)

