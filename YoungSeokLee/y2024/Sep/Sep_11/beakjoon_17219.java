package y2024.Sep.Sep_11;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

/*
비밀번호 찾기

메모장에 사이트의 주소와 비밀번호를 저장

N : 저장된 사이트 주소의 수
M : 비밀번호를 찾으려는 사이트 주소의 수
 */

public class beakjoon_17219 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        HashMap<String,String> siteToPassword = new HashMap<>();
        for(int i =0;i<n;i++){
            stk = new StringTokenizer(br.readLine());
            siteToPassword.put(stk.nextToken(),stk.nextToken());
        }

        for(int i =0;i<m;i++){
            bw.write(siteToPassword.get(br.readLine())+"\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
