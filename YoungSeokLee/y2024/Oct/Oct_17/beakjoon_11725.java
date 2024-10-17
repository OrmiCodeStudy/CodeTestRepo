package y2024.Oct.Oct_17;

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
트리의 부모 찾기 - 실버2

각 노드의 부모를 구하는 프로그램
트리의 루트 : 1

BFS로 부모 요소를 찾아 기록
 */
public class beakjoon_11725 {

    static int[] result;
    void BFS(int start,ArrayList<ArrayList<Integer>> graph){

        boolean[] visited = new boolean[graph.size()+1];
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start);
        visited[start]=true;

        while(!q.isEmpty()){
            int curr = q.poll();

            for(int num: graph.get(curr)){
                if(!visited[num]){
                    result[num]=curr;
                    q.offer(num);
                    visited[num]=true;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i =0;i<=n;i++){
            graph.add(new ArrayList<>());
        }

        StringTokenizer stk;
        for(int i =0;i<n-1;i++){
            stk = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(stk.nextToken());
            int end = Integer.parseInt(stk.nextToken());

            graph.get(start).add(end);
            graph.get(end).add(start);
        }

        beakjoon_11725 T = new beakjoon_11725();
        result = new int[graph.size()+1];
        T.BFS(1,graph);
        for(int i =2;i<=n;i++){
            bw.write(String.valueOf(result[i]));
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
