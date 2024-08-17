package y2024.Aug.Aug_14;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class beakjoon_동전0 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken()), k = Integer.parseInt(stk.nextToken());
        int[] coinArr = new int[n];

        for(int i =0;i<n;i++){
            coinArr[i] = Integer.parseInt(br.readLine());
        }

        beakjoon_동전0 T = new beakjoon_동전0();
        bw.write(T.coinNum(coinArr,k));

        bw.flush();
        bw.close();
        br.close();
    }

    public String coinNum(int[] coinArr, int price){
        int coinCnt = 0;

        for(int i = coinArr.length-1; i>=0 ;i--){
            if(price == 0)
                break;
            coinCnt+=price/coinArr[i];
            price%=coinArr[i];
        }

        return String.valueOf(coinCnt);
    }
}
