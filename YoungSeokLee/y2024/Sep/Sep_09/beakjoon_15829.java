package y2024.Sep.Sep_09;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

public class beakjoon_15829 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String inputString = br.readLine();
        BigInteger bigNum = new BigInteger("0");
        BigInteger r = new BigInteger("31");
        BigInteger M = new BigInteger("1234567891");
        for(int i =0; i<n;i++){
            int inputNum = inputString.charAt(i)-96;

            BigInteger bigNum2 = new BigInteger(inputNum+"");
            BigInteger r2 = new BigInteger("1");
            for(int j =0;j<i;j++){
                r2 = r2.multiply(r);
            }
            bigNum = bigNum.add(bigNum2.multiply(r2));
        }
        bw.write(bigNum.remainder(M).toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
