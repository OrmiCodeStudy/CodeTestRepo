package y2024.Oct.Oct_03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
IOIOI - 실버1

Pn : N+1개의 I와 N개의 O로 이루어져 있으면 IO가 교대로 나오는 문자열

S : IO로만 이뤄진 문자열
N : O의 갯수
M : S의 길이

슬라이딩 윈도우
start와 end를 이동시키면서 pn과 동일한지 확인
 */
public class beakjoon_5525 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        String s = br.readLine();

        StringBuilder sb = new StringBuilder();
        for(int i =0;i<n*2+1;i++){
            if(i%2==0)
                sb.append("I");
            else
                sb.append("O");
        }
        String pn = sb.toString();

        int start = 0;
        int end = pn.length()-1;
        int cnt = 0;
        while(end<m){
            if(s.substring(start,end+1).equals(pn)){
                cnt++;
                start++;
                end++;
            }
            start++;
            end++;
        }

        bw.write(String.valueOf(cnt));
        bw.flush();
        bw.close();
        br.close();
    }
}
