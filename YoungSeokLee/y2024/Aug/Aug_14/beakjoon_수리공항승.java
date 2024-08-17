package y2024.Aug.Aug_14;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
구멍으로부터 좌우로 0.5의 테이프가 있어야 한다
입력값을 오름차순 정렬하고,

다음 지점과 start 간의 거리 +1 이 l보다 길면 tapeCnt++ 하고 start, end를 다음 지점으로 이동

같으면 tapeCnt++ 하고 start, end를 다음 지점으로 이동


*/

public class beakjoon_수리공항승 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken()), l = Integer.parseInt(stk.nextToken());

        stk = new StringTokenizer(br.readLine());
        int[] holePos = new int[n];

        for(int i =0;i<n;i++){
            holePos[i] = Integer.parseInt(stk.nextToken());
        }
        Arrays.sort(holePos);


        // 필요한 테이프 개수 계산
        int tapeCnt = 0;
        double lastCovered = 0; // 마지막으로 덮은 지점

        for (int i = 0; i < n; i++) {
            if (holePos[i] + 0.5 > lastCovered) {
                tapeCnt++;
                lastCovered = holePos[i] - 0.5 + l;
            }
        }

        bw.write(String.valueOf(tapeCnt));

        bw.flush();
        bw.close();
        br.close();
    }
}
