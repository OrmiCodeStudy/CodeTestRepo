package y2024.Oct.Oct_17;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;
import java.util.StringTokenizer;

/*
N과 M(9) - 실버2

조건
- N개의 자연수 중에서 M개를 고른 수열
 */
class combi {
    int idx;
    int len;
    String combi;
    boolean[] visited;

    combi(int idx, int len, String combi, boolean[] visited) {
        this.idx = idx;
        this.len = len;
        this.combi = combi;
        this.visited = visited;
    }
}

public class beakjoon_15663 {

    HashMap<String,Integer> map = new HashMap<>();
    String DFS(int[] arr, int startIdx, int n, int m) {

        StringBuilder sb = new StringBuilder();
        boolean[] visited = new boolean[n];
        visited[startIdx] = true;

        Stack<combi> s = new Stack<>();
        s.add(new combi(startIdx, 1, String.valueOf(arr[startIdx]), visited));

        while (!s.isEmpty()) {
            combi curr = s.pop();

            if (curr.len == m) {
                if(!map.containsKey(curr.combi)){
                    map.put(curr.combi,1);
                    sb.append(curr.combi).append("\n");
                }
                continue;
            }

            if (curr.len < m) {
                for (int i = n - 1; i >= 0; i--) {
                    if (!curr.visited[i]) {
                        String newCombi = curr.combi + " " + arr[i];
                        boolean[] newVisited = curr.visited.clone();
                        newVisited[i] = true;
                        s.push(new combi(i, curr.len + 1, newCombi, newVisited));
                    }
                }
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        int[] arr = new int[n];

        stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(stk.nextToken());
        }

        Arrays.sort(arr);

        beakjoon_15663 T = new beakjoon_15663();
        for (int i = 0; i < n; i++) {
            bw.write(T.DFS(arr, i, n, m));
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
