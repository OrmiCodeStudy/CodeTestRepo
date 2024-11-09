# 상하좌우, 대각선으로 연결된 섬의 개수를 구하는 프로그램

from collections import deque
import sys
input = sys.stdin.readline

# 상하좌우 & 대각선 방향
move_x = [0, 0, 1, -1, -1, -1, 1, 1]
move_y = [1, -1, 0, 0, -1, 1, -1, 1]

def bfs(graph, a, b) :
    # 탐색 큐
    queue = deque()
    # 탐색 큐에 초기 좌표 삽입
    queue.append([a, b])
    # 초기 좌표 방문 여부 변경
    graph[a][b] = 0

    while queue :
        # 탐색할 좌표
        x, y = queue.popleft()
        # 방문 여부 변경
        graph[x][y] = 0

        # 좌표 이동
        for i in range(8) :
            nx = x + move_x[i]
            ny = y + move_y[i]

            # 지도에서 벗어난다면 탐색 X
            if nx < 0 or ny < 0 or nx >= h or ny >= w :
                continue

            # 섬이 존재한다면 방문 여부 변경 및 탐색 큐 삽입
            if graph[nx][ny] == 1 :
                graph[nx][ny] = 0
                queue.append([nx, ny])

# 무한 루프
while True :
    # 지도의 너비, 높이
    w, h  = map(int, input().split())

    # 무한 루프 종료 조건
    if w == 0 and h == 0 :
        break

    # 지도 입력
    graph = []
    for i in range(h) :
        graph.append(list(map(int, input().split())))
    
    # 섬 개수
    count = 0

    # 섬을 발견한다면 해당 좌표부터 탐색
    for i in range(h) :
        for j in range(w) :
            if graph[i][j] == 1 :
                # bfs 실행 == 연결되어있지 않은 다른 섬이 있음 (count += 1)
                bfs(graph, i, j)
                count += 1
    print(count)
