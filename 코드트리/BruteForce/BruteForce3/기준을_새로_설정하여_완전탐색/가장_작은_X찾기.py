n, m = map(int, input().split())
arr = [
    tuple(map(int, input().split()))
    for _ in range(m)
]

def cal(i, j):
    count = 0
    for a, b in arr:
        if a == i and b == j:
            count += 1
        elif a == j and b == i:
            count += 1
    return count

max_count = 0
for i in range(1, 11):
    for j in range(1, 11):
        count = cal(i, j)
        print(f"{i}, {j} => {count}")
        max_count = max(max_count, count)
print(max_count)