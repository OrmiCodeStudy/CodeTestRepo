package y2024.Sep.Sep_30;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

/*
케빈 베이컨의 6단계 원칙 - 실버 1

지구에 있는 모든 사람들은 최대 6단계 이내에서 서로 아는 사람으로 연결된다
임의의 두 사람이 최소 몇단계만에 이어질 수 있는지 계산해 구한다.

케빈 베이컨수 : 모든 사람과 베이컨 게임을 했을때 나오는 수

케빈 베이컨 수가 가장 작은 사람을 구하라

그래프 탐색을 통해 계산 가능하다

n : 유저의 수
m : 친구 관계의 수

 */
public class beakjoon_1389 {

    int BFS(ArrayList<ArrayList<Integer>> graph, int start, int n) {

        int[] distance = new int[n + 1];
        Queue<Integer> visitQueue = new ArrayDeque<>();

        visitQueue.add(start);

        while (!visitQueue.isEmpty()) {
            int current = visitQueue.poll();

            for (int person : graph.get(current)) {
                if (distance[person] == 0) {
                    distance[person] = distance[current] + 1;
                    visitQueue.add(person);
                }
            }
        }

        int sum = 0;
        for(int i =1;i<=n;i++){
            if(i!=start)
                sum+=distance[i];
        }

        return sum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < m; i++) {
            stk = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(stk.nextToken());
            int end = Integer.parseInt(stk.nextToken());

            graph.get(start).add(end);
            graph.get(end).add(start);
        }

        beakjoon_1389 T = new beakjoon_1389();

        int minBaconNum = Integer.MAX_VALUE;
        int answer = 0;

        for (int i = 1; i <= n; i++) {
            int newBaconNum = T.BFS(graph, i, n);
            if (newBaconNum < minBaconNum) {
                minBaconNum = newBaconNum;
                answer = i;
            }
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
        br.close();
    }
}
