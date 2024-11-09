# 높이가 n인 정수 삼각형이 주어졌을 때,
# 맨 위층부터 아래 있는 수 중 하나를 선택하여 (대각선 좌, 우만 선택 가능)
# 선택된 수들의 합 중 최댓값을 출력하는 프로그램

import sys
input = sys.stdin.readline

n = int(input())
t = list()

for _ in range(n) :
    t.append(list(map(int, input().split())))

# 삼각형의 레벨 : i
for i in range(1, len(t)) :
    # 삼각형의 각 레벨의 노드 : j
    for j in range(len(t[i])) :
        # 해당 수가 삼각형의 가장 왼쪽에 있는 수라면
        if j == 0 :
            # 좌측 상단 수를 가산
            t[i][j] += t[i - 1][j]

        # 해당 수가 삼각형의 가장 오른쪽에 있는 수라면
        elif j == len(t[i]) - 1 :
            # 우측 상단 수를 가산
            t[i][j] += t[i - 1][j - 1]

        # 해당 수가 삼각형 내부에 있는 수라면
        else :
            # 좌측 상단 수와 우측 상단 수 중 큰 값을 가산
            t[i][j] += max(t[i - 1][j - 1], t[i - 1][j])

# 가장 마지막 줄의 최댓값 출력
print(max(t[n - 1]))
