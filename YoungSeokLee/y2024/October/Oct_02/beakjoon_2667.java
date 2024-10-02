package y2024.October.Oct_02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Queue;
import java.util.Stack;

/*
단지번호붙이기 - 실버1

정사각형 모양의 지도가 있다
1 : 집이 있는 곳
0 : 집이 없는 곳

단지 : 연결된 집들의 모임

각 단지에 속하는 집의 수를 오름차순으로 정렬하여 출력하라

n : 지도의 크기

순회하면서 해당지점을 기준으로 1이 없을때까지 BFS 순회
방문 가능한 집이 없다면 다시 해당 지점부터 순회
 */
public class beakjoon_2667 {

    int BFS(int[][] map, boolean[][] isVisited,int startX, int startY){

        int cnt = 1;
        Queue<int[]> q = new ArrayDeque<>();
        int[] dx = {0,1,0,-1};
        int[] dy = {1,0,-1,0};

        q.add(new int[]{startX,startY});
        isVisited[startY][startX]=true;

        while(!q.isEmpty()){
            int[] current = q.poll();

            for(int i =0;i<4;i++){
                int newX = current[0]+dx[i];
                int newY = current[1]+dy[i];
                if(0<= newX && newX<map.length && 0<=newY && newY<map.length){
                    if(map[newY][newX]==1 && !isVisited[newY][newX]){
                        q.add(new int[]{newX,newY});
                        isVisited[newY][newX] = true;
                        cnt++;
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
        int[][] map = new int[n][n];
        boolean[][] isVisited = new boolean[n][n];

        for(int i =0;i<n;i++){
            int[] line = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
            for(int j =0;j<n;j++){
                map[i][j]=line[j];
            }
        }

        beakjoon_2667 T = new beakjoon_2667();
        ArrayList<Integer> answer = new ArrayList<>();

        for(int i =0;i<n;i++){
            for(int j =0;j<n;j++){
                if(map[i][j]==1 && !isVisited[i][j]){
                    int temp = T.BFS(map,isVisited,j,i);
                    answer.add(temp);
                }
            }
        }

        Collections.sort(answer);

        bw.write(answer.size()+"\n");
        for(int num:answer){
            bw.write(num+"\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
