package y2024.Sep.Sep_20;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
/*
2xn 타일링

2xn 크기의 직사각형을 1x2, 2x1 타일로 채우는 방법의 수를 구하라

n (1<=n<=1000)
방법의 수를 10007로 나눈 나머지를 출력하라
 */
public class beakjoon_11726 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] dp = new int[1001];

        int n = Integer.parseInt(br.readLine());

        dp[1] = 1;
        dp[2] = 2;
        for(int i =3;i<=n;i++){
            dp[i] = (dp[i-2]+dp[i-1])%10007;
        }

        bw.write(dp[n]+"");
        bw.flush();
        bw.close();
        br.close();
    }
}
