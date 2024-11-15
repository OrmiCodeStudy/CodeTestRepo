# 입력받은 정수 N을 1, 2, 3의 합으로 나타내는 경우의 수를 구하는 프로그램

import sys
input = sys.stdin.readline
t = int(input())

# 0 < N < 11이기 때문에
# 0번 인덱스 사용 X
# dp[1] = 1, dp[2] = 2, dp[3] = 4로 초기화한 후, 나머지 인덱스(길이 7)을 0으로 초기화
dp = [0, 1, 2, 4] + [0] * 7

# 점화식 : dp[n] = dp[n - 3] + dp[n - 2] + dp[n - 1]
for i in range(4, len(dp)) :
    dp[i] = dp[i - 3] + dp[i - 2] + dp[i - 1]

# 테스트케이스 수만큼 입력받은 n을 만들 수 있는 경우의 수 출력
for _ in range(t) :
    print(dp[int(input())])
