# 오큰수 구하기

import sys
input = sys.stdin.readline

N = int(input())
A = list(map(int, input().split()))
ans = [-1] * N
stack = [0]

# 1 ~ N 인덱스 반복
for i in range(1, N) :
  # 스택이 비어있지 않고, 스택의 마지막 요소가 리스트의 i값보다 작을 경우 실행
    while(stack and A[stack[-1]] < A[i]) :
      # 답 리스트의 스택 마지막 요소를 인덱스로 사용, 그 값을 배열의 i값으로 사용
        ans[stack.pop()] = A[i]
    stack.append(i)
    
print(*ans)
