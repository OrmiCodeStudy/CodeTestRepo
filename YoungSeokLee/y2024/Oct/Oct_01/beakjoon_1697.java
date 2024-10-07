package y2024.Oct.Oct_01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/*
숨바꼭질 - 실버1

수빈이는 걷거나 순간이동을 할 수 있다

수빈이의 위치가 X일때
걷기 : 1초후에 X-1 또는 X+1로 이동
순간이동 : 1초 후에 2*X로 이동

수빈이의 위치가 주어졌을때, 수빈이가 동생을 찾을 수 있는 가장 빠른 시간이 몇 초 후인지를 구하는 프로그램을 작성하라.

BFS
 */
public class beakjoon_1697 {

    int BFS(int sPos, int dPos){

        Queue<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[100001];

        q.add(sPos);
        visited[sPos]=true;
        int level = 0;

        while(!q.isEmpty()){
            int size = q.size();

            for(int i =0;i<size;i++){
                int current = q.poll();

                if(current==dPos){
                    return level;
                }

                int[] nextPos = {current-1,current+1,current*2};
                for(int next:nextPos){
                    if(next>=0&& next<=100000 && !visited[next]){
                        q.add(next);
                        visited[next] = true;
                    }
                }
            }
            level++;
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int k = Integer.parseInt(stk.nextToken());

        beakjoon_1697 T = new beakjoon_1697();
        bw.write(String.valueOf(T.BFS(n,k)));
        bw.flush();
        bw.close();
        br.close();
    }
}
