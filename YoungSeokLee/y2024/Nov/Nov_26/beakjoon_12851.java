package y2024.Nov.Nov_26;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/*
숨바꼭질 2 - 골드 4

N : 수빈이의 위치
K : 동생의 위치

걷기 : 1만큼 앞뒤로 이동 (1초)
순간이동 : 2*x 위치로 이동 (1초)
가장 빠른 시간으로 수빈이가 동생을 찾는 시간과 방법의 수를 출력하라

풀이
DFS로 반복하면서 최소시간보다 많이 진행하는 경우는 return해주고,
최소 경우가 되면 cnt를 1로 초기화
 */

public class beakjoon_12851 {
    static int minTime = 0,cnt=0,k;
    static final int MAX = 100001;

    static void bfs(int n) {
        Queue<Integer> q = new ArrayDeque<>();
        int[] time = new int[MAX];
        int[] ways = new int[MAX];

        q.offer(n);
        time[n] = 0;
        ways[n] = 1;

        while (!q.isEmpty()) {
            int curr = q.poll();

            if (curr == k) {
                minTime = time[curr];
                cnt = ways[curr];
                return;
            }

            for (int next : new int[]{curr - 1, curr + 1, curr * 2}) {
                if (next >= 0 && next < MAX) {
                    if (time[next] == 0) {
                        time[next] = time[curr] + 1;
                        ways[next] = ways[curr];
                        q.offer(next);
                    } else if (time[next] == time[curr] + 1) {
                        ways[next] += ways[curr];
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());
        k = Integer.parseInt(stk.nextToken());

        bfs(n);

        bw.write(String.valueOf(minTime+"\n"+cnt));
        bw.flush();
        bw.close();
        br.close();
    }
}
