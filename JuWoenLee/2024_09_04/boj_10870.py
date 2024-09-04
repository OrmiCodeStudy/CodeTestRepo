# 재귀를 사용하여 n번째 피보나치 수를 구하는 문제

import sys
input = sys.stdin.readline

def fibo(n) :
    if n == 0 :
        return 0
    elif n == 1 :
        return 1
    
    else :
        return fibo(n - 1) + fibo(n - 2)

print(fibo(int(input())))
