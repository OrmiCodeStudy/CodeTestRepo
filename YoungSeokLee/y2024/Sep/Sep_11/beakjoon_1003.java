package y2024.Sep.Sep_11;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
피보나치 함수

피보나치 N을 호출했을때 ,0과 1이 각각 몇번 출력되는지 구하라

T : 테스트케이스개수
N : 40보다 작거나 같은 자연수 또는 0

동적 계획법 : 문제를 작은 단위로 나눠서 푸는 방법
한번 더 풀어보자
재귀 : O(N^2)
동적 계획법 : O(N)
 */

public class beakjoon_1003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        int[][] fibonacci = new int[41][2];

        fibonacci[0][0]=1;
        fibonacci[0][1]=0;
        fibonacci[1][0]=0;
        fibonacci[1][1]=1;

        for(int i =2;i<=40;i++){
            fibonacci[i][0]= fibonacci[i-1][0] + fibonacci[i-2][0];
            fibonacci[i][1]= fibonacci[i-1][1] + fibonacci[i-2][1];
        }

        for(int i=0;i<t;i++){
            int n = Integer.parseInt(br.readLine());
            bw.write(fibonacci[n][0]+" "+fibonacci[n][1]+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
