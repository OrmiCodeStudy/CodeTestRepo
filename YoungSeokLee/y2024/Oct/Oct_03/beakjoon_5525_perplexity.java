package y2024.Oct.Oct_03;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class beakjoon_5525_perplexity {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        String s = br.readLine();

        int patternCnt = 0;
        int cnt = 0;
        for(int i =1;i<m-1;i++){
            if(s.charAt(i-1)=='I' && s.charAt(i)=='O' && s.charAt(i+1)=='I'){
                patternCnt++;
                if(patternCnt==n){
                    cnt++;
                    patternCnt--;
                }
                i++;
            } else {
                patternCnt = 0;
            }
        }

        bw.write(String.valueOf(cnt));
        bw.flush();
        bw.close();
        br.close();
    }
}
