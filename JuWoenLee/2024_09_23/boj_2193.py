# N자리 이친수를 구하는 프로그램
# 이친수 조건 1 : 0으로 시작하지 않음
# 이친수 조건 2 : 1이 두 번 연속 나타나지 않음

import sys
input = sys.stdin.readline

dp = [0, 1, 1] + [0] * 88

for i in range(3, len(dp)) :
    dp[i] = dp[i - 1] + dp[i - 2]

print(dp[int(input())])
