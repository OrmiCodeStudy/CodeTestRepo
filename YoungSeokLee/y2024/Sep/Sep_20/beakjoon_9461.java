package y2024.Sep.Sep_20;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
/*
파도반 수열

삼각형이 나선모양으로 놓인다
첫 정삼각형의 변은 1
파도반 수열 P(N)은 나선에 있는 정삼각형의 변의 길이
P(1) ~ P(10) = 1,1,1,2,2,3,4,5,7,9
N이 주어졌을 때, P(N)을 구하라

DP로 풀기

P(N) = P(N-5)+P(N-1)
P(6) = P(1) + P(5) = 1+2
P(7) = P(2) + P(6) = 1+3
 */
public class beakjoon_9461 {

    static long[] waveArray = new long[101];
    static void wavePattern(int n){
        waveArray[1] = waveArray[2] = waveArray[3] = 1;
        waveArray[4] = waveArray[5] = 2;
        for(int i=6;i<=n;i++){
            waveArray[i] = waveArray[i-5]+waveArray[i-1];
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        int n;
        int[] nArray = new int[t];
        int maxNum = Integer.MIN_VALUE;
        for(int i =0;i<t;i++){
            n = Integer.parseInt(br.readLine());
            nArray[i]=n;
            if(n>maxNum){
                maxNum=n;
            }
        }

        wavePattern(maxNum);

        for(int inputNum:nArray){
            bw.write(waveArray[inputNum]+"\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
