day1, hour1, min1 = 11, 11, 11
day2, hour2, min2 = map(int, input().split())

def cal_time(d, h, m):
    days, hours, mins = 1, 0, 0
    elapsed_time = 0
    while True:
        if days == d and hours == h and mins == m:
            break

        elapsed_time += 1
        mins += 1

        if mins == 60:
            hours += 1
            mins = 0
        if hours == 24:
            days += 1
            hours = 0
    return elapsed_time

first = cal_time(day1, hour1, min1)
second = cal_time(day2, hour2, min2)

if second >= first:
    print(second - first)
else:
    print(-1)