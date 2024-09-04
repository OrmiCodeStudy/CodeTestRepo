package y2024.Sep.Sep_04;

import java.io.*;
import java.util.Stack;

/*
제로
정수가 0이면 최근 수를 지우고 아닌경우 해당 수를 쓴다.
 */
public class beakjoon_10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int k = Integer.parseInt(br.readLine());
        Stack<Integer> moneyStack = new Stack<>();
        for(int i =0;i<k;i++){
            int inputVal = Integer.parseInt(br.readLine());

            if(inputVal!=0)
                moneyStack.add(inputVal);
            else
                moneyStack.pop();
        }

        int sumVal=0;
        while(!moneyStack.isEmpty()){
            sumVal+=moneyStack.pop();
        }
        bw.write(sumVal+"");
        bw.flush();
        bw.close();
        br.close();
    }
}
