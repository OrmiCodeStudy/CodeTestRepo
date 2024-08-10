import sys
input = sys.stdin.readline

N = int(input())
A = []
max = 0

for i in range(N) :
    A.append((int(input()), i))

sortA = sorted(A)

for i in range(N) :
    if max < sortA[i][1] - A[i][1] :
        max = sortA[i][1] - A[i][1]

print(max + 1)
