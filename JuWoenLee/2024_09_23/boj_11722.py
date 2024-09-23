# 가장 긴 감소하는 부분 수열의 길이를 구하는 프로그램
# 배열에서 현재값과 그 앞에 있는 값들을 비교해서 부분 수열의 길이를 구한다.

import sys
input = sys.stdin.readline

n = int(input())
nList = list(map(int, input().split()))
# 현재 값을 선택한 길이 1로 초기화
dp = [1] * n

for i in range(n) :
    for j in range(0, i) :
        # 현재값(i)보다 앞에 있는 값(j)이 더 크다면
        if nList[i] < nList[j] :
            # 현재값의 부분 수열 길이와 비교값의 부분 수열 길이 +1 중 더 큰 값을 dp에 저장
            dp[i] = max(dp[i], dp[j] + 1)

# 저장된 부분 수열 길이 중 최대값 출력
print(max(dp))
