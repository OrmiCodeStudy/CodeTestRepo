package y2024.Nov.Nov_21;

import java.io.*;
import java.util.StringTokenizer;

/*
행렬 제곱 - 골드 4

N*N 크기의 행렬 A가 주어진다.
a의 b제곱을 구하라
a^b의 각 원소를 1000으로 나눈 나머지를 출력하라
 */
public class beakjoon_10830 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        long B = Long.parseLong(stk.nextToken());

        int[][] A = new int[N][N];
        for(int i =0;i<N;i++){
            stk = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                A[i][j] = Integer.parseInt(stk.nextToken())%1000;
            }
        }

        int[][] result = matrixPower(A, B, N);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(result[i][j] + " ");
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static int[][] matrixMultiply(int[][] A, int[][] B, int N) {
        int[][] result = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    result[i][j] += A[i][k] * B[k][j];
                    result[i][j] %= 1000;
                }
            }
        }
        return result;
    }

    private static int[][] matrixPower(int[][] A, long B, int N) {
        if (B == 1) {
            return A;
        }

        int[][] halfPower = matrixPower(A, B / 2, N);
        halfPower = matrixMultiply(halfPower, halfPower, N);

        if (B % 2 != 0) {
            halfPower = matrixMultiply(halfPower, A, N);
        }

        return halfPower;
    }
}
