package Aug_10;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.Queue;
import java.util.LinkedList;

public class beakjoon_카드2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        //FIFO
        Queue<Integer> queue = new LinkedList<>();

        for(int i = 1;i<=n;i++){
            queue.add(i);
        }

        while(queue.size()>1){
            queue.poll();
            queue.add(queue.poll());
        }

        System.out.println(queue.poll());
    }
}
