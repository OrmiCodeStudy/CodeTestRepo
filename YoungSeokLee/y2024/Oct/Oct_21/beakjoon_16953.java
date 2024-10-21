package y2024.Oct.Oct_21;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

/*
A → B 실버2

정수 A를 B로 바꾸려고 한다. 가능한 연산은 다음과 같은 두 가지이다.

1. 2를 곱한다.
2. 1을 수의 가장 오른쪽에 추가한다.
A를 B로 바꾸는데 필요한 연산의 최솟값을 구해보자.

풀이
BFS로 계산
계산한 숫자가 b보다 커지면 -1을 반환
 */
public class beakjoon_16953 {
    long bfs(long a,long b){
        Set<Long> visited = new HashSet<>();
        Queue<long[]> q = new ArrayDeque<>();
        q.offer(new long[]{a,1});
        visited.add(a);

        while (!q.isEmpty()) {
            long[] curr = q.poll();
            if(curr[0]==b){
                return curr[1];
            }

            long[] newVals = {curr[0]*2,curr[0]*10+1};
            for(long val: newVals){
                if(val<=b && !visited.contains(val)) {
                    visited.add(val);
                    q.add(new long[]{val, curr[1] + 1});
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stk = new StringTokenizer(br.readLine());

        long a = Long.parseLong(stk.nextToken());
        long b = Long.parseLong(stk.nextToken());

        beakjoon_16953 T = new beakjoon_16953();
        bw.write(String.valueOf(T.bfs(a,b)));
        bw.flush();
        bw.close();
        br.close();
    }
}
