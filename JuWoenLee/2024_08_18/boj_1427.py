import sys
input = sys.stdin.readline

N = input()
A = []
for i in range(len(N) - 1) :
    A.append(int(N[i]))

for i in range(len(A)) :
    maxIdx = i

    for j in range(i + 1, len(A)) :
        if(A[j] > A[maxIdx]) :
            maxIdx = j

    if(A[i] < A[maxIdx]) :
        A[i], A[maxIdx] = A[maxIdx], A[i]

for a in A :
    print(a, end='')
