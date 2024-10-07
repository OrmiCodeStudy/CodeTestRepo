package y2024.Oct.Oct_04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/*
쉬운 최단거리 - 실버1

지도가 주어졌을때, 각 지점에서 목표지점까지의 거리를 출력하라
2 : 목표지점
1 : 갈 수 있는 땅
0 : 갈 수 없는 땅
 */

class position {

    private final int x;
    private final int y;
    private final int dist;

    position(int x, int y, int dist){
        this.x = x;
        this.y = y;
        this.dist = dist;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getDist() {
        return dist;
    }
}
public class beakjoon_14940 {
    void BFS(int[][] map, int[][] distance,boolean[][] isVisited,int startX, int startY){

        int[] dx = {0,1,0,-1};
        int[] dy = {1,0,-1,0};

        Queue<position> q = new ArrayDeque<>();
        q.add(new position(startX,startY,0));
        isVisited[startY][startX]=true;
        distance[startY][startX]=0;



        while(!q.isEmpty()){
            position current = q.poll();

            for(int i =0;i<4;i++){
                int newX = current.getX()+dx[i];
                int newY = current.getY()+dy[i];

                if(0<=newX && newX<map[0].length && 0<=newY && newY<map.length)
                    if(!isVisited[newY][newX] && map[newY][newX]!=0){
                        isVisited[newY][newX] = true;
                        distance[newY][newX] = current.getDist()+1;

                        q.add(new position(newX,newY,distance[newY][newX]));
                    }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        int[][] distance = new int[n][m],map = new int[n][m];
        boolean[][] isVisited = new boolean[n][m];
        int startX = 0,startY=0;

        for (int i =0;i<n;i++){
            stk = new StringTokenizer(br.readLine());
            for(int j =0;j<m;j++){
                map[i][j]=Integer.parseInt(stk.nextToken());
                if(map[i][j]==2){
                    startX = j;
                    startY = i;
                } else if (map[i][j]==0){
                    distance[i][j] = 0;
                } else {
                    distance[i][j] = -1;
                }
            }
        }

        beakjoon_14940 T = new beakjoon_14940();
        T.BFS(map,distance,isVisited,startX,startY);

        StringBuilder sb = new StringBuilder();;
        for(int i=0;i<n;i++){

            for(int j=0;j<m;j++){
                sb.append(distance[i][j]).append(" ");
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
