# 파도반 수열 구하기 프로그램

import sys
input = sys.stdin.readline

t = int(input())
# 기본 수열 저장
arr = [0, 1, 1, 1]

# 이후의 경우를 반복문을 통해서 저장
for i in range(4, 101) :
    arr.append(arr[i - 2] + arr[i - 3])

# 테스트케이스 수에 맞게 반복
for _ in range(t) :
    print(arr[int(input())])
