package y2024.Sep.Sep_11;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
1로 만들기

1. X가 3으로 나누어 떨어지면 3으로 나눈다
2. X가 2로 나누어 떨어지면, 2로 나눈다
3. 1을 뺀다

정수 n이 주어졌을 때, 연산 3개를 적절히 사용해 1로 만들라
연산을 사용하는 횟수의 최솟값을 구하라

동적 프로그래밍
입력값까지 순회하면서
각 단계별 최소 동작을 저장해 호출
 */
public class beakjoon_1463 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        bw.write(dp(n)+"");
        bw.flush();
        bw.close();
        br.close();
    }

    static int dp(int n) {
        int[] dp = new int[n + 1];

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + 1;
            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }
            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }
        }

        return dp[n];
    }
}
