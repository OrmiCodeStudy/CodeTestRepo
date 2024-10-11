package y2024.Oct.Oct_11;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
DSLR - 골드4
n : 레지스터에 저장된 십진수

D : (n*2) % 10000
S : n-1 (n==0이면 9999를 저장)
L : n의 각 자릿수를 왼쪽으로 회전해 레지스터에 저장 (2 3 4 1)
R : n의 각 자릿수를 오른쪽으로 회전 (4 1 2 3)

t : 테스트케이스 개수
a : 초기값
b : 최종값

풀이

각각의 명령어의 실행부를 구현 후,
BFS로 최단거리 탐색
 */
public class beakjoon_9019 {

    int D(int n){
        return (2*n)%10000;
    }
    int S(int n){
        return n==0?9999:n-1;
    }
    int L(int n) {
        return (n % 1000) * 10 + n / 1000;
    }

    int R(int n) {
        return (n % 10) * 1000 + n / 10;
    }

    String BFS(int a, int b) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(a);
        boolean[] visited = new boolean[10000];
        visited[a] = true;
        String[] commands = new String[10000];
        commands[a] = "";
        char[] cmd = {'D', 'S', 'L', 'R'};

        while (!q.isEmpty()) {
            int curr = q.poll();

            if (curr == b) {
                return commands[curr];
            }

            int[] next = {D(curr), S(curr), L(curr), R(curr)};

            for (int i = 0; i < 4; i++) {
                int newNum = next[i];
                if (!visited[newNum]) {
                    visited[newNum] = true;
                    q.offer(newNum);
                    commands[newNum] = commands[curr] + cmd[i];
                }
            }
        }
        return "";
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        beakjoon_9019 T = new beakjoon_9019();

        for(int i =0;i<t;i++){
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());

            bw.write(T.BFS(a,b)+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
