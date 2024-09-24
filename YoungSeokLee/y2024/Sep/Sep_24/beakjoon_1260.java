package y2024.Sep.Sep_24;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

/*
DFS와 BFS - 실버2

그래프를 DFS로 탐색한 결과와 bfs로 탐색한 결과를 출력하라

방문할 수 있는 정점이 여러개인 경우, 정점 번호가 작은 것을 먼저 방문
더이상 방문할 수 있는 점이 없는 경우 종료

N : 정점의 개수
M : 간선의 개수
V : 탐색을 시작할 정점의 번호
M개의 줄에 간선이 연결하는 두 정점의 번호가 주어진다
간선은 양방향
 */
public class beakjoon_1260 {

    String DFS(ArrayList<ArrayList<Integer>> graph, int start,boolean[] visited){
        StringBuffer sb = new StringBuffer();
        Stack<Integer> stack = new Stack<>();

        stack.push(start);

        while(!stack.isEmpty()){
            int current = stack.pop();

            if(!visited[current]){
                sb.append(current).append(" ");
                visited[current] = true;

                for(int i =graph.get(current).size()-1;i>=0;i--){
                    int n = graph.get(current).get(i);
                    if(!visited[n])
                        stack.push(n);
                }
            }
        }

        return sb.toString().trim();
    }

    String BFS(ArrayList<ArrayList<Integer>> graph, int start, boolean[] visited){

        StringBuffer sb = new StringBuffer();
        Queue<Integer> queue = new LinkedList<>();

        queue.add(start);
        visited[start] = true;

        while(!queue.isEmpty()){
            int current = queue.poll();
            sb.append(current).append(" ");

            for(int next : graph.get(current)){
                if(!visited[next]) {
                    queue.add(next);
                    visited[next] = true;
                }
            }
        }

        return sb.toString().trim();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());
        int v = Integer.parseInt(stk.nextToken());

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i =0;i<=n;i++){
            ArrayList<Integer> vertex = new ArrayList<>();
            graph.add(vertex);
        }
        for(int i =0;i<m;i++){
            stk = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(stk.nextToken());
            int end = Integer.parseInt(stk.nextToken());

            graph.get(start).add(end);
            graph.get(end).add(start);
        }

        for(ArrayList<Integer> list:graph){
            Collections.sort(list);
        }

        boolean[] visitedDFS = new boolean[n+1];
        boolean[] visitedBFS = new boolean[n+1];
        beakjoon_1260 T = new beakjoon_1260();
        bw.write(T.DFS(graph,v,visitedDFS)+"\n");
        bw.write(T.BFS(graph,v,visitedBFS));

        bw.flush();
        bw.close();
        br.close();
    }
}
