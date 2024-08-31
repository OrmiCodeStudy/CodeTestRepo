package y2024.Aug.Aug_29;

import java.io.*;
import java.util.StringTokenizer;

/*
티셔츠 : 남아도 되지만 사이즈별로 부족해선 안됨 (사이즈 별로 t로 나눠서 나머지가 있으면 몫에 +1)
팬 : 참가자 수만큼 준비 (인원수를 나눈값 + 나머지)
*/
public class beakjoon_30802 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int[] shirtArr = new int[6];
        for(int i =0;i<6;i++){
            shirtArr[i] = Integer.parseInt(stk.nextToken());
        }
        stk = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(stk.nextToken()), p = Integer.parseInt(stk.nextToken());

        int shirtCnt = 0;
        for(int shirt:shirtArr){
            shirtCnt+=shirt/t;

            if(shirt%t!=0)
                shirtCnt++;
        }
        bw.write(shirtCnt+"");
        bw.newLine();
        bw.write(n/p + " " + n%p);
        bw.flush();
        bw.close();
        br.close();
    }
}
