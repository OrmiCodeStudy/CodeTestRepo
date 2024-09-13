package y2024.Sep.Sep_13;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
/*
1,2,3 더하기

1,2,3으로 n을 나타내는 방법의 수를 출력하는 문제

이것도 dp로 풀 수 있을듯 하다.
 */
public class beakjoon_9095 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        int n;
        int[] dp = new int[12];
        dp[1]=1;
        dp[2]=2;
        dp[3]=4;
        for(int i =4;i<=11;i++){
            dp[i]=dp[i-3]+dp[i-2]+dp[i-1];
        }

        for(int i =0;i<t;i++){
            n = Integer.parseInt(br.readLine());
            bw.write(dp[n]+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
