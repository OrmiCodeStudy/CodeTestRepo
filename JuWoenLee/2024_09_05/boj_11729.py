# 하노이 탑의 최소 이동 횟수와 필요한 이동 순서를 출력하는 프로그램

import sys
input = sys.stdin.readline

n = int(input())

def hanoi(n, start, end, center) :
    # 원판이 하나라면
    if n == 1 :
        # 1번 기둥에서 3번 기둥으로 이동
        print(start, end)
        return
    
    # 원판이 여러 개라면
    else :
        # 마지막 원판을 제외한 원판들을 2번 기둥으로 이동
        hanoi(n - 1, start, center, end)
        # 마지막 원판을 3번 기둥으로 이동
        print(start, end)
        # 2번 기둥에 있던 나머지 원판들을 3번 기둥으로 이동
        hanoi(n - 1, center, end, start)

# 하노이 탑 최소 이동 횟수 공식
print(2**n - 1)
hanoi(n, 1, 3, 2)
