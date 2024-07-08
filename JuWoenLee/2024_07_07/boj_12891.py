import sys
input = sys.stdin.readline

S, P = map(int, input().split())

inputStr = input().strip()
countCheckArr = list(map(int, input().split()))
currentCountArr = [0] * 4

conditionArr = [False] * 4
count = 0

for i in range(P) :
    if(inputStr[i] == 'A') : currentCountArr[0] += 1
    elif(inputStr[i] == 'C') : currentCountArr[1] += 1
    elif(inputStr[i] == 'G') : currentCountArr[2] += 1
    elif(inputStr[i] == 'T') : currentCountArr[3] += 1

for j in range(4) :
    if(currentCountArr[j] >= countCheckArr[j]) :
        conditionArr[j] = True

if all(conditionArr) : count += 1

for i in range(1, S - P + 1) :
    j = i + P - 1

    if(inputStr[i - 1] == 'A') : currentCountArr[0] -= 1
    elif(inputStr[i - 1] == 'C') : currentCountArr[1] -= 1
    elif(inputStr[i - 1] == 'G') : currentCountArr[2] -= 1
    elif(inputStr[i - 1] == 'T') : currentCountArr[3] -= 1

    if(inputStr[j] == 'A') : currentCountArr[0] += 1
    elif(inputStr[j] == 'C') : currentCountArr[1] += 1
    elif(inputStr[j] == 'G') : currentCountArr[2] += 1
    elif(inputStr[j] == 'T') : currentCountArr[3] += 1

    conditionArr = [False] * 4

    for k in range(4) :
        if(currentCountArr[k] >= countCheckArr[k]) : conditionArr[k] = True
    
    if all(conditionArr) : count += 1

print(count)
