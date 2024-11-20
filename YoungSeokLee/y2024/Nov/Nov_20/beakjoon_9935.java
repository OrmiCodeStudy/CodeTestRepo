package y2024.Nov.Nov_20;

import java.io.*;

/*
문자열 폭발 - 골드 4

폭발 과정
1. 문자열이 폭발 문자열을 포함한다면, 모든 폭발 문자열이 폭발하고 남은 문자열을 순서대로 이어 붙여 새로운 문자열을 만든다
2. 새로 생긴 문자열에 폭발 문자열이 포함되어 있을 수 있다.
3. 폭발은 폭발 문자열이 문자열에 없을 때까지 계속된다.

모든 폭발이 끝난 후에 어떤 문자열이 남는지 구하라
남은 문자가 없다면 FRULA 를 출력한다
 */
public class beakjoon_9935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String inputStr = br.readLine();
        String bomb = br.readLine();

        StringBuilder sb = new StringBuilder();

        for(char c: inputStr.toCharArray()){
            sb.append(c);
            if(sb.length()>=bomb.length()) {
                boolean isBomb = true;
                for(int i =0;i<bomb.length();i++){
                    if(sb.charAt(sb.length() - bomb.length() + i)!= bomb.charAt(i)){
                        isBomb = false;
                        break;
                    }
                }
                if(isBomb){
                    sb.setLength(sb.length()-bomb.length());
                }
            }
        }

        String answer = sb.length() == 0 ? "FRULA" : sb.toString();

        bw.write(answer);
        bw.flush();
        bw.close();
        br.close();
    }
}
