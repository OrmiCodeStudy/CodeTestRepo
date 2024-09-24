# n이 주어졌을 때, 수의 자리가 오름차순을 이루는 수인 오르막 수의 개수를 구하는 프로그램
# 인접한 수가 같아도 오름차순으로 판단

import sys
input = sys.stdin.readline

n = int(input())
# 1의 자리 숫자가 0 ~ 9가 모두 들어가는 경우 1개씩 존재하니까 1로 초기화
dp = [1] * 10

# 1의 자리 숫자를 제외하고 계산
for i in range(n - 1) :

    # 1의 자리 숫자가 j일 때, 0 ~ j까지인 오르막 수를 포함함
    for j in range(1, 10) :
        dp[j] += dp[j - 1]

print(sum(dp) % 10007)
