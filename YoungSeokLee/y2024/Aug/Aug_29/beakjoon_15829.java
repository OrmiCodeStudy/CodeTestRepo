package y2024.Aug.Aug_29;

import java.io.*;
/*
BigInteger로 풀어보기
 */
public class beakjoon_15829 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int l = Integer.parseInt(br.readLine());
        String inputString = br.readLine();
        int r = 31;
        int m = 1234567891;
        int sumVal = 0;
        for(int i =0;i<inputString.length();i++){
            sumVal += Math.pow(r,i)*((int)inputString.charAt(i)-96);
        }

        bw.write(sumVal%m+"");
        bw.flush();
        bw.close();
        br.close();
    }
}
