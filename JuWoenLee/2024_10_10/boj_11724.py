# 양방향 그래프의 연결 요소 개수를 구하는 프로그램

from collections import deque
import sys
input = sys.stdin.readline

def bfs(graph, start, visited) :
    # 시작 노드를 큐에 추가
    queue = deque([start])
    # 방문 여부 변경
    visited[start] = True

    # 연결된 모든 노드 탐색
    while queue :
        v = queue.popleft()
        # 현재 노드와 연결된 노드를 탐색
        for i in graph[v] :
            # 방문한 적 없는 노드라면
            if not visited[i] :
                # 탐색될 수 있도록 큐에 추가
                queue.append(i)
                # 방문 여부 변경
                visited[i] = True

n, m = map(int, input().split())
graph = [[] for _ in range(n + 1)]

# 간선 정보 저장
for i in range(m) :
    u, v = map(int, input().split())
    graph[u].append(v)
    graph[v].append(u)

# 방문 확인
visited = [False] * (n + 1)
count = 0

# 그래프의 모든 노드를 순회
for i in range(1, n + 1) :
    # 방문하지 않았으면 bfs 실행
    if not visited[i] :
        bfs(graph, i, visited)
        count += 1

print(count)
