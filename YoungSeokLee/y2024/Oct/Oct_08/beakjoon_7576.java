package y2024.Oct.Oct_08;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
토마토 - 골드5

격자모양 상자의 칸에 하나씩 넣은 다음 상자를 수직으로 쌓아 창고에 보관
보관한지 하루가 지나면 익은 토마토들의 인접한 곳에 있는 익지 않은 토마토들은 익은 토마토의 영향을 받아 익게 된다
창고에 보관된 토마토들이 며칠이 지나면 다 익게되는지 최소 일수를 구하라

1 : 익은 토마토
0 : 익지 않은 토마토
-1 : 토마토가 들어있지 않은 칸

토마토가 모두 익은 상태이면 0
토마토가 모두 익을 수 없다면 -1 을 출력하라

BFS
X,Y 방향으로 이동가능
M,N를 제한으로 둔다

시작점을 어디로 잡아야 하는가?
처음에 1인 토마토의 위치를 q에 전부 넣으면 된다.
 */
public class beakjoon_7576 {
    int BFS(ArrayList<ArrayList<Integer>> graph, boolean[][] isVisted, ArrayList<int[]> startPoints, int x, int y) {

        int maxLevel = 0;
        Queue<int[]> q = new ArrayDeque<>();
        for (int[] point : startPoints) {
            q.offer(point);
        }

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        while (!q.isEmpty()) {
            int[] current = q.poll();

            for (int i = 0; i < 4; i++) {
                int newX = current[1] + dx[i];
                int newY = current[0] + dy[i];

                if (0 <= newX && newX < x && 0 <= newY && newY < y) {
                    if (!isVisted[newY][newX] && graph.get(newY).get(newX) == 0) {
                        int newLevel = current[2] + 1;
                        q.offer(new int[]{newY, newX, newLevel});
                        isVisted[newY][newX] = true;
                        graph.get(newY).set(newX, 1);
                        maxLevel = Math.max(maxLevel, newLevel);
                    }
                }
            }
        }

        return maxLevel;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stk = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(stk.nextToken());
        int y = Integer.parseInt(stk.nextToken());

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        boolean[][] isVisted = new boolean[y][x];
        ArrayList<int[]> startPoints = new ArrayList<>();

        for (int j = 0; j < y; j++) {
            graph.add(new ArrayList<Integer>());
            stk = new StringTokenizer(br.readLine());
            for (int k = 0; k < x; k++) {
                int tomato = Integer.parseInt(stk.nextToken());
                graph.get(j).add(tomato);
                if (tomato == 1) {
                    startPoints.add(new int[]{j, k, 0});
                    isVisted[j][k] = true;
                }
            }
        }

        beakjoon_7576 T = new beakjoon_7576();
        int result = T.BFS(graph, isVisted, startPoints, x, y);

        boolean allRipe = true;
        for (int j = 0; j < y && allRipe; j++) {
            for (int k = 0; k < x && allRipe; k++) {
                if (graph.get(j).get(k) == 0) {
                    allRipe = false;
                }
            }
        }

        if (!allRipe) {
            bw.write("-1");
        } else if (result == 0) {
            bw.write("0");
        } else {
            bw.write(String.valueOf(result));
        }
        bw.flush();
        bw.close();
        br.close();
    }
}