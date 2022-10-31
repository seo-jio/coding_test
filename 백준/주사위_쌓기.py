import sys

n = int(sys.stdin.readline())
dices = [
    list(map(int, sys.stdin.readline().split()))
    for _ in range(n)
]

def find_partner_idx(idx, cnt): #짝의 값을 찾는 함수 (몇번째 주사위, 숫자)
    if idx == 0:
        partner_idx = 5
    elif idx == 5:
        partner_idx = 0
    elif idx == 1:
        partner_idx = 3
    elif idx == 3:
        partner_idx = 1
    elif idx == 2:
        partner_idx = 4
    else: #idx == 4
        partner_idx = 2
    return partner_idx

def cal_sum(idx, prt_idx, cnt):
    s = {1, 2, 3, 4, 5, 6}
    s.remove(dices[cnt][idx])
    s.remove(dices[cnt][prt_idx])
    return max(list(s))

max_sum = 0
for i in range(6):
    partners = []
    partners.append(dices[0][i])
    partner_idx = find_partner_idx(i, 0)
    partner = dices[0][partner_idx]
    cur_sum = 0
    cur_sum += cal_sum(i, partner_idx, 0)
    for j in range(1, n): #주사위 개수 만큼 반복
        partners.append(partner)
        idx = dices[j].index(partner)
        partner_idx = find_partner_idx(idx, j)
        partner = dices[j][partner_idx]
        cur_sum += cal_sum(idx, partner_idx, j)
    max_sum = max(max_sum, cur_sum)
    # print(partners)
    # print(cur_sum)
print(max_sum)
