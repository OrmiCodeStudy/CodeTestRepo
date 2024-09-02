package y2024.Aug.Aug_30;

import java.io.*;
import java.util.Stack;

/*
곱셈 과정에서 10이 몇개나 들어가는지를 파악하면 됨
N이 주어지면 1에서 N까지 10이 발생하는 경우를 찾아서 cnt++;
10의 배수이면 cnt++
2의 배수이면 stack.push
5의 배수이면 stack.pop, cnt++
*/
public class beakjoon_1676 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int cnt = 0;
        Stack<Integer> integerStack = new Stack<>();
        for(int i =1;i<=n;i++){
            int tempI = i;

//            while(tempI%10==0){
//                tempI/=10;
//                cnt++;
//            }
//            while(tempI%2==0){
//                tempI/=2;
//                integerStack.push(2);
//            }
            while(tempI%5==0){
                tempI/=5;
                integerStack.pop();
                cnt++;
            }
        }

        bw.write(cnt+"");
        bw.flush();
        bw.close();
        br.close();
    }
}
