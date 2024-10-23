package y2024.Oct.Oct_23;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

/*
정수 삼각형 실버1

위 그림은 크기가 5인 정수 삼각형의 한 모습이다.

맨 위층 7부터 시작해서 아래에 있는 수 중 하나를 선택하여 아래층으로 내려올 때, 이제까지 선택된 수의 합이 최대가 되는 경로를 구하는 프로그램을 작성하라. 아래층에 있는 수는 현재 층에서 선택된 수의 대각선 왼쪽 또는 대각선 오른쪽에 있는 것 중에서만 선택할 수 있다.

삼각형의 크기는 1 이상 500 이하이다. 삼각형을 이루고 있는 각 수는 모두 정수이며, 범위는 0 이상 9999 이하이다.

풀이
단방향 그래프를 만든 뒤, DFS 수행
DFS 결과중 최댓값을 비교
 */
public class beakjoon_1932 {

    static int n, maxSum;
    static ArrayList<ArrayList<Integer>> graph;

    void DFS(int x, int y) {

        Stack<int[]> s = new Stack<>();
        s.add(new int[]{x, y, 1, graph.get(y).get(x)});

        while (!s.isEmpty()) {
            int[] curr = s.pop();

            if (curr[2] == n) {
                maxSum = Math.max(maxSum, curr[3]);
                continue;
            }

            for (int i = 1; i >= 0; i--) {
                int newX = curr[0] + i;
                int newY = curr[1] + 1;

                int newSum = curr[3] + graph.get(newY).get(newX);
                s.add(new int[]{newX, newY, curr[2] + 1, newSum});

            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        StringTokenizer stk;
        graph = new ArrayList<ArrayList<Integer>>();
        for (int i = 1; i <= n; i++) {
            stk = new StringTokenizer(br.readLine());
            graph.add(new ArrayList<Integer>());
            ArrayList<Integer> line = graph.get(i - 1);
            for (int j = 0; j < i; j++) {
                line.add(Integer.parseInt(stk.nextToken()));
            }
        }

        maxSum = 0;

        beakjoon_1932 T = new beakjoon_1932();
        T.DFS(0, 0);
        bw.write(String.valueOf(maxSum));
        bw.flush();
        bw.close();
        br.close();
    }
}
