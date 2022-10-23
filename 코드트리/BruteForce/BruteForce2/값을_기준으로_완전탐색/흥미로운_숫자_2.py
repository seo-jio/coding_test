from collections import Counter

start, end = map(int, input().split())
count = 0


def is_interested(num):
    string = str(num)
    counter = Counter(string)
    if len(counter) == 2: #len(Counter) == 2는 2개의 숫자로 이루어졌다는 걸 의미
        if 1 in counter.values(): # counter의 value들 중 1이 존재한다면 성공
            return True
    return False


for i in range(start, end + 1):
    if is_interested(i):
        count += 1
print(count)