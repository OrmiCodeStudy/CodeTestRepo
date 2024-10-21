package y2024.Oct.Oct_21;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.TreeSet;

/*
N과 M (12) - 실버2

N개의 자연수와 자연수 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.

1.N개의 자연수 중에서 M개를 고른 수열
2. 같은 수를 여러 번 골라도 된다.
3. 고른 수열은 비내림차순이어야 한다.
(길이가 K인 수열 A가 A1 ≤ A2 ≤ ... ≤ AK-1 ≤ AK를 만족하면, 비내림차순이라고 한다.)

어떤 숫자가 있는지만 중요
n개의 자연수를 set으로 저장
DFS set만큼 반복
 */
public class beakjoon_15666 {
    static int[] arr,ans;
    static int n,m;
    static StringBuilder sb = new StringBuilder();
    int prev=0;

    void dfs(int depth) throws IOException {
        if(depth == m){
            for(int num:ans){
                sb.append(num).append(" ");
            }
            sb.append("\n");
            prev=0;
        }
        else {
            for(int i =0;i<arr.length;i++){
                if(prev<=arr[i]){
                    ans[depth]=arr[i];
                    prev=ans[depth];
                    dfs(depth+1);
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stk = new StringTokenizer(br.readLine());

        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());

        stk = new StringTokenizer(br.readLine());

        TreeSet<Integer> s = new TreeSet<>();
        for(int i =0;i<n;i++){
            s.add(Integer.parseInt(stk.nextToken()));
        }
        arr = s.stream().mapToInt(Integer::intValue).toArray();
        ans = new int[m];

        beakjoon_15666 T = new beakjoon_15666();
        T.dfs(0);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
