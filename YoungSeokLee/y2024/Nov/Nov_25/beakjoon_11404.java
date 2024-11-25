package y2024.Nov.Nov_25;

import java.io.*;
import java.util.*;

/*
플로이드 - 골드 4

n개의 도시와 m개의 버스가 있을때
모든 도시의 쌍에 대해서 도시 a에서 b로 가는데 필요한 비용의 최솟값을 구하는 프로그램을 작성하라

풀이
다익스트라를 n번 반복
 */
public class beakjoon_11404 {

    static int n,m,totalWeight=Integer.MAX_VALUE;
    static ArrayList<ArrayList<int[]>> graph;

    static int[] dijkstra(int start) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        int[] dist = new int[n + 1];
        Arrays.fill(dist, totalWeight);
        dist[start] = 0;
        pq.offer(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int currentNode = current[0];
            int currentDist = current[1];

            if (dist[currentNode] < currentDist) continue;

            for (int[] edge : graph.get(currentNode)) {
                int nextNode = edge[0];
                int weight = edge[1];
                if (dist[nextNode] > dist[currentNode] + weight) {
                    dist[nextNode] = dist[currentNode] + weight;
                    pq.offer(new int[]{nextNode, dist[nextNode]});
                }
            }
        }

        for(int i =1;i<=n;i++){
            if(dist[i]==totalWeight)
                dist[i]=0;
        }

        return dist;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        graph = new ArrayList<>();
        for(int i =0;i<=n;i++){
            graph.add(new ArrayList<>());
        }

        StringTokenizer stk;
        for(int i =0 ;i<m;i++){
            stk = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(stk.nextToken());
            int end = Integer.parseInt(stk.nextToken());
            int weight = Integer.parseInt(stk.nextToken());

            graph.get(start).add(new int[]{end, weight});
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            int[] dist = dijkstra(i);
            for (int j = 1; j <= n; j++) {
                sb.append(dist[j]).append(" ");
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
