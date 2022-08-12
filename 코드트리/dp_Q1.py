# n = int(input())
# memo = [-1 for _ in range(n+1)]
#
# def fibo(n):
#     if memo[n] != -1:
#         return memo[n]
#
#     if n <= 2:
#         memo[n] = 1
#         return 1
#     else:
#         memo[n] = fibo(n-1) + fibo(n-2)
#
#     return memo[n]
#
# print(fibo(n))
# print(memo)

n = int(input())

UNUSED = -1

memo = [UNUSED for _ in range(n + 1)]


def fib(n):
    if memo[n] != UNUSED:
        return memo[n]

    if n == 1 or n == 2:
        return 1

    memo[n] = fib(n - 1) + fib(n - 2)
    return memo[n]


print(fib(n))
print(memo)