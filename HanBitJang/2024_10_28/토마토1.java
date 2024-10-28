import java.util.Queue;
import java.util.Scanner;
import java.util.LinkedList;

// 시간초과 개선 풀이

class Point {
    public int x;
    public int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {

    static int m, n, answer, unripeCnt;
    static int[][] box;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static Queue<Point> ripe = new LinkedList<>(); // 익은 열매의 큐
    public void BFS() {
        while (!ripe.isEmpty()) {
            int ripeNum = ripe.size(); // 하루동안 다른 토마토를 익히게 될 익은 토마토의 수
            boolean anyRipened = false;

            for (int k = 0; k < ripeNum; k++) {
                Point tmp = ripe.poll();
                for (int i = 0; i < 4; i++) {
                    int nx = tmp.x + dx[i];
                    int ny = tmp.y + dy[i];
                    if (nx >= 0 && nx <= n - 1
                            && ny >= 0 && ny <= m - 1 && box[nx][ny] == 0) {
                        box[nx][ny] = 1;
                        ripe.offer(new Point(nx, ny));
                        unripeCnt--;
                        anyRipened = true;
                    }
                }
            }
            if (anyRipened) {
                answer++;
            }
        }

        if (unripeCnt > 0) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        m = kb.nextInt();
        n = kb.nextInt();
        box = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                box[i][j] = kb.nextInt();
                if (box[i][j] == 1) {
                    ripe.offer(new Point(i, j));
                } else if (box[i][j] == 0) {
                    unripeCnt++;
                }
            }
        }

        if (unripeCnt == 0) {
            System.out.println(0);
        } else {
            T.BFS();
        }


    }
}