public class Solution {
    public int solution(int n, int k) {
        // 숫자를 k진수로 변환
        String str = Integer.toString(n, k);

        // 변환된 문자열을 '0'을 기준으로 나누고, 각 부분이 소수인지 확인
        String[] parts = str.split("0");
        int count = 0;

        for (String part : parts) {
            if (!part.isEmpty() && isPrime(Long.parseLong(part))) {
                count++;
            }
        }

        return count;
    }

    // 주어진 숫자가 소수인지 판별하는 함수
    private boolean isPrime(long num) {
        if (num < 2) {
            return false;
        }
        for (long i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
