m1, d1, m2, d2 = map(int, input().split())
days_of_months = [0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]

def cal(m, d):
    month, day = 1, 1
    elapsed_day = 0

    while True:
        if month == m and day == d:
            break

        elapsed_day += 1
        day += 1

        if day > days_of_months[month]:
            month += 1
            day = 1
    return elapsed_day

first = cal(m1, d1)
second = cal(m2, d2)
if second > first:
    diff = second - first
    print(diff)
    if diff % 7 == 0:
        print("Mon")
    elif diff % 7 == 1:
        print("Tue")
    elif diff % 7 == 2:
        print("Wed")
    elif diff % 7 == 3:
        print("Thu")
    elif diff % 7 == 4:
        print("Fri")
    elif diff % 7 == 5:
        print("Sat")
    elif diff % 7 == 6:
        print("Sun")
else:
    diff = first - second
    print(diff)
    if diff % 7 == 0:
        print("Mon")
    elif diff % 7 == 1:
        print("Sun")
    elif diff % 7 == 2:
        print("Sat")
    elif diff % 7 == 3:
        print("Fri")
    elif diff % 7 == 4:
        print("Thu")
    elif diff % 7 == 5:
        print("Wed")
    elif diff % 7 == 6:
        print("Tue")