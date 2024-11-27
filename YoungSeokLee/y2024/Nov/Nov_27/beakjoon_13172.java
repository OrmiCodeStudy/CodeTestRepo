package y2024.Nov.Nov_27;

import java.io.*;
import java.util.StringTokenizer;

/*
Σ - 골드 4

M : 주사위의 수
Ni : i번째 주사위의 면 수
Si : 모든 면에 적힌 숫자를 더한 값

모든 주사위를 던졌을때 나온 숫자들의 합의 기댓값을 구하라


 */
public class beakjoon_13172 {
    static long modInverse(long a, long m) {
        return power(a, m - 2, m);
    }

    static long power(long base, long exp, long mod) {
        long result = 1;
        base %= mod;
        while (exp > 0) {
            if (exp % 2 == 1)
                result = (result * base) % mod;
            base = (base * base) % mod;
            exp /= 2;
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        final int MODNUM = 1000000007;

        int m = Integer.parseInt(br.readLine());

        StringTokenizer stk;
        long answer = 0;
        for(int i =0;i<m;i++){
            stk = new StringTokenizer(br.readLine());
            long b = Long.parseLong(stk.nextToken());
            long a = Long.parseLong(stk.nextToken());

            long inverse = modInverse(b, MODNUM);
            answer = (answer + (a * inverse) % MODNUM) % MODNUM;
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
        br.close();
    }
}
