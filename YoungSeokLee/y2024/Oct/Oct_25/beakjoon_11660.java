package y2024.Oct.Oct_25;

import java.io.*;
import java.util.StringTokenizer;

/*
구간 합 구하기 5 - 실버1

N X N개의 수가 표에 채워져 있다. X1,Y1 부터 X2,Y2 까지의 합을 구하라

0,0을 기준으로 특정 지점 까지의 합을 구해서 sum[][] 에 저장,
기준점의 sum[][]의 차를 구해서 출력

x가 세로
y가 가로
 */
public class beakjoon_11660 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        int[][] chart = new int[n][n];
        int[][] target = new int[m][4];
        int[][] sumVal = new int[n][n];

        int prev = 0;
        for(int i = 0; i < n; i++){
            stk = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                chart[i][j] = Integer.parseInt(stk.nextToken());
                sumVal[i][j] = prev+chart[i][j];
                prev=sumVal[i][j];
            }
        }

        for(int i = 0; i < m; i++) {
            stk = new StringTokenizer(br.readLine());
            for(int j = 0; j < 4; j++) {
                target[i][j] = Integer.parseInt(stk.nextToken())-1;
            }
        }


        for(int[] arr:target){
            int answer = 0;
            for(int i =arr[0];i<=arr[2];i++){
                answer += (sumVal[i][arr[3]]-sumVal[i][arr[1]]+chart[i][arr[1]]);
            }
            bw.write(String.valueOf(answer));
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
