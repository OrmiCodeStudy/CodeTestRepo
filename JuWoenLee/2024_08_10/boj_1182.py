import sys
input = sys.stdin.readline

N, S = map(int, input().split())
numList = list(map(int, input().split()))
calList = []
count = 0

def dfs(start) :
    global count
    
    if sum(calList) == S and len(calList) > 0 :
        count += 1

    for i in range(start, N) :
        calList.append(numList[i])
        dfs(i + 1)
        calList.pop()

dfs(0)
print(count)
