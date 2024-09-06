package y2024.Sep.Sep_06;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

/*
통계학(2108)
N개의 수가 주어졌을때
1. 산술평균 : N개의 수들의 합을 N으로 나눈값
2. 중앙값 : N개의 수들을 증가하는 순서로 나열했을 경우 그 중앙에 위치하는 값
3. 최빈값 : N개의 수들중 가장 많이 나타나는 값
4. 범위 : N개의 수들 중 최댓값과 최솟값의 차이

https://80000coding.oopy.io/21cb57a3-681b-404d-a4ac-8ab0e7289bc0
 */
public class beakjoon_2108 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] inputArr = new int[n];
        int[] cntArr = new int[8001];
        for(int i =0;i<n;i++){
            inputArr[i] = Integer.parseInt(br.readLine());
            cntArr[inputArr[i]+4000]++;
        }

        int[] meanArr = new int[4];
        for(int numVal:inputArr){
            meanArr[0]+=numVal;
        }
        meanArr[0] = (int)Math.round(meanArr[0]/(double)n);

        Arrays.sort(inputArr);
        meanArr[1] = n%2==0?(inputArr[n/2-1]+inputArr[n/2])/2:inputArr[n/2];


        ArrayList<Integer> mostVisitedList = new ArrayList<>();
        int maxCnt = Integer.MIN_VALUE;
        for(int i =0;i<8001;i++){
            if(cntArr[i]>maxCnt){
                mostVisitedList.clear();
                maxCnt=cntArr[i];
                mostVisitedList.add(i-4000);
            } else if (cntArr[i]==maxCnt) {
                mostVisitedList.add(i-4000);
            }
        }
        meanArr[2]=mostVisitedList.size()>1?mostVisitedList.get(1):mostVisitedList.get(0);

        meanArr[3]=inputArr[n-1]-inputArr[0];

        for(int mean:meanArr){
            bw.write(mean+"\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
