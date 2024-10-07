package y2024.Oct.Oct_02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

/*
미로 탐색 - 실버1

1 : 이동할 수 있는 칸
0 : 이동할수 없는 칸

1,1에서 출발해 N,M의 위치로 이동할 때 지나야하는 최소의 칸 수를 구하라
칸을 셀때에는 시작 위치와 도착위치도 포함해야 한다.

BFS
 */
class position {
    int x;
    int y;
    int distance;

    position(int x, int y, int distance) {
        this.x = x;
        this.y = y;
        this.distance = distance;
    }
}

public class beakjoon_2178 {

    int BFS(int[][] miro, boolean[][] isVisited, int targetX, int targetY) {

        Queue<position> q = new ArrayDeque<>();

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, -1, 0, 1};

        q.add(new position(0, 0, 1));
        isVisited[0][0] = true;

        while (!q.isEmpty()) {
            position current = q.poll();
            if (current.x == targetX - 1 && current.y == targetY - 1) {
                return current.distance;
            }

            for (int i = 0; i < 4; i++) {
                int newX = current.x + dx[i];
                int newY = current.y + dy[i];

                if (0 <= newX && newX < targetX && 0 <= newY && newY < targetY) {
                    if (!isVisited[newY][newX] && miro[newY][newX] == 1) {
                        q.add(new position(newX, newY, current.distance + 1));
                        isVisited[newY][newX] = true;
                    }
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        int[][] miro = new int[n][m];
        boolean[][] isVisited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            int[] line = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < m; j++) {
                miro[i][j] = line[j];
            }
        }

        beakjoon_2178 T = new beakjoon_2178();
        bw.write(String.valueOf(T.BFS(miro, isVisited, m, n)));
        bw.flush();
        bw.close();
        br.close();
    }
}
