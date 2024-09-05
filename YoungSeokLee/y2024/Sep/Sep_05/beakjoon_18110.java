package y2024.Sep.Sep_05;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

/*
solved.ac

문제의 난이도는 그 문제를 푼 사람들이 제출한 난이도 의견을 바탕으로 결정
1. 아무 의견이 없다면 문제의 난이도는 0
2. 의견이 하나 이상 있다면, 문제의 난이도는 모든 사람의 난이도 의견의 30% 절사평균(위 15% 아래 15% 제외)으로 결정
절사평균 : 가장 큰 값들과 가장 작은 값들을 제외하고 평균을 낸다
절사평균과 제외되는 사람의 수는 반올림한다.
 */
public class beakjoon_18110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> scoreList = new ArrayList<>();
        for(int i =0;i<n;i++){
            scoreList.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(scoreList);

        int exceptNum = (int)Math.round(n * 0.15);
        int sumVal = 0;
        for(int i =exceptNum;i<n-exceptNum;i++){
            sumVal += scoreList.get(i);
        }
        int answer = Math.round((float)sumVal/(n-exceptNum*2));

        bw.write(answer+"");
        bw.flush();
        bw.close();
        br.close();
    }
}
