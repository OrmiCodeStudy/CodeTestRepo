package y2024.Sep.Sep_10;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
ATM


 */
public class beakjoon_11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] withdraw = new int[n];

        StringTokenizer stk = new StringTokenizer(br.readLine());
        for(int i =0;i<n;i++){
            withdraw[i]=Integer.parseInt(stk.nextToken());
        }
        Arrays.sort(withdraw);

        int[] spentTime = new int[n];
        spentTime[0]=withdraw[0];
        int sum = spentTime[0];

        for(int i =1;i<n;i++){
            spentTime[i]=spentTime[i-1]+withdraw[i];
            sum+=spentTime[i];
        }

        bw.write(sum+"");
        bw.flush();
        bw.close();
        br.close();
    }
}
