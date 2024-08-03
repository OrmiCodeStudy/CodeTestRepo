import sys
input = sys.stdin.readline

N = int(input())

inputArr = []
ansArr = []
stackArr = []
num = 1

for i in range(N) :
    inputArr.append(int(input()))

for i in inputArr :
    if(len(stackArr) == 0 or stackArr[-1] < i) :
        while(num <= i) :
            stackArr.append(num)
            ansArr.append('+')
            num += 1

    if(len(stackArr) != 0) :
        if (stackArr[-1] == i) :
            stackArr.pop()
            ansArr.append('-')
        elif (stackArr[-1] > i) :
            print('NO')
            exit(0)

for c in ansArr :
    print(c)
