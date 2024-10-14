package y2024.Oct.Oct_14;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/*
어제자 버전은 시간초과로 해결 X

BFS로 돌면서 level이 4일때 최댓값을 반환
반환된 값을 누적 최댓값으로 비교
isVisited는 순회할때마다 기준점을 하나씩 추가

ㅗ,ㅜ,ㅓ,ㅏ 는 현재 좌표를 중심으로 좌표를 정해두고 순회하면서 확인하는 식으로 함수 구현
 */
public class beakjoon_14500 {

    int maxSum = Integer.MIN_VALUE;

    void BFS(int[][] paper, int x, int y) {
        int[][] dxy = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}};
        boolean[][] visited = new boolean[paper.length][paper[0].length];

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{x, y, 1, paper[y][x]});
        visited[y][x] = true;

        while (!q.isEmpty()) {
            int[] curr = q.poll();

            if (curr[2] == 4) {
                maxSum = Math.max(maxSum, curr[3]);
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int newX = curr[0] + dxy[i][0];
                int newY = curr[1] + dxy[i][1];
                int newLvl = curr[2] + 1;
                int newSumVal = curr[3];

                if (newX < 0 || newX >= paper[0].length || newY < 0 || newY >= paper.length || visited[newY][newX]) {
                    continue;
                }

                newSumVal += paper[newY][newX];
                q.offer(new int[]{newX, newY, newLvl, newSumVal});
                visited[newY][newX] = true;
            }
        }
    }

    // ㅗ,ㅜ,ㅏ,ㅓ
    void specialCase(int[][] paper, int x, int y) {
        int[][][] pos = {{{0, 1}, {1, 0}, {-1, 0}, {0, 0}}, {{0, -1}, {1, 0}, {-1, 0}, {0, 0}},
                {{1, 0}, {0, 1}, {0, -1}, {0, 0}}, {{-1, 0}, {0, 1}, {0, -1}, {0, 0}}};

        int sumVal = 0;
        int cnt = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int newX = x + pos[i][j][0];
                int newY = y + pos[i][j][1];
                if (newX < 0 || newX >= paper[0].length || newY < 0 || newY >= paper.length) {
                    continue;
                }

                sumVal += paper[newY][newX];
                cnt++;
            }
            if (cnt == 4) {
                maxSum = Math.max(sumVal, maxSum);
            }
            sumVal = 0;
            cnt = 0;
        }
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

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                T.BFS(paper, j, i);
                T.specialCase(paper, j, i);
            }
        }

        bw.write(String.valueOf(T.maxSum));
        bw.flush();
        bw.close();
        br.close();
    }
}
