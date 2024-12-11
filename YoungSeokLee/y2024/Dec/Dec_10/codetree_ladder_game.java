package y2024.Dec.Dec_10;

import java.io.*;
import java.util.*;
/*
사다리 타기 (어려움)

n : 사람 수
m : 가로줄의 수

모든 가로줄을 이용했을 때의 결과와 동일하게 되도록 하는 최소 가로줄의 수를 구하라

풀이

양방향 그래프 형태로 줄들을 저장

모든 가로줄을 사용했을 때의 결과를 구한다

*/
public class codetree_ladder_game {

    static int n,m,maxHeight,answer=Integer.MAX_VALUE;
    static ArrayList<ArrayList<int[]>> graph;
    static boolean[] used;

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());

        graph = new ArrayList<>();

        for(int i =0;i<=n;i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0;i<m;i++){
            stk = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(stk.nextToken());
            int height = Integer.parseInt(stk.nextToken());
            maxHeight = Math.max(maxHeight,height);

            graph.get(start).add(new int[]{start+1,height,i});
            graph.get(start+1).add(new int[]{start,height,i});
        }

        used = new boolean[m];
        Arrays.fill(used, true);  // 모든 가로줄을 사용하도록 설정

        int[] target = new int[n+1];
        for(int i =1;i<=n;i++) {
            target[i] = backtracking(i,0);
        }

        Arrays.fill(used, false);  // used 배열 초기화
        findMinimumLines(0, target);

        bw.write(String.valueOf(answer == Integer.MAX_VALUE ? -1 : answer));
        bw.flush();
        bw.close();
        br.close();
    }

    private static void findMinimumLines(int count, int[] target) {
        // 현재 상태로 목표에 도달하는지 확인
        int[] current = new int[n+1];
        for(int i = 1; i <= n; i++) {
            current[i] = backtracking(i, 0);
        }

        if(Arrays.equals(current, target)) {
            answer = Math.min(answer, count);
            return;
        }

        // 가지치기
        if(count >= answer) return;

        // 다음 가로줄 선택
        for(int i = 0; i < m; i++) {
            if(!used[i]) {
                used[i] = true;
                findMinimumLines(count + 1, target);
                used[i] = false;
            }
        }
    }

    private static int backtracking(int currLine, int currHeight) {
        if (currHeight > maxHeight) {
            return currLine;
        }

        for (int[] line : graph.get(currLine)) {
            if (currHeight == line[1] && used[line[2]]) {
                return backtracking(line[0], currHeight + 1);
            }
        }

        return backtracking(currLine, currHeight + 1);
    }
}
