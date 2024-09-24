# 가장 큰 증가하는 부분 수열을 구하는 프로그램
# 배열에서 현재값과 그 앞에 있는 값들을 비교해서 부분 수열의 합 중 최댓값을 구한다.

import sys
input = sys.stdin.readline

n = int(input())
nList = list(map(int, input().split()))
# 부분 수열의 합을 저장할 배열 
dp = [nList[0]] + [0] * (n - 1)

for i in range(n) :
    for j in range(0 , i) :
        # 현재값(i)보다 앞에 있는 값(j)가 작다면
        if nList[i] > nList[j] :
            # 부분 수열의 합에 현재값과 dp[i] + nList[i] 중 더 큰 값을 저장
            dp[i] = max(dp[i], dp[j] + nList[i])

        # nList[i]가 nList[j]보다 작거나 같다면
        else :
            # 현재값과 nList[i] 중 더 큰 값을 저장 
            dp[i] = max(dp[i], nList[i])
    

# 부분수열의 합을 저장한 배열에서 가장 큰 값 출력
print(max(dp))
