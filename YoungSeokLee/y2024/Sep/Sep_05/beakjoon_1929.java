package y2024.Sep.Sep_05;

import java.io.*;
import java.util.StringTokenizer;
/*
소수 구하기
에라토스테네스의 체 (N * log(log(N)))
1. 범위내 모든 숫자를 소수라 가정
2. 실제 소수인 가장 작은 숫자(2)부터 2의 배수를 전부 소수에서 제외
3. 다음 실제 소수인 숫자로 반복
 */
public class beakjoon_1929 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(stk.nextToken()), n = Integer.parseInt(stk.nextToken());

        boolean[] isPrime = new boolean[n + 1];

        // 에라토스테네스의 체 알고리즘 초기화
        for (int i = 2; i <= n; i++) {
            isPrime[i] = true;  // 모든 수를 소수로 가정
        }

        // 소수 판별
        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;  // i의 배수는 소수가 아니므로 false
                }
            }
        }

        // 결과 출력
        for (int i = m; i <= n; i++) {
            if (isPrime[i]) {
                bw.write(i + "\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
