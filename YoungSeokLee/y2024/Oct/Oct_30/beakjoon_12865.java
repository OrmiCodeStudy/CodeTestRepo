package y2024.Oct.Oct_30;

import java.io.*;
import java.util.StringTokenizer;

/*
평범한 배낭 - 골드 5

n : 여행에 필요한 물건의 갯수
w : 물건의 무게
v : 물건의 가치
k : 최대 물건의 무게

배낭에 넣을 수 있는 물건들의 가치의 최댓값을 구하라

풀이
 */
public class beakjoon_12865 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] W = new int[N + 1]; // 무게
        int[] V = new int[N + 1]; // 가치
        int[][] dp = new int[N + 1][K + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            W[i] = Integer.parseInt(st.nextToken());
            V[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            for (int w = 1; w <= K; w++) {
                if (W[i] > w) {
                    dp[i][w] = dp[i - 1][w];
                } else {
                    dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - W[i]] + V[i]);
                }
            }
        }

        bw.write(String.valueOf(dp[N][K]));
        bw.flush();
        bw.close();
        br.close();
    }
}
