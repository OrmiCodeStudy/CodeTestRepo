# 정렬 과정을 출력하는 프로그램

import sys
input = sys.stdin.readline

wood = list(map(int, input().split()))

# 완벽히 정렬될 때까지 반복
while wood != [1, 2, 3, 4, 5] :
    for i in range(4) :
        # swap
        if wood[i] > wood[i + 1] :
            wood[i], wood[i + 1] = wood[i + 1], wood[i]
            print(*wood)
