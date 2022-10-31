m1, d1, m2, d2 = map(int, input().split())
days_of_months = [0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
month, day = m1, d1
elapsed_day = 1

while True:
    if month == m2 and day == d2:
        break

    elapsed_day += 1
    day += 1

    if day > days_of_months[month]:
        month += 1
        day = 1

print(elapsed_day)