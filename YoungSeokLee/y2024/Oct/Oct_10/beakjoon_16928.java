package y2024.Oct.Oct_10;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/*
뱀과 사다리 게임 -골드5

10*10 게임판이 주어지고, 정6면체 주사위가 있다
각 주사위에 나온 숫자만큼 이동해 1에서 100까지 가는 동안 굴려야하는 주사위 횟수의 최솟값을 구하라

사다리가 있는 칸은 원래 있던 칸의 번호보다 크다
뱀이 있는 칸은 원래 있던 칸의 번호보다 작다

n : 사다리의 수
m : 뱀위 수

x y : x에 도착하면 y로 이동한다

BFS로 최단거리 검색


 */
public class beakjoon_16928 {

    int BFS(int[] board, boolean[] isVisited){

        int level=0;
        int[] dice = {1,2,3,4,5,6};
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{1,level});


        while(!q.isEmpty()){
            int[] current = q.poll();

            if(current[0]==100){
                return current[1];
            }

            for(int i =0;i<6;i++){
                int newIdx = current[0]+dice[i];

                if(newIdx<=100 && !isVisited[newIdx]){
                    int newPos = board[newIdx];
                    q.offer(new int[]{newPos,current[1]+1});
                    isVisited[newPos]=true;
                }
            }
        }

        return -1;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] board = new int[101];
        boolean[] isVisited = new boolean[101];

        for(int i =1;i<=100;i++){
            board[i]=i;
        }

        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());


        for(int i =0;i<n;i++){
            stk = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(stk.nextToken());
            int y = Integer.parseInt(stk.nextToken());

            board[x]=y;
        }

        for(int i =0;i<m;i++){
            stk = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(stk.nextToken());
            int y = Integer.parseInt(stk.nextToken());

            board[x]=y;
        }

        beakjoon_16928 T = new beakjoon_16928();
        bw.write(String.valueOf(T.BFS(board,isVisited)));
        bw.flush();
        bw.close();
        br.close();
    }

}
