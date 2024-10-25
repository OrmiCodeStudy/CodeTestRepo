package y2024.Oct.Oct_24;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
스티커 - 실버1

스티커 2 * n개를 구매
뗀 스티커에 인접한 스티커들은 사용할 수 없다.

각 스티커에 점수를 매기고, 점수의 합이 최대가 되게 스티커를 떼어내려고 한다.
뗄 수 있는 스티커의 점수의 최댓값을 구하는 프로그램을 작성하라.

visited 되지 않은 한 지점을 뜯는다
그 스티커와 상하좌우 스티커도 VISITED 처리한다.
 */
public class beakjoon_9465 {

    static int[][] stickers;
    static int n,maxSum;
    static int[] dx,dy;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        dx = new int[]{0,1,0,-1};
        dy = new int[]{1,0,-1,0};

        int t = Integer.parseInt(br.readLine());

        beakjoon_9465 T = new beakjoon_9465();

        for(int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());
            stickers = new int[2][n];
            for(int j = 0; j < 2; j++) {
                stk = new StringTokenizer(br.readLine());
                for(int k = 0; k < n; k++) {
                    stickers[j][k] = Integer.parseInt(stk.nextToken());
                }
            }
            maxSum = 0;

            visited = new boolean[2][n];

            for(int j = 0; j < 2; j++) {
                for(int k = 0; k < n; k++) {
                    T.dfs(2*n,0);
                }
            }

            bw.write(maxSum + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    void dfs(int cnt,int sum){
        if(cnt == 0){
            maxSum = Math.max(maxSum,sum);
            return;
        }

        for(int i =0;i<2;i++){
            for(int j=0;j<n;j++){
                if(!visited[i][j]){
                    visited[i][j] = true;
                    ArrayList<int[]> closeStickers = new ArrayList<>();
                    for(int k =0;k<4;k++){
                        int newX = j+dx[k];
                        int newY = i+dy[k];

                        if(newX >= 0 && newX < n && newY >= 0 && newY < 2){
                            if(!visited[newY][newX]){
                                closeStickers.add(new int[]{newX,newY});
                                visited[newY][newX] = true;
                            }
                        }
                    }
                    dfs(cnt-(closeStickers.size()+1),sum+stickers[i][j]);
                    for(int[] sticker : closeStickers){
                        visited[sticker[1]][sticker[0]] = false;
                    }
                    visited[i][j] = false;
                }
            }
        }
    }



}
