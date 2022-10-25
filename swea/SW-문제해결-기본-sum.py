T = 10
for test_case in range(T):
    n = int(input())
    arr = [0] + list(map(int, input().split()))
    grid = []

    start, end = 1, 10
    for i in range(10):
        grid.append(arr[start:end+1])
    print(grid)
