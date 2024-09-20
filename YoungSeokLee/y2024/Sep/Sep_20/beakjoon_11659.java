package y2024.Sep.Sep_20;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
구간 합 구하기4

수 N 개가 주어졌을때
i에서 j번째 수까지 합을 구하라

N : 수의 개수
M : 합을 구해야 하는 횟수

N개의 수

M개의 구간
 */
public class beakjoon_11659 {

    static int[] nArray = new int[100001];
    static Integer solution(int i, int j){
        return nArray[j]-nArray[i-1];
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        stk = new StringTokenizer(br.readLine());
        for(int i =1;i<=n;i++){
            nArray[i] = nArray[i-1]+Integer.parseInt(stk.nextToken());
        }

        for(int i =0;i<m;i++){
            stk = new StringTokenizer(br.readLine());
            int j = Integer.parseInt(stk.nextToken());
            int k = Integer.parseInt(stk.nextToken());

            bw.write(solution(j,k)+"\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
