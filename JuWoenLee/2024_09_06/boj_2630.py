import sys
input = sys.stdin.readline

n = int(input())
colorPaper = [list(map(int, input().split())) for _ in range(n)]
# 0번 인덱스 => 흰 색종이 갯수, 1번 인덱스 => 파란 색종이 갯수
colorCount = [0] * 2

def sol(x, y, n) :

    # 색종이의 시작 지점 색깔
    color = colorPaper[x][y]

    for i in range(x, x + n) :
        for j in range(y, y + n) :
            # 탐색중인 색종이에 색종이의 시작 지점 색깔과 다른 색이 존재한다면
            if color != colorPaper[i][j] :
                # 가로, 세로를 1/2로 잘라서 각각 재귀함수 호출
                sol(x, y, n // 2)
                sol(x, y + n // 2, n //2)
                sol(x + n // 2, y, n // 2)
                sol(x + n // 2, y + n // 2, n // 2)
                return
            
    # 탐색하는 종이의 색깔이 모두 (x, y)의 색이 흰색이면
    if color == 0 :
        colorCount[0] += 1
    # 탐색하는 종이의 색깔이 모두 (x, y)의 색이 파란색이면
    else :
        colorCount[1] += 1

sol(0, 0, n)
print(*colorCount, sep='\n')
