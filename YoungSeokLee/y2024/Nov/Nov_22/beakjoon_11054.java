package y2024.Nov.Nov_22;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
가장 긴 바이토닉 부분 수열 골드 4

수열 a가 주어졌을때, 그 수열의 부분수열 중 가장 긴 바이토닉 수열의 길이를 구하라
 */
public class beakjoon_11054 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        int[] dpIncrease = new int[n];
        int[] dpDecrease = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(stk.nextToken());
        }

        // 증가하는 부분 수열 계산
        for (int i = 0; i < n; i++) {
            dpIncrease[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && dpIncrease[i] < dpIncrease[j] + 1) {
                    dpIncrease[i] = dpIncrease[j] + 1;
                }
            }
        }

        // 감소하는 부분 수열 계산 (역순으로)
        for (int i = n - 1; i >= 0; i--) {
            dpDecrease[i] = 1;
            for (int j = n - 1; j > i; j--) {
                if (arr[i] > arr[j] && dpDecrease[i] < dpDecrease[j] + 1) {
                    dpDecrease[i] = dpDecrease[j] + 1;
                }
            }
        }

        // 최대 바이토닉 수열 길이 계산
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            maxLen = Math.max(maxLen, dpIncrease[i] + dpDecrease[i] - 1);
        }

        bw.write(String.valueOf(maxLen));
        bw.flush();
        bw.close();
        br.close();
    }
}