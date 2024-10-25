package y2024.Oct.Oct_25;

import java.io.*;
import java.util.StringTokenizer;

public class beakjoon_9465 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stk;

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());

            int[][] arr = new int[2][n+1];
            int[][] dp = new int[2][n+1];

            for(int j = 0; j < 2; j++) {
                stk = new StringTokenizer(br.readLine());
                for(int k =1;k<=n;k++){
                    arr[j][k] = Integer.parseInt(stk.nextToken());
                }
            }

            dp[0][1] = arr[0][1];
            dp[1][1] = arr[1][1];

            for(int j=2;j<=n;j++){
                dp[0][j] = Math.max(dp[1][j-2],dp[1][j-1]) + arr[0][j];
                dp[1][j] = Math.max(dp[0][j-2],dp[0][j-1]) + arr[1][j];
            }

            int result = Math.max(dp[0][n],dp[1][n]);
            bw.write(result + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
