package y2024.Nov.Nov_06;

import java.io.*;
import java.util.*;

/*
특정한 최단 경로 - 골드 4

방향이없는 그래프가주어진다

1번 정점에서 n번 정점으로 최단 거리로 이동해야한다
조건
1. 임의로 주어진 두 정점은 반드시 통과해야 한다
2. 한번 이동해던 정점과 간선도 다시  이용 가능하다.

N : 정점의개수
E : 간선의개수

A번 정점에서 B정점으로의 양방향 길이 존재
거리가 C

반드시거쳐야 하는 두개의 서로 다른정점 번호 V1과 V2가 주어진다.


간선에 가중치가 주어지므로 다익스트라 알고리즘 사용
1부터 n까지 최단거리를구하되 조건 부여(n에 도착한 경우, U,V를 거쳤는지 확인)
 */
public class beakjoon_1504 {
    static int n, e, u, v;
    static ArrayList<ArrayList<int[]>> graph;
    static int[] dists;
    static final int INF = 200000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());
        e = Integer.parseInt(stk.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }


        for (int i = 0; i < e; i++) {
            stk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            int c = Integer.parseInt(stk.nextToken());

            graph.get(a).add(new int[]{b, c});
            graph.get(b).add(new int[]{a, c});
        }

        stk = new StringTokenizer(br.readLine());
        u = Integer.parseInt(stk.nextToken());
        v = Integer.parseInt(stk.nextToken());

        int course1=0,course2=0;
        dijkstra(1);
        course1 += dists[u];
        course2 += dists[v];
        dijkstra(u);
        course1 += dists[v];
        course2 += dists[n];
        dijkstra(v);
        course1 += dists[n];
        course2 += dists[u];

        int answer=Math.min(course1,course2);
        bw.write(String.valueOf(answer>=INF?-1:answer));
        bw.flush();
        bw.close();
        br.close();

    }

    private static void dijkstra(int start) {
        dists = new int[n + 1];
        Arrays.fill(dists, INF);
        dists[start] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int currNode = curr[0];
            int currDist = curr[1];

            if (currDist > dists[currNode]) {
                continue;
            }

            ArrayList<int[]> neighbors = graph.get(currNode);
            for (int[] neighbor : neighbors) {
                int nextNode = neighbor[0];
                int weight = neighbor[1];
                int newDist = currDist + weight;

                if (newDist < dists[nextNode]) {
                    dists[nextNode] = newDist;
                    pq.offer(new int[]{nextNode, newDist});
                }
            }
        }
    }
}
