# 시리얼 번호를 순서대로 정렬하는 프로그램
# 시리얼 번호가 짧은 것이 우선
# 길이가 같다면, 숫자의 합이 적은 것이 우선
# 위의 조건으로 비교가 불가능하다면, 사전 순으로 앞선 것이 우선

import sys
input = sys.stdin.readline

count = int(input())
serialNums = [input().strip() for _ in range(count)]

# 버블 정렬
for i in range(count - 1):
    for j in range(i + 1, count):

        # 비교할 시리얼 번호의 길이가 다르다면, 짧은 것이 먼저 오도록 정렬
        if len(serialNums[i]) > len(serialNums[j]):
            serialNums[i], serialNums[j] = serialNums[j], serialNums[i]

        # 비교할 시리얼 번호의 길이가 같다면
        elif len(serialNums[i]) == len(serialNums[j]):

            # 첫 번째 시리얼 번호의 숫자 합 계산
            iSum = sum(int(ch) for ch in serialNums[i] if ch.isdigit())

            # 두 번째 시리얼 번호의 숫자 합 계산
            jSum = sum(int(ch) for ch in serialNums[j] if ch.isdigit())

            # 숫자 합 비교, 숫자 합이 작은 시리얼 번호가 먼저 오도록 정렬
            if iSum > jSum:
                serialNums[i], serialNums[j] = serialNums[j], serialNums[i]

            # 위의 두 조건으로 비교가 불가능하다면
            elif iSum == jSum:
                # 사전 순 비교
                if serialNums[i] > serialNums[j]:
                    serialNums[i], serialNums[j] = serialNums[j], serialNums[i]

# 출력
print(*serialNums, sep='\n')
