package y2024.Oct.Oct_23;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class beakjoon_1932_dp {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer stk;
        int[][] triangle = new int[n][n];
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            stk = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                triangle[i][j]=Integer.parseInt(stk.nextToken());
            }
        }

        dp[0][0]=triangle[0][0];
        int maxSum=dp[0][0];

        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j <= i; j++) {
                dp[i+1][j]= Math.max(dp[i+1][j],dp[i][j]+triangle[i+1][j]);
                dp[i+1][j+1]= Math.max(dp[i+1][j+1],dp[i][j]+triangle[i+1][j+1]);
            }
            if(i==n-2){
                for(int j =0;j < n;j++){
                    maxSum = Math.max(maxSum,dp[i+1][j]);
                }
            }
        }

        bw.write(String.valueOf(maxSum));
        bw.flush();
        bw.close();
        br.close();
    }
}
