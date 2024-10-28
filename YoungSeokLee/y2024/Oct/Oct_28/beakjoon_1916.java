package y2024.Oct.Oct_28;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
최소비용 구하기 - 골드 5

N : 도시의 개수
M : 한 도시에서 다른 도시로 이동하는 버스의 개수
A 도시부터 B 도시까지 가는데 드는 버스 비용을 최소화하라

풀이
가중치가 서로 다른 그래프 (다익스트라 알고리즘)

 */
class Node implements Comparable<Node> {
    int vertex, weight;

    Node(int vertex, int weight) {
        this.vertex = vertex;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node other) {
        return this.weight - other.weight;
    }
}

public class beakjoon_1916 {
    int dijkstra(ArrayList<ArrayList<Node>> graph,int start,int end){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] dist = new int[graph.size()];
        Arrays.fill(dist, Integer.MAX_VALUE);

        pq.offer(new Node(start,0));
        dist[start] = 0;

        while(!pq.isEmpty()){
            Node curr = pq.poll();
            int currV = curr.vertex;
            if(currV == end){
                return dist[currV];
            }

            for(Node v : graph.get(currV)){
                if(dist[currV]+v.weight < dist[v.vertex]){
                    dist[v.vertex] = dist[currV]+v.weight;
                    pq.offer(new Node(v.vertex,dist[v.vertex]));
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        ArrayList<ArrayList<Node>> graph = new ArrayList<>();
        for(int i =0;i<=n;i++){
            graph.add(new ArrayList<>());
        }

        StringTokenizer stk;
        for(int i =0;i<m;i++){
            stk = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(stk.nextToken());
            int end = Integer.parseInt(stk.nextToken());
            int fee = Integer.parseInt(stk.nextToken());
            graph.get(start).add(new Node(end,fee));
        }

        stk = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(stk.nextToken());
        int end = Integer.parseInt(stk.nextToken());

        beakjoon_1916 T = new beakjoon_1916();
        bw.write(String.valueOf(T.dijkstra(graph,start,end)));
        bw.flush();
        bw.close();
        br.close();
    }
}
