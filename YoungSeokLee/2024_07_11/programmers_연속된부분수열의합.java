//슬라이딩 윈도우(투 포인터 알고리즘)를 활용한 버전

class Solution {
    public int[] solution(int[] sequence, int k) {
        int left = 0, right = 0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;
        int start = 0, end = 0;

        while (right < sequence.length) {
            sum += sequence[right];

            while (sum > k && left <= right) {
                sum -= sequence[left];
                left++;
            }

            if (sum == k) {
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    start = left;
                    end = right;
                }
            }

            right++;
        }

        return new int[]{start, end};
    }
}
