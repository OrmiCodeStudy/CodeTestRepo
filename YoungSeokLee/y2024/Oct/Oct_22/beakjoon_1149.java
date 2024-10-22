package y2024.Oct.Oct_22;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
RGB거리 - 실버1

RGB거리에는 집이 N개 있다. 거리는 선분으로 나타낼 수 있고, 1번 집부터 N번 집이 순서대로 있다.

집은 빨강, 초록, 파랑 중 하나의 색으로 칠해야 한다. 각각의 집을 빨강, 초록, 파랑으로 칠하는 비용이 주어졌을 때, 아래 규칙을 만족하면서 모든 집을 칠하는 비용의 최솟값을 구해보자.

인접한 집들은 색이 같지 않아야 한다.

풀이
dp로 각 줄별 최소합을 구한다.
현재 집의 색을 기준으로 최솟값을 구해 배열로 저장
 */
public class beakjoon_1149 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[][] dp = new int[n][3];
        StringTokenizer stk = new StringTokenizer(br.readLine());
        for(int i =0;i<3;i++){
            dp[0][i]= Integer.parseInt(stk.nextToken());
        }


        for(int i =1;i<n;i++){
            stk = new StringTokenizer(br.readLine());
            for(int j =0;j<3;j++){
                dp[i][j]=Integer.parseInt(stk.nextToken());
            }
            dp[i][0]+=Math.min(dp[i-1][1],dp[i-1][2]);
            dp[i][1]+=Math.min(dp[i-1][0],dp[i-1][2]);
            dp[i][2]+=Math.min(dp[i-1][0],dp[i-1][1]);
        }

        int minVal = Integer.MAX_VALUE;
        for(int num:dp[n-1]){
            minVal= Math.min(minVal, num);
        }
        bw.write(String.valueOf(minVal));
        bw.flush();
        bw.close();
        br.close();
    }
}
