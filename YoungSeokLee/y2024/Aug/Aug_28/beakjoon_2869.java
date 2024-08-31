package y2024.Aug.Aug_28;

import java.io.*;
import java.util.StringTokenizer;

/*
v에서 a를 뺀 후, a-b로 나눈 몫에 +1 하면 나온다
*/
public class beakjoon_2869 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(stk.nextToken()),b = Integer.parseInt(stk.nextToken()),v = Integer.parseInt(stk.nextToken());

        int cnt = (v-b)/(a-b);
        if((v-a)%(a-b)!=0)
            cnt++;

        bw.write(cnt+"");
        bw.flush();
        bw.close();
        br.close();
    }
}
