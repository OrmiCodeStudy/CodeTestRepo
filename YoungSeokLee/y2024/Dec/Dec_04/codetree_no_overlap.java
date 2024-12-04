package y2024.Dec.Dec_04;

import java.io.*;
import java.util.*;

public class codetree_no_overlap {
    /*
    겹치지 않게 선분 고르기 (보통)

    수직선상에 n개의 선분이 주어졌을때, 겹치지 않게 가장 많은 수의 선분을 고르는 프로그램을 작성하라

    풀이
    시작점을 기준으로 오름차순 정렬
    만약 시작점이 같다면 도착지점을 기준으로 오름차순 정렬
    이전 선분의 도착지점보다 큰 시작지점을 가지는 선분을 고르면 된다.
    */
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] lines = new int[n][2];

        StringTokenizer stk;

        for (int i = 0; i < n; i++) {
            stk = new StringTokenizer(br.readLine());

            lines[i][0] = Integer.parseInt(stk.nextToken());
            lines[i][1] = Integer.parseInt(stk.nextToken());
        }

        Arrays.sort(lines, (o1, o2) -> {
            if (o1[1] != o2[1]) {
                return Integer.compare(o1[1], o2[1]);
            } else {
                return Integer.compare(o1[0], o2[0]);
            }

        });

        int prevEnd = 0;
        int cnt = 0;
        for (int[] line : lines) {
            if (line[0] > prevEnd) {
                prevEnd = line[1];
                cnt++;
            }
        }

        bw.write(String.valueOf(cnt));
        bw.flush();
        bw.close();
        br.close();
    }
}
