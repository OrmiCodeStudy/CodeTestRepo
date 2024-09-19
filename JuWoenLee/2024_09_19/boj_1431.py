# 시리얼 번호를 순서대로 정렬하는 프로그램
# 시리얼 번호가 짧은 것이 우선
# 길이가 같다면, 숫자의 합이 적은 것이 우선
# 위의 조건으로 비교가 불가능하다면, 사전 순으로 앞선 것이 우선

import sys
input = sys.stdin.readline

count = int(input())
serialNums = [input().strip() for _ in range(count)]

# 정렬 기준 함수 정의
def sort_key(serial) :
    # 시리얼 번호 내의 숫자 합
    num_sum = sum(int(ch) for ch in serial if ch.isdigit())
    # 1. 길이, 2. 숫자 합, 3. 사전 순
    return(len(serial), num_sum, serial)

# 정렬 기준을 적용한 정렬
serialNums = sorted(serialNums, key=sort_key)

# 출력
print(*serialNums, sep='\n')
