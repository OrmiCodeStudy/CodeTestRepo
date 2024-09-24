package y2024.Sep.Sep_24;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
유기농 배추 - 실버 2

T : 테스트케이스의 수
M : 배추밭의 가로길이
N : 배추밭의 세로길이
K : 배추가 심어져 있는 위치의 개수
X,Y : 배추의 위치

각 테스트 케이스에 대해 필요한 최소의 지렁이 마리수를 출력하라
연결되어있는 배추가 있다면 한마리의 지렁이로 그 군집을 다 보호할 수 있다.

풀이

0,0 부터 한점씩 이동하면서 1이면 BFS를 시도
visited가 false인 주변 배추 중 연결된 다른 배추가 없다면 cnt++;
 */
public class beakjoon_1012 {

    void BFS(int[][] bechuField, int x, int y,boolean[][] visited) {

        if(x<visited[0].length-1 && !visited[y][x+1] && bechuField[y][x+1]==1){
            visited[y][x+1]=true;
            BFS(bechuField,x+1,y,visited);
        }
        if(x>0 && !visited[y][x-1] && bechuField[y][x-1]==1){
            visited[y][x-1]=true;
            BFS(bechuField,x-1,y,visited);
        }
        if(y<visited.length-1 && !visited[y+1][x] && bechuField[y+1][x]==1){
            visited[y+1][x]=true;
            BFS(bechuField,x,y+1,visited);
        }
        if(y>0 && !visited[y-1][x] && bechuField[y-1][x]==1){
            visited[y-1][x]=true;
            BFS(bechuField,x,y-1,visited);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        for(int i =0;i<t;i++){
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(stk.nextToken());
            int n = Integer.parseInt(stk.nextToken());
            int k = Integer.parseInt(stk.nextToken());

            int[][] bechuField = new int[n][m];

            for(int j =0;j<k;j++){
                stk = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(stk.nextToken());
                int y = Integer.parseInt(stk.nextToken());

                bechuField[y][x] = 1;
            }

            boolean[][] visited = new boolean[n][m];
            beakjoon_1012 T = new beakjoon_1012();
            int wormCnt = 0;

            for(int j=0;j<n;j++){
                for(int l=0;l<m;l++){
                    if(visited[j][l]){
                        continue;
                    }
                    visited[j][l]=true;
                    if(bechuField[j][l]==1){
                        T.BFS(bechuField,l,j,visited);
                        wormCnt++;
                    }
                }
            }

            bw.write(wormCnt+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
