package y2024.Aug.Aug_12;

import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

/*
10,50,100,500 원 동전을 무한하게 갖고있을때
손님에게 800원을 거슬러주면서 동전을 최소한으로 주는 방법은?
*/
public class etc_동전거스름돈 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int price = Integer.parseInt(br.readLine());

        etc_동전거스름돈 T = new etc_동전거스름돈();
        int[] coinArr = T.calcCoin(price);

        for(int coinNum : coinArr){
            bw.write(coinNum+" ");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public int[] calcCoin(int price){
        int[] coinArr = new int[4];

        coinArr[0] = price/500;
        price%=500;

        coinArr[1] = price/100;
        price%=100;

        coinArr[2] = price/50;
        price%=50;

        coinArr[3] = price/10;

        return coinArr;
    }

}
