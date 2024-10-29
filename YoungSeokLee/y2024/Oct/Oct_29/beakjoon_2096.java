package y2024.Oct.Oct_29;

import java.io.*;
import java.util.StringTokenizer;

/*
내려가기 골드 5

N줄에 0이상 9이하의 숫자가 세개씩 적혀있다.
아래의 수나 바로 옆의 수로만 넘어갈 수 있다.
숫자표가 주어져 있을때, 얻을 수 있는 최대 점수, 최소 점수를 구하라

dp[a][b][c]를 구한다.
a : 단계
b : 현재 지점
c : 최소 / 최대

chart[a][b]
a : 단계
b : 현재 지점
 */
public class beakjoon_2096 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][][] dp = new int[n][3][2];

        StringTokenizer stk;
        int[][] chart = new int[n][3];
        for(int i =0;i<n;i++){
            stk = new StringTokenizer(br.readLine());
            for(int j =0;j<3;j++){
                chart[i][j]=Integer.parseInt(stk.nextToken());
            }
        }

        int finalMaxVal = Integer.MIN_VALUE;
        int finalMinVal = Integer.MAX_VALUE;
        for(int i = 0; i < 3; i++) {
            dp[0][i][0] = dp[0][i][1] = chart[0][i];
        }

        if(n==1){
            for(int j =0;j<3;j++){
                finalMaxVal = Math.max(finalMaxVal, dp[0][j][1]);
                finalMinVal = Math.min(finalMinVal, dp[0][j][0]);
            }
        }
        for(int i =1;i<n;i++){
            for(int j =0;j<3;j++){
                int curr = chart[i][j];
                int maxVal;
                int minVal;
                if(j==0){
                    maxVal = Math.max(dp[i-1][0][1],dp[i-1][1][1]);
                    minVal = Math.min(dp[i-1][0][0],dp[i-1][1][0]);
                } else if(j==1) {
                    maxVal = Math.max(dp[i-1][2][1],Math.max(dp[i-1][0][1],dp[i-1][1][1]));
                    minVal = Math.min(dp[i-1][2][0],Math.min(dp[i-1][0][0],dp[i-1][1][0]));
                } else {
                    maxVal = Math.max(dp[i-1][2][1],dp[i-1][1][1]);
                    minVal = Math.min(dp[i-1][2][0],dp[i-1][1][0]);
                }

                dp[i][j][0]= curr+minVal;//최솟값
                dp[i][j][1]= curr+maxVal;//최댓값
            }
            if(i==n-1){
                for(int j =0;j<3;j++){
                    finalMaxVal = Math.max(finalMaxVal, dp[i][j][1]);
                    finalMinVal = Math.min(finalMinVal, dp[i][j][0]);
                }
            }
        }
        bw.write(finalMaxVal+" "+finalMinVal);
        bw.flush();
        bw.close();
        br.close();
    }
}
