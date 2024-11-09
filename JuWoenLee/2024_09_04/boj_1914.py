# 하노이 탑의 최소 이동 횟수와 필요한 이동 순서를 출력하는 프로그램
# 하노이 탑의 높이 <= 20 : 최소 이동 횟수와 이동 순서 출력
# 하노이 탑의 높이 > 20 : 최소 이동 횟수만 출력

import sys
input = sys.stdin.readline

hanoiHeight = int(input())

def hanoi(n, start, end, center) :

    # 원판이 하나라면, 1번 기둥에서 3번 기둥으로 이동
    if n == 1 :
        print(start, end)
        return

    # 원판이 2개 이상이라면
    else :

        # 마지막 원판을 제외한 n - 1개의 원판을 1번 기둥에서 2번 기둥으로 이동
        hanoi(n - 1, start, center, end)

        # 마지막 원판을 3번 기둥으로 이동
        print(start, end)

        # 마지막 원판을 제외한 n - 1개의 원판을 2번 기둥에서 3번 기둥으로 이동
        hanoi(n - 1, center, end, start)

# 하노이 탑 이동 횟수 공식 (2**n - 1)
print(2**hanoiHeight - 1)

# 하노이 탑의 높이가 20 이하일 때 과정 출력
if hanoiHeight <= 20 :
    hanoi(hanoiHeight, 1, 3, 2)
