package y2024.Sep.Sep_03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class beakjoon_1920 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 배열 A의 크기 N
        int N = Integer.parseInt(st.nextToken());

        // 배열 A의 요소들 읽어오기
        int[] A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        // 배열 A를 정렬
        Arrays.sort(A);

        // 배열 B의 크기 M
        int M = Integer.parseInt(br.readLine());

        // 배열 B의 요소들 읽어오기 및 이진 탐색 수행
        st = new StringTokenizer(br.readLine());
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int query = Integer.parseInt(st.nextToken());
            if (binarySearch(A, query)) {
                result.append("1\n");
            } else {
                result.append("0\n");
            }
        }

        // 결과 출력
        System.out.print(result);
    }

    // 이진 탐색 메서드
    private static boolean binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == target) {
                return true;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}
