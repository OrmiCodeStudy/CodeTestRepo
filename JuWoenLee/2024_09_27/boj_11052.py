# n개의 카드를 구매한다고 할 때,
# 1 ~ n개의 카드가 들어있는 카드팩의 가격이 주어진다.
# 카드팩의 가격이 주어졌을 때, N개의 카드를 구매하기 위해 지불해야하는 금액의 최댓값을 구하는 프로그램

import sys
input = sys.stdin.readline

n = int(input())
p = [0] + list(map(int, input().split()))
dp = [0] * 1001

# 구매하려는 카드의 수 (1 <= n)
for i in range(1, n + 1) :
    # i개의 카드를 구매하기 위해 사용하는 카드팩 개수 (1 <= i)
    for j in range(1, i + 1) :
        # i - j개의 카드를 구매할 때의 최댓값과
        # j개의 카드가 들어있는 카드팩의 가격을 더한 값 중 큰 값을 선택
        dp[i] = max(dp[i], dp[i - j] + p[j])

print(dp[n])
