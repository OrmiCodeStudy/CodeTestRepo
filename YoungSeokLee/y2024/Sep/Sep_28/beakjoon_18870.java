package y2024.Sep.Sep_28;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

/*
좌표 압축 - 실버2

수직선 위에 n개의 좌표가 있을때

좌표압축한 결과를 출력하라

좌표압축 : 주어진 좌표들 중 해당 좌표보다 작은 좌표의 개수
같은 좌표가 입력되면 하나의 좌표만 있는것으로 간주한다.


 */
public class beakjoon_18870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] posArray = new int[n];
        StringTokenizer stk = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            int index = Integer.parseInt(stk.nextToken());
            posArray[i] = index;
        }
        int[] sortedArr = posArray.clone();
        Arrays.sort(sortedArr);

        HashMap<Integer, Integer> posMap = new HashMap<>();
        int rank = 0;
        for (int pos : sortedArr) {
            if(!posMap.containsKey(pos)){
                posMap.put(pos,rank++);
            }
        }

        StringBuffer sb = new StringBuffer();
        for (int pos : posArray) {
            sb.append(posMap.get(pos) + " ");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

}
