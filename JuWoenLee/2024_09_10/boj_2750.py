# 오름차순 정렬 프로그램

import sys
input = sys.stdin.readline

N = int(input())
A = [int(input()) for _ in range(N)]

# 마지막 정수를 제외하고 반복
for i in range(N - 1) :
    # 정렬된 정수를 제외하고 반복
    for j in range(N - 1 - i) :
        # 현재 값이 그 뒷 요소의 값보다 크다면
        if(A[j] > A[j + 1]) :
            # swap
            A[j + 1], A[j] = A[j], A[j + 1]

print(*A, sep='\n')
