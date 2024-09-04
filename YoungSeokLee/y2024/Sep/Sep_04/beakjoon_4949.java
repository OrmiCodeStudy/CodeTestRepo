package y2024.Sep.Sep_04;

import java.io.*;
import java.util.Stack;

/*
균형잡힌 세상

괄호 : [] , ()
각각의 괄호들은 종류가 동일해야한다.
짝을 이루는 괄호가 있을때 그 사이에 있는 문자열도 균형이 잡혀야 한다. (?)
주어진 문자열이 균형잡힌 문자열인지 판단하라
입력의 종료조건 : .
괄호가 하나도 없어도 문자열로 간주
 */
public class beakjoon_4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<Character> gualhoStack = new Stack<>();
        String inputString = br.readLine();

        while(!inputString.equals(".")){
             for(int i =0;i<inputString.length();i++){
                 char inputChar = inputString.charAt(i);
                 if(inputChar=='(' || inputChar=='['){
                     gualhoStack.add(inputChar);
                 } else if(inputChar==')') {
                     if(gualhoStack.isEmpty() || gualhoStack.peek()!='('){
                         gualhoStack.add(inputChar);
                         break;
                     } else if(gualhoStack.peek()=='('){
                         gualhoStack.pop();
                     }
                 } else if(inputChar==']') {
                     if(gualhoStack.isEmpty() || gualhoStack.peek()!='['){
                         gualhoStack.add(inputChar);
                         break;
                     } else if(gualhoStack.peek()=='['){
                         gualhoStack.pop();
                     }
                 }
             }
             if(gualhoStack.isEmpty()){
                 bw.write("yes\n");
             } else {
                 bw.write("no\n");
             }
             gualhoStack.clear();
             inputString = br.readLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
