# 순열을 이용하여 방향 그래프의 순열 사이클 개수를 구하는 프로그램

from collections import deque
import sys
input = sys.stdin.readline

def bfs(gragh, start, visited) :
    # 시작 노드 큐 생성
    queue = deque([start])
    # 방문 처리
    visited[start]  = True

    # 큐가 empty일 때까지
    while queue :
        # 큐에서 노드 pop
        v = queue.popleft()
        # 다음 노드
        next = graph[v]
        # 다음 노드를 방문하지 않았다면
        if not visited[next] :
            # 탐색 큐에 추가
            queue.append(next)
            # 방문 여부 변경
            visited[next] = True

# 테스트케이스 개수
t = int(input())

for i in range(t) :
    # 순열의 크기
    n = int(input())
    # 순열 저장
    graph = [0] + list(map(int, input().split()))

    # 방문 여부를 저장하는 배열
    visited = [False] * (n + 1)
    count = 0

    # bfs 탐색
    for i in range(1, n + 1) :
        # 방문하지 않았다면
        if not visited[i] :
            # bfs 탐색 (bfs 종료 = 사이클 생성)
            bfs(graph, i, visited)
            # 사이클 발견, 갯수 증가
            count += 1

    print(count)
