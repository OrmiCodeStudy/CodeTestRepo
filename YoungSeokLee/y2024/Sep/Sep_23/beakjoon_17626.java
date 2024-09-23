package y2024.Sep.Sep_23;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
Four Squares

모든 숫자는 4개 이하의 제곱수의 합으로 표현가능하다

숫자를 주면 그 숫자가 몇개의 제곱수로 이루어질 수 있는지 최솟값을 보여라
 */
public class beakjoon_17626 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int result = solution(n);

        bw.write(result + "");
        bw.flush();
        bw.close();
        br.close();
    }

    static int solution(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = i; // 최악의 경우 i개의 1^2의 합
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }

        return dp[n];
    }
}
