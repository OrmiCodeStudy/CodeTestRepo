package y2024.Nov.Nov_29;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
서강 그라운드 - 골드 4

낙하한 지역을 중심으로 수색범위 M이내의 모든 아이템을 습득 가능할 때 획득가능한 아이템의 최고갯수를 구하라

풀이
다익스트라를 통해 시작지점별 각 지점까지의 거리를 계산
습득 가능한 지점들의 아이템 갯수의 합을 구해 가장 큰 경우를 출력
 */
public class beakjoon_14938 {
    static int n,m,r,maxItems=0;
    static int[] items;
    static ArrayList<ArrayList<int[]>> graph;

    static void djikstra(int start) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[1], b[1]));
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        pq.offer(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int node = curr[0];
            int distance = curr[1];

            if (dist[node] < distance) continue;

            for (int[] road : graph.get(node)) {
                int nextNode = road[0];
                int nextDist = distance + road[1];
                if (nextDist < dist[nextNode]) {
                    dist[nextNode] = nextDist;
                    pq.offer(new int[]{nextNode, nextDist});
                }
            }
        }

        int itemCount = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] <= m) {
                itemCount += items[i];
            }
        }
        maxItems = Math.max(maxItems, itemCount);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        n = Integer.parseInt(stk.nextToken()); // 지점의 갯수
        m = Integer.parseInt(stk.nextToken()); // 수색 범위
        r = Integer.parseInt(stk.nextToken()); // 길의 갯수

        items = new int[n+1];
        stk = new StringTokenizer(br.readLine());
        for(int i =1;i<=n;i++)
            items[i]=Integer.parseInt(stk.nextToken());

        graph = new ArrayList<>();
        for(int i=0;i<=n;i++)
            graph.add(new ArrayList<int[]>());
        for(int i=0;i<r;i++){
            stk = new StringTokenizer(br.readLine());
            int start=Integer.parseInt(stk.nextToken());
            int end=Integer.parseInt(stk.nextToken());
            int weight=Integer.parseInt(stk.nextToken());
            graph.get(start).add(new int[]{end,weight});
            graph.get(end).add(new int[]{start,weight});
        }

        for(int i =1;i<=n;i++)
            djikstra(i);

        bw.write(String.valueOf(maxItems));
        bw.flush();
        bw.close();
        br.close();
    }
}
