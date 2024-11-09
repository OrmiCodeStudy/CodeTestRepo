# 회원의 나이와 이름이 가입한 순서대로 주어질 때,
# 나이가 증가하는 순으로,
# 나이가 같으면 먼저 가입한 사람이 앞에 오는 순서로 정렬하는 프로그램

import sys
input = sys.stdin.readline

n = int(input())
members = list()

# 입력 저장
for i in range(n) :
    members.append(input().split())

# 나이순 정렬
members = sorted(members, key = lambda x: int(x[0]))

# 출력
for member in members :
    print(*member)
