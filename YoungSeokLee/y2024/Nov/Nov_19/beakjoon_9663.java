package y2024.Nov.Nov_19;

import java.io.*;

/*
N-QUEEN 골드 4

NXN 인 체스판 위에 퀸 N개를 서로 공격할 수 없게 놓는 문제

N이 주어졌을 때, 퀸을 놓는 방법의 수를 구하는 프로그램을 작성하라

풀이

한 열과 한 행에 하나의 퀸만 놓을 수 있다
DFS로 n개가 놓아지면 cnt++
cnt를 출력
 */
public class beakjoon_9663 {
    static int caseCnt=0,n;
    static int[] cols;

    private static void dfs(int row){
        if(row==n){
            caseCnt++;
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isValid(row, col)) {
                cols[row] = col;
                dfs(row + 1);
            }
        }
    }

    private static boolean isValid(int row, int col) {
        for (int i = 0; i < row; i++) {
            if (cols[i] == col || Math.abs(cols[i] - col) == row - i) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        cols = new int[n];

        dfs(0);

        bw.write(String.valueOf(caseCnt));
        bw.flush();
        bw.close();
        br.close();
    }
}
