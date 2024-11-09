# 최단 거리 미로 찾기 프로그램
# (0, 0) -> (n, m)

from collections import deque
import sys
input = sys.stdin.readline

n, m = map(int, input().split())
maze = [list(map(int, input().rstrip())) for _ in range(n)]

# 상하좌우
move_x = [0, 0, 1, -1]
move_y = [1, -1, 0, 0]

def bfs(graph, start_x,  start_y) :
    # 탐색 큐
    queue = deque()
    # 탐색 큐에 초기 좌표 삽입
    queue.append((start_x, start_y))

    while queue :
        # 탐색할 좌표
        x, y = queue.popleft()

        # 좌표 이동
        for i in range(4) :
            nx = x + move_x[i]
            ny = y + move_y[i]

            # 이동할 좌표가 벽이 아니고, 이동 가능한 칸이라면
            if 0<= nx < n and 0 <= ny < m and graph[nx][ny] == 1 :
                # 탐색 큐에 좌표 삽입
                queue.append([nx, ny])
                # 이동 거리 == (x, y)좌표의 값(직전 이동 거리) + 1
                graph[nx][ny] = graph[x][y] + 1
    
    # (n, m) 좌표의 값 == 최소 이동 거리
    return graph[n - 1][m - 1]

print(bfs(maze, 0, 0))
