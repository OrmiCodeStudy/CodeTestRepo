package y2024.Sep.Sep_25;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

/*
최소 힙 - 실버2

최소 힙을 이용하여 다음과 같은 연산을 지원하는 프로그램을 작성하라

1. 배열에 자연수 x를 넣는다
2. 배열에서 가장 작은 값을 출력하고 그 값을 배열에서 제거한다.

 */
public class beakjoon_1927 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        int n = Integer.parseInt(br.readLine());

        for(int i =0;i<n;i++){
            int numVal = Integer.parseInt(br.readLine());
            if(numVal != 0){
                minHeap.add(numVal);
            } else {
                if(minHeap.isEmpty()){
                    bw.write(0+"\n");
                } else {
                    bw.write(minHeap.poll()+"\n");
                }
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
