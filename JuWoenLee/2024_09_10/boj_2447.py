# 특정 패턴을 반복 출력하는 프로그램

import sys
input = sys.stdin.readline

n = int(input())

def getStar(n) :
    # 더 이상 재귀 호출 불가
    if n == 1 :
        return ['*']
    
    # n / 3 패턴 재귀 호출
    stars = getStar(n // 3)
    # 재귀 함수의 생성 패턴을 저장하고 반환할 리스트
    result = []

    # 패턴의 첫번째 줄
    for star in stars :
        result.append(star * 3)
    # 패턴의 두번째 줄 (공백)
    for star in stars :
        result.append(star + ' '*(n // 3) + star)
    # 패턴의 세번째 줄
    for star in stars :
        result.append(star * 3)
    
    return result

print(*getStar(n), sep='\n')
