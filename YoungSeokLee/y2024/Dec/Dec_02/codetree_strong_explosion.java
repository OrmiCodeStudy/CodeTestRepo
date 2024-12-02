package y2024.Dec.Dec_02;

import java.io.*;
import java.util.*;

public class codetree_strong_explosion {
    /*
    초토화 시킬 수 있는 영역의 최대치를 구하라
    */

    static int n, maxArea = 0;
    static ArrayList<int[]> bombPos;
    static int[][] dxy = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];
        StringTokenizer stk;
        bombPos = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            stk = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(stk.nextToken());
                if (map[i][j] == 1) {
                    bombPos.add(new int[]{i, j});
                }
            }
        }

        backtrack(0, new int[bombPos.size()]);

        bw.write(String.valueOf(maxArea));
        bw.flush();
        bw.close();
        br.close();
    }

    private static void backtrack(int index, int[] bombType) {
        if (index == bombType.length) {
            maxArea = Math.max(maxArea, explosion(bombType));
            return;
        }

        for (int i = 0; i < 3; i++) {
            bombType[index] = i;
            backtrack(index + 1, bombType);
        }
    }

    private static int explosion(int[] bombType) {
        boolean[][] exploded = new boolean[n][n];
        for (int i = 0; i < bombPos.size(); i++) {
            int[] pos = bombPos.get(i);
            if (bombType[i] == 0) {
                for (int j = -2; j <= 2; j++) {
                    int newY = pos[0] + j;
                    if (0 <= newY && newY < n) {
                        exploded[newY][pos[1]] = true;
                    }
                }
            } else if (bombType[i] == 1) {
                exploded[pos[0]][pos[1]]=true;
                for (int j = 0; j < 8; j += 2) {
                    int newY = pos[0] + dxy[j][0];
                    int newX = pos[1] + dxy[j][1];

                    if (0 <= newX && newX < n && 0 <= newY && newY < n) {
                        if (exploded[newY][newX] == false) {
                            exploded[newY][newX] = true;
                        }
                    }
                }
            } else {
                exploded[pos[0]][pos[1]]=true;
                for (int j = 1; j < 8; j += 2) {
                    int newY = pos[0] + dxy[j][0];
                    int newX = pos[1] + dxy[j][1];

                    if (0 <= newX && newX < n && 0 <= newY && newY < n) {
                        if (exploded[newY][newX] == false) {
                            exploded[newY][newX] = true;
                        }
                    }
                }
            }
        }

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (exploded[i][j] == true) {
                    cnt++;
                }
            }
        }

        return cnt;
    }
}
