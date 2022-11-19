from collections import Counter

T = int(input())
dic = {
    "ZRO": 0,
    "ONE": 1,
    "TWO": 2,
    "THR": 3,
    "FOR": 4,
    "FIV": 5,
    "SIX": 6,
    "SVN": 7,
    "EGT": 8,
    "NIN": 9
}

for t in range(1, T+1):
    tc, n = int, input().split()
    nums = list(input().split())
    counter = Counter(nums)
    ans = ''
    for key, val in dic.items():
        cnt = counter[key]
        for i in range(cnt):
            ans += (key + ' ')
    print(f"#{t}")
    print(ans)