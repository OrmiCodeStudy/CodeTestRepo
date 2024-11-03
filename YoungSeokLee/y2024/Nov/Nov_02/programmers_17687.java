package y2024.Nov.Nov_02;

import java.io.*;
import java.util.StringTokenizer;

/*
N 진수 게임

1. 숫자를 0부터 시작해서 차례대로 말한다.
2. 10 이상의 숫자부터는 한자리씩 끊어서 말한다.

이진법, 16진법까지 모든 진법으로 게임을 진행할 수 있다

튜브가 말해야하는 숫자 t개를 공백없이 차례대로 나타낸 문자열을 출력하라.

n : 진법
t : 미리 구할 숫자의 개수
m : 게임에 참가하는 인원
p : 튜브의 순서

풀이

1자리 : 1명이 1개의 숫자를 말하는 갯수(n)
2자리 : 2명이 1개의 숫자를 말하는 갯수(n^2-n)
3자리 : 3명이 1개의 숫자를 말하는 갯수(n^3-n^2)
...

finalCnt = t*m+p

현재 몇번째 숫자인지 카운트 하면서 몇번째 숫자의 몇번째 자릿수인지도 카운트 해야함
 */
public class programmers_17687 {

    //    static public String solution(int n, int t, int m, int p) {
//        StringBuilder answer = new StringBuilder();
//        int endPoint,prevNum=0;
//        int currPos = 0;
//        int cnt=0;
//        for(int i =1;true;i++){ // 자릿수(몇명이 하나의 숫자를 말하는지)
//            endPoint = (int)Math.pow(n,i);
//            for(int j =prevNum;j<endPoint;j++){ //숫자
//                String currNum="";
//                if(n==2)
//                    currNum = Integer.toBinaryString(j);
//                if(n==8)
//                    currNum = Integer.toOctalString(j);
//                if(n==16)
//                    currNum = Integer.toHexString(j);
//
//                for(int k =0;k<currNum.length();k++){ // 현재 자리수
//                    currPos++;
//                    if(currPos%m==(p%m)){
//                        currNum = currNum.toUpperCase();
//                        answer.append(currNum.charAt(k));
//                        cnt++;
//                        if(cnt==t)
//                            return answer.toString();
//                    }
//                }
//            }
//            prevNum=endPoint;
//
//        }
//    }
    public static String solution(int n, int t, int m, int p) {
        StringBuilder result = new StringBuilder();
        StringBuilder allNumbers = new StringBuilder();
        int num = 0;

        while (allNumbers.length() < t * m) {
            allNumbers.append(Integer.toString(num, n).toUpperCase());
            num++;
        }

        for (int i = p - 1; i < t * m; i += m) {
            result.append(allNumbers.charAt(i));
        }

        return result.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int t = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());
        int p = Integer.parseInt(stk.nextToken());

        bw.write(solution(n, t, m, p));
        bw.flush();
        bw.close();
        br.close();
    }
}
