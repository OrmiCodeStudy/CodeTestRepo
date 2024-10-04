package y2024.October.Oct_04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
경로 찾기 - 실버1

가중치 없는 방향 그래프 G가 주어졌을때, 모든 정점 i,j에 대해서, i에서 j로 가는 길이가 양수인 경로가 있는지 없는지 구하는 프로그램을 작성하라

N : 정점의 개수
i번째 줄의 j번째 숫자가 1 : i에서 j로 가는 간선이 존재

모든 경로를 다 확인해야 한다
BFS로 풀어보기
 */
public class beakjoon_11403 {

    int BFS(ArrayList<ArrayList<Integer>> graph, int start, int end, int n) {
        Queue<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[n];
        q.add(start);

        while(!q.isEmpty()) {
            int current = q.poll();

            for(int num : graph.get(current)) {
                if(num == end) return 1;
                if(!visited[num]) {
                    q.add(num);
                    visited[num] = true;
                }
            }
        }

        return 0;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer stk;

        ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();

        for(int i =0;i<n;i++){
            graph.add(new ArrayList<Integer>());
        }

        for(int i =0;i<n;i++){
            stk=new StringTokenizer(br.readLine());
            for(int j =0;j<n;j++){
                int exist = Integer.parseInt(stk.nextToken());
                if(exist == 1){
                    graph.get(i).add(j);
                }
            }
        }
        int[][] isValid = new int[n][n];

        beakjoon_11403 T = new beakjoon_11403();

        StringBuilder sb = new StringBuilder();
        for(int i =0;i<n;i++){
            for (int j =0;j<n;j++){
                isValid[i][j] = T.BFS(graph,i,j,n);
                sb.append(isValid[i][j]).append(" ");
            }
            sb.append("\n");
        }

        bw.write(sb.toString().trim());
        bw.flush();
        bw.close();
        br.close();

    }
}
