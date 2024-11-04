package y2024.Nov.Nov_04;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/*
파이프 옮기기1 - 골드 5

총 공간 : N*N
파이프는 빈칸만 차지해야한다.
파이프를 밀 수 있는 방향은 3가지 (→, ↘, ↓)
회전은 45도만 회전시킬 수 있다.

가장 처음 파이프는 (1,1),(1,2) 를 차지하고있으며 파이프의 한쪽 끝을 (N,N)으로 이동시키는 방법의 개수를 구하라

DFS

0: y
1: x
2: 파이프 방향

DP로 풀어보기
 */

public class beakjoon_17070 {

    public static int dfs(int[][] space){

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0,1,0});
        int[][] dyx = {{0,1},{1,0},{1,1}};
        int cnt = 0;

        while(!q.isEmpty()){
            int[] curr = q.poll();

            if (curr[0] == space.length-1 && curr[1] == space.length-1)
                cnt++;

            for(int i =0;i<dyx.length;i++){
                int newX = curr[1]+dyx[i][1];
                int newY = curr[0]+dyx[i][0];

                if(i==2){
                    if(newX<space.length && newY<space.length){
                        if(space[newY][newX]==0 && space[newY][newX-1]==0 && space[newY-1][newX]==0){
                                q.offer(new int[]{newY,newX,i});
                        }
                    }
                } else if(curr[2]!=0 && i==1) {
                    if(newX<space.length && newY<space.length && space[newY][newX]==0){
                        q.offer(new int[]{newY,newX,i});
                    }
                } else if(curr[2]!=1 && i==0) {
                    if(newX<space.length && newY<space.length && space[newY][newX]==0){
                        q.offer(new int[]{newY,newX,i});
                    }
                }
            }
        }

        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer stk;

        int[][] space = new int[n][n];
        for(int i =0;i<n;i++){
            stk = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                space[i][j]=Integer.parseInt(stk.nextToken());
            }
        }

        bw.write(String.valueOf(dfs(space)));
        bw.flush();
        bw.close();
        br.close();
    }
}
