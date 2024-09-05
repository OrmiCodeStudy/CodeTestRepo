package y2024.Sep.Sep_05;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
프린터 큐(1966) 실버3
새 프린터의 인쇄로직
1. 현재 Queue의 가장 앞에 있는 문서의 중요도를 확인
2. 나머지 문서들 중 현재 문서보다 중요도가 높은 문서가 하나라도 있다면, 이 문서를 인쇄하지 않고 Queue의 가장 뒤에 재배치 한다. 그렇지 않다면 바로 인쇄
 */
public class beakjoon_1966 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        int testNum = Integer.parseInt(br.readLine());
        for(int i =0;i<testNum;i++){
            stk = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(stk.nextToken());
            int m = Integer.parseInt(stk.nextToken());

            stk = new StringTokenizer(br.readLine());
            Queue<Integer> priorityQueue = new LinkedList<>();
            for(int j =0;j<n;j++){
                priorityQueue.add(Integer.parseInt(stk.nextToken()));
            }

            int cnt = 0;
            while(m!=-1){
                int candidateNum = priorityQueue.poll();
                cnt++;
                m--;
                for(int numVal:priorityQueue){
                    if(candidateNum<numVal){
                        if(m==-1){
                            m=priorityQueue.size();
                        }
                        priorityQueue.add(candidateNum);
                        cnt--;
                        break;
                    }
                }
            }
            bw.write(cnt+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
