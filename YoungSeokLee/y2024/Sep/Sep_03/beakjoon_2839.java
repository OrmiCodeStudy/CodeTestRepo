package y2024.Sep.Sep_03;

import java.io.*;

public class beakjoon_2839 {

    public static int solution(int n){
        int answer = -1;
        int fiveLen = n/5;

        for(int i =fiveLen;i>=0;i--){
            int restNum = n-(i*5);
            if(restNum%3==0){
                answer=i;
                answer+=(restNum/3);
                break;
            }
        }
        return answer;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        bw.write(solution(n)+"");
        bw.flush();
        bw.close();
        br.close();
    }
}
