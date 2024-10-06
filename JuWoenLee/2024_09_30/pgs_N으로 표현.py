# n과 사칙연산을 사용하여 number를 만들 때,
# n의 최소 사용횟수를 출력하는 프로그램
# 수식에는 괄호와 사칙연산만 사용, 나누기 연산에서 나머지는 무시
# 최솟값이 8보다 크다면 -1 반환

# N 1개 이용 : N
# N 2개 이용 : NN, N + N, N - N, N * N, N / N
# N 3개 이용 : NNN,
#                (N + N) + N, (N + N) - N, (N + N) * N, (N + N) / N
#                (N - N) + N, (N - N) - N, (N - N) * N, (N - N) / N
#                (N * N) + N, (N * N) - N, (N * N) * N, (N * N) / N
#                (N / N) + N, (N / N) - N, (N / N) * N, (N / N) / N
# N 4개 이용 : NNNN, N 3개 (사칙연산) N 1개, N 2개 (사칙연산) N 2개
# N N개 이용 : i개 (사칙연산) j개

import sys
input = sys.stdin.readline

def solution(N, number) :
    # N을 1개 사용할 때
    if N == number :
        return 1
    
    answer = -1
    # dp = [set(), set(), set(), set(), set(), set(), set(), set()]
    # set으로 중복값 제거 -> 연산 횟수 감소
    dp = [set() for _ in range(8)]

    # dp[i] = {N * (i + 1)개}
    for i in range(len(dp)) :
        dp[i].add(int(str(N) * (i + 1)))

    # dp[1] ~ dp[7]의 set
    for i in range(1, 8) :
        # dp[0] ~ dp[i]의 set
        for j in range(i) :
            # dp[j]에 들어있는 값들
            for op1 in dp[j] :
                # dp[i - j - 1]에 들어있는 값들
                for op2 in dp[i - j - 1] :
                
                    # 모든 사칙연산에 대한 값을 set에 추가    
                    dp[i].add(op1 + op2)
                    dp[i].add(op1 - op2)
                    dp[i].add(op1 * op2)

                    # 0으로 나누는 에러 발생 방지
                    if op2 != 0 :
                        dp[i].add(op1 // op2)
        
        # N으로 number가 만들어지면
        if number in dp[i] :
            # i는 연산의 횟수이기 때문에 1을 더해서 N의 사용횟수로 만듦
            answer = i + 1
            break

    return answer
