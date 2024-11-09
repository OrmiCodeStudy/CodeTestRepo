# N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램
# 계수 정렬

import sys
input = sys.stdin.readline

n = int(input())
# 최대 10,000개의 수를 저장하기 위한 리스트
# 0번 인덱스는 사용하지 않음
countList = [0] * 10001

for i in range(n) :
    num = int(input())
    # 정수 n의 입력 횟수를 저장
    countList[num] += 1

# 1 ~ 10,000번 인덱스까지 반복
for i in range(1, len(countList)) :
    # 입력 횟수가 0이 아니라면
    if(countList[i] != 0) :
        # countList에 누적된 값만큼 해당 숫자 반복 출력
        for _ in range(countList[i]) :
            print(i)
