package y2024.Nov.Nov_14;

import java.io.*;
import java.util.StringTokenizer;

/*
알파벳 - 골드 4

r : 세로
c : 가로

각 칸에는 대문자 알파벳이 적혀있고, 1행 1열에는 말이 놓여있다
말은 상하좌우로 이동할 수 있는데, 지금까지 지나온 모든칸에 적혀있는 알파벳과는 달라야 한다.
말이 최대 몇칸을 갈 수 있는지를 구하라

풀이
DFS
27칸짜리 visited로 방문여부 체크
 */
public class beakjoon_1987 {
    static int maxDist = 0;
    static boolean[] visited = new boolean[27];
    static char[][] board;
    static int[][] dxy = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    private static void dfs(int dist, int r, int c) {
        if (dist > maxDist) {
            maxDist = dist;
        }
        for (int i = 0; i < 4; i++) {
            int newR = r + dxy[i][0];
            int newC = c + dxy[i][1];
            if (0 <= newR && newR < board.length && 0 <= newC && newC < board[0].length) {
                char letter = board[newR][newC];
                if (!visited[letter - 65]) {
                    visited[letter - 65] = true;
                    dfs(dist + 1, newR, newC);
                    visited[letter - 65] = false;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(stk.nextToken());
        int c = Integer.parseInt(stk.nextToken());

        board = new char[r][c];
        for (int i = 0; i < r; i++) {
            board[i] = br.readLine().toCharArray();
        }
        visited[(int)board[0][0]-65]=true;

        dfs(1, 0, 0);

        bw.write(String.valueOf(maxDist));
        bw.flush();
        bw.close();
        br.close();
    }
}
