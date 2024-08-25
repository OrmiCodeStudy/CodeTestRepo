# 입력 괄호 문자열이 올바른 괄호 문자열(VPS)이면 “YES”, 아니면 “NO”를 출력

import sys
input = sys.stdin.readline

n = int(input())

# 올바른 괄호 문자열인지 확인하는 함수
def isVPS(ps) :
    stack = list()
    for p in ps :
        
        # 여는 괄호일 경우 stack에 삽입
        if p == '(' :
            stack.append(p)

        # stack이 비어있는 상황에 닫는 괄호를 삽입하려고 하는 경우 바로 NO 반환
        elif len(stack) == 0 and p == ')' :
                return 'NO'
        
        # 스택의 가장 마지막 괄호가 여는 괄호이고,
        # 닫는 괄호를 삽입하려고 하는 경우 여는 괄호를 제거
        elif p == ')' and stack[-1] == '(' :
            stack.pop()

    # 문자열을 모두 확인한 후의 stack의 길이로 출력 문자열 반환
    if len(stack) == 0 : return 'YES'
    return 'NO'

# 괄호를 확인하는 함수를 n번 호출
for i in range(n) :
    print(isVPS(input()))
