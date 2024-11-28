package y2024.Nov.Nov_28;

import java.io.*;
import java.util.*;

/*
연구소 - 골드 4

벽과 빈공간으로 이루어진 nxm 공간
새로 세울 수 있는 벽의 갯수는 3개 (반드시 3개를 세워야 함)
0 : 빈칸
1 : 벽
2 : 바이러스 위치
바이러스는 상하좌우로 이동 가능

안전 영역 : 벽을 세운 후 바이러스가 퍼질 수 없는 공간
안전영역 크기의 최대치를 구하라

풀이
0인 위치를 순회하면서 벽으로 변환한 int[][]를 생성
해당 배열을 dfs에 반영해 안전 영역의 크기를 확인
이전 최대 안전 영역의 크기보다 크면 해당 값으로 갱신
 */
public class beakjoon_14502 {
    static int n,m,maxSafe = Integer.MIN_VALUE;
    static int[][] lab;
    static List<int[]> virus;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());

        lab = new int[n][m];
        List<int[]> blank = new ArrayList<>();
        virus = new ArrayList<>();
        for (int i =0;i<n;i++){
            stk = new StringTokenizer(br.readLine());
            for (int j =0;j<m;j++){
                lab[i][j] = Integer.parseInt(stk.nextToken());
                if(lab[i][j]==0){
                    blank.add(new int[]{i,j});
                }
                else if(lab[i][j]==2){
                    virus.add(new int[]{i,j});
                }
            }
        }

        for(int i =0;i<blank.size()-2;i++){
            for(int j = i+1;j<blank.size()-1;j++){
                for(int k =j+1;k<blank.size();k++){
                    int[] a = blank.get(i);
                    int[] b = blank.get(j);
                    int[] c = blank.get(k);

                    lab[a[0]][a[1]]=1;
                    lab[b[0]][b[1]]=1;
                    lab[c[0]][c[1]]=1;
                    bfs();
                    lab[a[0]][a[1]]=0;
                    lab[b[0]][b[1]]=0;
                    lab[c[0]][c[1]]=0;
                }
            }
        }

        bw.write(String.valueOf(maxSafe));
        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs(){
        int[][] copy = new int[lab.length][];
        for (int i = 0; i < lab.length; i++) {
            copy[i] = new int[lab[i].length];
            System.arraycopy(lab[i], 0, copy[i], 0, lab[i].length);
        }

        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][m];
        for(int[] pos:virus){
            q.offer(pos);
            visited[pos[0]][pos[1]]=true;
        }

        int[][] dyx = {{1,0},{0,1},{-1,0},{0,-1}};

        while(!q.isEmpty()){
            int[] curr = q.poll();

            for(int i =0;i<4;i++){
                int newY = curr[0]+dyx[i][0];
                int newX = curr[1]+dyx[i][1];

                if(0<=newY && newY<n && 0<=newX && newX<m){
                    if(!visited[newY][newX] && copy[newY][newX]==0){
                        q.add(new int[]{newY,newX});
                        copy[newY][newX]=2;
                        visited[newY][newX]=true;
                    }
                }
            }
        }

        int cnt=0;
        for(int i =0;i<n;i++){
            for(int j=0;j<m;j++){
                if(copy[i][j]==0)
                    cnt++;
            }
        }
        maxSafe=Math.max(maxSafe,cnt);
    }
}
