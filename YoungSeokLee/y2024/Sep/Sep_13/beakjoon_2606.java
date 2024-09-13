package y2024.Sep.Sep_13;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
바이러스

바이러스에 감염된 컴퓨터와 같은 네트워크에 있는 컴퓨터는 바이러스에 감염된다.

1번컴퓨터를 통해 바이러스에 감염되는 컴퓨터의 수를 출력하라
 */
public class beakjoon_2606 {
    static int BFS(int start, ArrayList<ArrayList<Integer>> graph, boolean[] visited){
        int cnt = 0;
        Queue<Integer> visitedQueue = new LinkedList<>();
        visitedQueue.offer(start);
        visited[start] = true;

        while(!visitedQueue.isEmpty()){
            int current = visitedQueue.poll();
            for(int computer : graph.get(current)){
                if(!visited[computer]){
                    cnt++;
                    visitedQueue.offer(computer);
                    visited[computer] = true;
                }
            }
        }

        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int comNum = Integer.parseInt(br.readLine());
        int pairNum = Integer.parseInt(br.readLine());

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for(int i = 0; i <= comNum; i++){
            graph.add(new ArrayList<Integer>());
        }

        StringTokenizer stk;
        for(int i = 0; i < pairNum; i++){
            stk = new StringTokenizer(br.readLine());
            int origin = Integer.parseInt(stk.nextToken());
            int end = Integer.parseInt(stk.nextToken());

            graph.get(origin).add(end);
            graph.get(end).add(origin); // 양방향 연결 추가
        }

        boolean[] visited = new boolean[comNum + 1];
        bw.write(BFS(1, graph, visited) + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
