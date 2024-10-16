package y2024.Oct.Oct_16;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
가장 긴 증가하는 부분 수열 - 실버2

수열 A가 주어졌을때, 가장 긴 증가하는 부분수열을 구하라

 */
public class beakjoon_11053 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n];
        int[] arr = new int[n];
        int maxLen=0;

        StringTokenizer stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(stk.nextToken());
        }

        for(int i =0;i<n;i++){
            dp[i]=1;
            for(int j =0;j<i;j++){
                if(arr[i]>arr[j] && dp[i]<dp[j]+1){
                    dp[i] = dp[j]+1;
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        bw.write(String.valueOf(maxLen));
        bw.flush();
        bw.close();
        br.close();
    }
}
