# 아파트 단지의 번호를 매겨, 단지의 수와 각 단지에 속한 집의 개수를 출력하는 프로그램

from collections import deque
import sys
input = sys.stdin.readline

n = int(input())
graph = []
result = []

for _ in range(n):
    graph.append(list(map(int, input().rstrip())))

# 상하좌우 좌표
move_x = [0, 0, 1, -1]
move_y = [1, -1, 0, 0]

def bfs(graph, a, b) :
    queue = deque()
    # 탐색 큐에 삽입
    queue.append([a,  b])
    # 방문 처리
    graph[a][b] = 0
    # 단지 내의 집 수
    count = 1

    while queue : 
        x, y = queue.popleft()
        # 방문 처리
        graph[x][y] = 0

        # 상하좌우 이동
        for i in range(4) :
            nx = x + move_x[i]
            ny = y + move_y[i]

            # 배열을 넘어선다면 탐색 진행 X
            if nx < 0 or ny < 0 or nx >= n or ny >= n :
                continue

            # 같은 단지 내의 집이라면
            if graph[nx][ny] == 1 :
                # 방문 처리
                graph[nx][ny] = 0
                # 탐색 큐에 삽입
                queue.append([nx, ny])
                # 집 수 증가
                count += 1
    # 탐색이 완료된 한 단지의 집 수 반환
    return count
    
    
for i in range(n) :
    for j in range(n) :
        # 집이 있는 곳이라면 해당 좌표에서 부터 상하좌우 탐색
        if graph[i][j] == 1 :
            # bfs 실행 및 반환값 삽입
            result.append(bfs(graph, i, j))

# 오름차순 정렬
result.sort()
# 단지 수 출력
print(len(result))
# 각 단지 내의 집 수 출력
for r in result :
    print(r)
