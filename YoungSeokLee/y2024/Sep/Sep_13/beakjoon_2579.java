package y2024.Sep.Sep_13;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
/*
계단 오르기
1. 계단은 한 번에 한 계단씩 또는 두 계단씩 오를 수 있다. 즉, 한 계단을 밟으면서 이어서 다음 계단이나, 다음 다음 계단으로 오를 수 있다.
2. 연속된 세 개의 계단을 모두 밟아서는 안 된다. 단, 시작점은 계단에 포함되지 않는다.
3. 마지막 도착 계단은 반드시 밟아야 한다.

총 점수의 최대값을 구하라

DP로 다시 풀기
 */
public class beakjoon_2579 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] stairs = new int[n+1];
        for(int i=1;i<=n;i++){
            stairs[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[n+1];

        dp[1] = stairs[1];
        if (n >= 2) dp[2] = stairs[1] + stairs[2];

        for(int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i-2] + stairs[i], dp[i-3] + stairs[i-1] + stairs[i]);
        }

        bw.write(dp[n]+"");
        bw.flush();
        bw.close();
        br.close();
    }
}
