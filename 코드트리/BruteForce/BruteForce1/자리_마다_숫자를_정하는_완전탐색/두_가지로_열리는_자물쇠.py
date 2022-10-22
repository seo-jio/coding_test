n = int(input())
arr1 = list(map(int, input().split()))
arr2 = list(map(int, input().split()))

def is_possible_first(pos, num):
    temp = arr1[pos]
    if abs(temp - num) <= 2 or abs(temp - num) >= n - 2:
        return True

def is_possible_second(pos, num):
    temp = arr2[pos]
    if abs(temp - num) <= 2 or abs(temp - num) >= n - 2:
        return True

count = 0
for i in range(1, n+1):
    for j in range(1, n+1):
        for k in range(1, n+1):
            if is_possible_first(0, i) and is_possible_first(1, j) and is_possible_first(2, k):
                count += 1
            elif is_possible_second(0, i) and is_possible_second(1, j) and is_possible_second(2, k):
                count += 1

print(count)