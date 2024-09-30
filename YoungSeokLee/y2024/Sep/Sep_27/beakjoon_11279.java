package y2024.Sep.Sep_27;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
최대 힙 - 실버 2
 */
public class beakjoon_11279 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        for(int i =0;i<n;i++){
            int x = Integer.parseInt(br.readLine());
            if(x !=0) {
                maxHeap.add(x);
            } else {
                if(!maxHeap.isEmpty())
                    bw.write(maxHeap.poll()+"\n");
                else
                    bw.write(0+"\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
