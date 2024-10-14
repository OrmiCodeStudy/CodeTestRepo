package y2024.Oct.Oct_13;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
테트로미노 - 골드 4

정사각형 4개를 이어붙인 도형

N X M 크기의 종이에 테트로미노 하나를 놓을때, 테트로미노가 놓인 칸의 숫자의 합이 가장 큰 경우를 출력하라.

BFS (level이 4일때 합을 반환)
level이 5이면 q에 넣지 않는다.

ㅗ,ㅜ,ㅏ,ㅓ 이 형태의 확인 추가
상하좌우 3칸 거리에 타일이 있는가?
2번째 칸의 양옆에 칸이 존재하는가
있다면 합이 최댓값을 넘는지 확인
 */

public class beakjoon_14500 {
    int n, m;
    int[][] paper;
    int maxSum = 0;
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};

    void dfs(int x, int y, boolean[][] visited, int sum, int count) {
        if (count == 4) {
            maxSum = Math.max(maxSum, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= m || ny < 0 || ny >= n || visited[ny][nx]) {
                continue;
            }

            visited[ny][nx] = true;
            dfs(nx, ny, visited, sum + paper[ny][nx], count + 1);
            visited[ny][nx] = false;
        }
    }

    public int solution() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                boolean[][] visited = new boolean[n][m];
                visited[i][j] = true;
                dfs(j, i, visited, paper[i][j], 1);
                maxSum = Math.max(maxSum, checkSpecialShape(j, i));
            }
        }
        return maxSum;
    }

    int checkSpecialShape(int x, int y) {
        int[][][] specialShapes = {
                {{0, 0}, {0, 1}, {0, 2}, {-1, 1}},  // ㅗ
                {{0, 0}, {0, 1}, {0, 2}, {1, 1}},   // ㅜ
                {{0, 0}, {1, 0}, {2, 0}, {1, 1}},   // ㅏ
                {{0, 0}, {1, 0}, {2, 0}, {1, -1}}   // ㅓ
        };

        int maxSum = 0;
        for (int[][] shape : specialShapes) {
            int sum = 0;
            boolean possible = true;
            for (int[] delta : shape) {
                int newX = x + delta[0];
                int newY = y + delta[1];
                if (newX < 0 || newX >= m || newY < 0 || newY >= n) {
                    possible = false;
                    break;
                }
                sum += paper[newY][newX];
            }
            if (possible) {
                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        int[][] paper = new int[n][m];
        for (int i = 0; i < n; i++) {
            stk = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                paper[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        beakjoon_14500 T = new beakjoon_14500();
        T.n = n;
        T.m = m;
        T.paper = paper;

        int result = T.solution();

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }
}
