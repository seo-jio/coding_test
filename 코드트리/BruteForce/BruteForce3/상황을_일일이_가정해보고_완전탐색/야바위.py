n = int(input())
arr = [
    list(map(int, input().split()))
    for _ in range(n)
]

# def is_correct():

max_count = 0
for i in range(1, 4):
    cups = [0] * 4
    cups[i] = 1
    count = 0
    for lis in arr: #다음 부터는 언패킹을 사용하자 ex)for a, b, c in arr:
        cups[lis[0]], cups[lis[1]] = cups[lis[1]], cups[lis[0]]  #swap
        if cups[lis[2]] == 1:
            count += 1
    max_count = max(max_count, count)
print(max_count)