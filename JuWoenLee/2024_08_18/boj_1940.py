import sys
input = sys.stdin.readline

N = int(input())
M = int(input())
sortedList = sorted(list(map(int, input().split())))
count, i, j = 0, 0, N - 1

while(i < j) :
    sumValue = sortedList[i] + sortedList[j]
    if(sumValue < M) : i += 1
    elif(sumValue > M) : j -= 1
    else :
        count += 1
        i += 1
        j -= 1

print(count)
