package y2024.Nov.Nov_09;

import java.io.*;
import java.util.StringTokenizer;

/*
k진수에서 소수 개수 구하기

n : 양의 정수
k : 진수
n을 k진수로 변환한 수 안에 아래 조건에 맞는 소수가 몇개인가?
조건
1. 0P0처럼 소수 양쪽에 0이 있는 경우
2. P0처럼 소수 오른쪽에만 0이 있고 왼쪽에는 아무것도 없는 경우
3. 0P 처럼 소수 왼쪽에만 0이 있고 오른쪽에는 아무것도 없는 경우
4. P처럼 소수 양쪽에 아무것도 없는 경우
5. 단, P는 각 자릿수에 0을 포함하지 않는 소수
    - 예를들어 101은 P가 될 수 없다.

풀이 (25분 소요)
1. 0을 기준으로 문자열을 나눈다
2. 각 조건에 맞는 문자열을 선택해 배열로 저장
3. 해당 문자열들이 소수인지 확인
*/
public class programmers_92335 {
    public static boolean isPrime(long n) {
        if (n <= 1) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        for (long i = 3; i * i <= n; i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static int solution(int n, int k) {
        int answer = 0;
        String nString = Long.toString(n, k);
        String[] sArr = nString.split("0");

        for(String s : sArr){
            if(!s.isEmpty()){
                try {
                    long candidate = Long.parseLong(s);
                    if(isPrime(candidate)){
                        answer++;
                    }
                } catch (NumberFormatException e) {
                    // 숫자로 변환할 수 없는 경우 무시
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int k = Integer.parseInt(stk.nextToken());

        bw.write(String.valueOf(solution(n,k)));
        bw.flush();
        bw.close();
        br.close();
    }
}
