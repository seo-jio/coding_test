def solve():
    lis = []
    n = int(input())
    for i in range(n):
        tup = tuple(input().split())
        if tup[0] == "push_back":
            lis.append(int(tup[1]))
        elif tup[0] == "pop_back":
            lis.pop()
        elif tup[0] == "size":
            print(len(lis))
        else:
            print(lis[int(tup[1])-1])

solve()

