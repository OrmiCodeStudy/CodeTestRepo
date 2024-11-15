package y2024.Nov.Nov_15;

import java.io.*;
import java.util.Arrays;
/*
별 찍기-11 / 골드 4

n : 3x2^k 수 (0<=k<=10)
규칙 : 정삼각형의 가운데를 비운 형식으로 삼각형을 출력하라
 */


public class beakjoon_2448 {
    static char[][] star;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        star = new char[N][2 * N - 1];
        for (int i = 0; i < N; i++) {
            Arrays.fill(star[i], ' ');
        }

        drawStar(0, N - 1, N);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(star[i]).append('\n');
        }
        System.out.print(sb);
    }

    static void drawStar(int x, int y, int N) {
        if (N == 3) {
            star[x][y] = '*';
            star[x + 1][y - 1] = star[x + 1][y + 1] = '*';
            star[x + 2][y - 2] = star[x + 2][y - 1] = star[x + 2][y] = star[x + 2][y + 1] = star[x + 2][y + 2] = '*';
            return;
        }

        int size = N / 2;
        drawStar(x, y, size);
        drawStar(x + size, y - size, size);
        drawStar(x + size, y + size, size);
    }
}
