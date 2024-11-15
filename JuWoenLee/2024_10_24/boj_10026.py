# R, G, B 3개의 색상이 주어지는 n * n 그리드에서 각 색상 별로 구역을 나누는 프로그램
# 적록색약(빨간색과 초록색 구분 힘듦)이 없는 경우의 구역 수와 적록색약이 있는 경우의 구역 수를 출력

from collections import deque
import sys
input = sys.stdin.readline

n = int(input())
grid = [list(input().rstrip()) for _ in range(n)]
visited_normal = [[False] * n for _ in range(n)]
visited_colorblind = [[False] * n for _ in range(n)]

# 상하좌우
move_x = [0, 0, 1, -1]
move_y = [1, -1, 0, 0]

def bfs(graph, start_x, start_y, visited) :
    # 탐색 큐
    queue = deque()
    # 탐색 큐에 초기 좌표 삽입
    queue.append((start_x, start_y))
    # 방문 여부 변경
    visited[start_x][start_y] = True
    # 현재 색상 저장
    color = graph[start_x][start_y]

    while queue :
        # 탐색할 좌표
        x, y = queue.popleft()

        # 좌표 이동
        for i in range(4) :
            nx = x + move_x[i]
            ny = y + move_y[i]

            # 좌표가 그리드를 벗어나지 않고, 탐색 색상과 같으며, 아직 방문하지 않은 좌표라면
            if 0 <= nx < n and 0 <= ny < n and graph[nx][ny] == color and not visited[nx][ny]:
                queue.append((nx, ny))
                visited[nx][ny] = True

# 구역 카운팅
def count_zone(graph, visited) :
    count = 0

    # 전체 그래프 탐색
    for i in range(n) :
        for j in range(n) :
            # 방문하지 않았다면 (아직 탐색되지 않은 구역)
            if not visited[i][j] :
                # bfs 실행
                bfs(graph, i, j, visited)
                # 구역 수 증가
                count += 1
    # 최종 구역 수 반환
    return count

# 적록색약이 없는 경우의 구역 수
normal = count_zone(grid, visited_normal)

# 적록색약으로 변경 (R -> G)
for i in range(n) :
    for j in range(n) :
        if grid[i][j] == 'R' :
            grid[i][j] = 'G'

# 적록색약이 있는 경우의 구역 수
colorblind = count_zone(grid, visited_colorblind)

print(normal, colorblind)
