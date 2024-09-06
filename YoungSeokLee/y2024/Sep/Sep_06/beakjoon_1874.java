package y2024.Sep.Sep_06;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
스택 수열
1부터 n까지의 수를 스택에 넣었다가 뽑아 늘어놓아 하나의 수열을 만든다
push와 pop을 통해 입력되는 수열을 만들수 있다면 +-를통해 과정을 나타내고
불가능하다면 NO를 출력
 */
public class beakjoon_1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Stack<Integer> numStack = new Stack<>();
        Queue<String> stageQueue = new LinkedList<>();
        int cnt = 1;
        for(int i =1;i<=n;i++){
            int inputNum = Integer.parseInt(br.readLine());
            while(true){
                if(!numStack.isEmpty() && numStack.peek()==inputNum){
                    numStack.pop();
                    stageQueue.add("-");
                    break;
                } else if(numStack.isEmpty() || numStack.peek()<=inputNum) {
                    numStack.push(cnt);
                    cnt++;
                    stageQueue.add("+");
                } else {
                    break;
                }
            }
        }
        if(!numStack.isEmpty()){
            bw.write("NO");
        } else {
            for(String stage: stageQueue){
                bw.write(stage+"\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

}
