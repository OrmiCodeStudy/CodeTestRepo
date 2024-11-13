package y2024.Nov.Nov_13;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
트리의 지름 - 골드4

트리의 지름 : 트리에 존재하는 모든 경로들 중에서 가장 긴 것의 길이

입력으로 루트가 있는 트리를 가중치가 있는 간선들로 줄 때, 트리의 지름을 구해서 출력하라

n : 노드의 개수
n-1개의 줄에 각 간선의 정보 : 부모 노드의 번호 | 자식 노드 | 간선의 가중치
루트노드는 항상 1

풀이
다익스트라를 리프 노드의 개수만큼 반복해 가장 긴 거리를 출력

한 지점에서 다른 지점까지의 거리를 계산
 */
public class beakjoon_1967 {

    static ArrayList<ArrayList<int[]>> tree;
    static ArrayList<Integer> leaf;

    //start 에서 모든 leaf로의 거리를 계산해 가장 긴 값을 반환
    private static int djikstra(int start) {
        int n = tree.size() - 1;
        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);
        dist[start] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int currentNode = current[0];
            int currentDist = current[1];

            if (currentDist > dist[currentNode]) continue;

            for (int[] neighbor : tree.get(currentNode)) {
                int nextNode = neighbor[0];
                int weight = neighbor[1];
                int distance = currentDist + weight;

                if (dist[nextNode] == -1 || distance < dist[nextNode]) {
                    dist[nextNode] = distance;
                    pq.offer(new int[]{nextNode, distance});
                }
            }
        }

        int maxDist = 0;
        for (int d : dist) {
            if (d != -1) {
                maxDist = Math.max(maxDist, d);
            }
        }

        return maxDist;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        tree = new ArrayList<>();
        leaf = new ArrayList<>();
        for(int i =0;i<=n;i++){
            tree.add(new ArrayList<>());
            if(i!=0){
                leaf.add(i);
            }
        }

        StringTokenizer stk;

        for(int i =0;i<n-1;i++){
            stk = new StringTokenizer(br.readLine());
            int pNode = Integer.parseInt(stk.nextToken());
            int cNode = Integer.parseInt(stk.nextToken());
            int weight = Integer.parseInt(stk.nextToken());

            tree.get(pNode).add(new int[]{cNode,weight});
            tree.get(cNode).add(new int[]{pNode,weight});
            leaf.remove(Integer.valueOf(pNode));
        }

        int maxVal = Integer.MIN_VALUE;
        for(int i: leaf){
            maxVal = Math.max(djikstra(i), maxVal);
        }

        bw.write(String.valueOf(maxVal));
        bw.flush();
        bw.close();
        br.close();
    }
}
