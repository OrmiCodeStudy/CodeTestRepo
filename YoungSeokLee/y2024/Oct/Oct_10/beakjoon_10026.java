package y2024.Oct.Oct_10;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;

/*
적록색약 - 골드 5

크기가 N*N인 그리드에 rgb중 하나를 칠한 그림이 있다.
적록색약인 사람이 봤을때와 아닌 사람이 봤을때 구역의 수를 구하는 프로그램을 작성하라

rgCnt : R,G을 하나의 구획으로 설정
Cnt : R,G,B를 각각의 구획으로 설정

BFS
 */
public class beakjoon_10026 {

    void BFS(char[][] graph, boolean[][] isVisited, int x, int y) {

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int n = graph.length;
        char baseColor = graph[y][x];

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{x, y});
        isVisited[y][x] = true;

        while (!q.isEmpty()) {
            int[] current = q.poll();

            for (int i = 0; i < 4; i++) {
                int newX = current[0] + dx[i];
                int newY = current[1] + dy[i];

                if (0 <= newX && newX < n && 0 <= newY && newY < n) {
                    if (!isVisited[newY][newX] && baseColor == graph[newY][newX]) {
                        isVisited[newY][newX] = true;
                        q.offer(new int[]{newX, newY});
                    }
                }
            }
        }
    }

    void rgBFS(char[][] graph, boolean[][] isVisited, int x, int y) {

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int n = graph.length;
        char baseColor = graph[y][x];

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{x, y});
        isVisited[y][x] = true;

        while (!q.isEmpty()) {
            int[] current = q.poll();

            for (int i = 0; i < 4; i++) {
                int newX = current[0] + dx[i];
                int newY = current[1] + dy[i];

                if (0 <= newX && newX < n && 0 <= newY && newY < n) {
                    if (!isVisited[newY][newX]) {
                        if((baseColor == 'B' && graph[newY][newX]=='B') || (baseColor!='B' && graph[newY][newX]!='B')) {
                            isVisited[newY][newX] = true;
                            q.offer(new int[]{newX, newY});
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        char[][] graph = new char[n][n];
        boolean[][] isVisited = new boolean[n][n];
        boolean[][] isVisitedRG = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            char[] charArr = line.toCharArray();
            for (int j = 0; j < n; j++) {
                graph[i][j] = charArr[j];
            }
        }

        int cnt=0;
        int rgCnt=0;
        beakjoon_10026 T = new beakjoon_10026();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!isVisited[i][j]) {
                    T.BFS(graph, isVisited, j, i);
                    cnt++;
                }
                if(!isVisitedRG[i][j]){
                    T.rgBFS(graph, isVisitedRG,j,i);
                    rgCnt++;
                }
            }
        }

        bw.write(cnt+" "+rgCnt);
        bw.flush();
        bw.close();
        br.close();
    }
}
