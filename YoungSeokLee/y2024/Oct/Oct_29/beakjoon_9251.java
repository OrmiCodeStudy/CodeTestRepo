package y2024.Oct.Oct_29;

import java.io.*;

/*
LCS 골드 5

두 수열이 주어졌을때, 모두의 부분 수열이 되는 수열 중 가장 긴 것을 찾는것
ACAYKP와 CAPCAK의 LCS는 ACAK

풀이

LCS 점화식
c[i][j] = {
    0                           (i = 0 또는 j = 0일 때)
    c[i-1][j-1] + 1             (i, j > 0이고 xi = yj일 때)
    max(c[i-1][j], c[i][j-1])   (i, j > 0이고 xi ≠ yj일 때)
}
 */
public class beakjoon_9251 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str1 = br.readLine();
        String str2 = br.readLine();

        int[][] dp = new int[str1.length() + 1][str2.length() + 1];

        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        bw.write(String.valueOf(dp[str1.length()][str2.length()]));
        bw.flush();
        bw.close();
        br.close();
    }
}