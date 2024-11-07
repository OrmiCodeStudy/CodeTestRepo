package y2024.Nov.Nov_07;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
최단경로 - 골드 4

방향 그래프가 주어지면 주어진 시작점에서 다른 모든 정점으로의 최단 경로를 구하라

모든 간선의 가중치는 10 이하의 자연수이다

v : 정점의 개수
e : 간선의 개수

풀이
다익스트라 알고리즘을 사용
 */

public class beakjoon_1753 {

    static int v, e, start;
    static ArrayList<ArrayList<int[]>> graph;
    static int[] dists;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stk = new StringTokenizer(br.readLine());

        v = Integer.parseInt(stk.nextToken());
        e = Integer.parseInt(stk.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i <= v; i++) {
            graph.add(new ArrayList<>());
        }

        start = Integer.parseInt(br.readLine());

        for (int i = 0; i < e; i++) {
            stk = new StringTokenizer(br.readLine());
            int origin = Integer.parseInt(stk.nextToken());
            int end = Integer.parseInt(stk.nextToken());
            int weight = Integer.parseInt(stk.nextToken());

            graph.get(origin).add(new int[]{end, weight});
        }

        dijkstra();

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < dists.length; i++) {
            sb.append(dists[i]>=200000 ? "INF" : dists[i]).append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static void dijkstra() {
        dists = new int[v + 1];
        Arrays.fill(dists, 200000);
        dists[start] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int currPos = curr[0];
            int weight = curr[1];

            if (weight > dists[currPos]) {
                continue;
            }

            for (int[] point : graph.get(currPos)) {
                int newWeight = weight + point[1];
                if(newWeight<dists[point[0]]){
                    dists[point[0]] = Math.min(dists[point[0]], newWeight);
                    pq.offer(new int[]{point[0], newWeight});
                }
            }
        }
    }
}
