package y2024.Sep.Sep_28;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Queue;
import java.util.StringTokenizer;

/*
헌내기는 친구가 필요해 - 실버2

도현이는 상하좌우로만 이동할 수 있다. 이때
캠퍼스에서 도연이가 만날 수 있는 사람의 수를 출력하라
아무도 만날수 없다면 TT를 출력하라

N : 세로
M : 가로

o : 빈공간
x : 벽
I : 도연이
P : 사람
 */
public class beakjoon_21736 {

    static int cnt = 0;

    void solution(String[][] classRoom, boolean[][] isVisited, int x, int y) {

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        if(classRoom[y][x].equals("P"))
            cnt++;

        for (int i = 0; i < dx.length; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];
            if (0 <= newX && newX < classRoom[0].length && 0<=newY && newY< classRoom.length) {
                if (!isVisited[newY][newX] && !classRoom[newY][newX].equals("X")) {
                    isVisited[newY][newX] = true;
                    solution(classRoom,isVisited,newX,newY);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());
        int startX = 0;
        int startY = 0;

        String[][] classRoom = new String[n][m];
        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                classRoom[i][j] = line[j];
                if (line[j].equals("I")) {
                    startX = j;
                    startY = i;
                }
            }
        }

        boolean[][] isVisited = new boolean[n][m];
        beakjoon_21736 T = new beakjoon_21736();
        T.solution(classRoom, isVisited, startX, startY);
        bw.write((cnt == 0 ? "TT" : cnt) + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
