package y2024.Oct.Oct_31;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
숨바꼭질 3 - 골드 5

N : 수빈이의 현재 위치
K : 동생의 위치

이동방식
1. 걷기 : x+1 / x-1 (1초 소요)
2. 순간이동 : 2*X (0초 소요)
*/
public class beakjoon_13549 {

    static int[] graph = new int[100001];
    static int n,k;

    static void bfs(){

        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.offer(n);

        while(!q.isEmpty()){
            int curr = q.poll();
            if(curr==k)
                return;

            if(curr*2<=100000 && graph[curr * 2] > graph[curr]){
                graph[curr*2]=graph[curr];
                q.offer(curr*2);
            }
            if(curr+1<=100000 && graph[curr + 1] > graph[curr] + 1){
                graph[curr+1]=graph[curr]+1;
                q.offer(curr+1);
            }
            if(curr-1>=0 && graph[curr - 1] > graph[curr] + 1){
                graph[curr-1]=graph[curr]+1;
                q.offer(curr-1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stk = new StringTokenizer(br.readLine());

        n = Integer.parseInt(stk.nextToken()); // 수빈의 위치
        k = Integer.parseInt(stk.nextToken()); // 동생의 위치

        Arrays.setAll(graph,i->Integer.MAX_VALUE);
        graph[n]=0;
        bfs();
        bw.write(String.valueOf(graph[k]));
        bw.flush();
        bw.close();
        br.close();
    }
}
