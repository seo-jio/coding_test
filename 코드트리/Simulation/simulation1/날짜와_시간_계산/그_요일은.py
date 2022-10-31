m1, d1, m2, d2 = map(int, input().split())
A = input()
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

days_list = ["Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"]
diff = second - first
if diff < 0:
    diff += 7
print(diff)
result = 0
result += diff // 7
temp = []
for i in range(diff % 7 + 1):
    temp.append(days_list[i])
print(temp)
if A in temp:
    print("hello")
    result += 1

print(result)