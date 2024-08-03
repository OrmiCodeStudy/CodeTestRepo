import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main2 {
    static int n, m, answer = Integer.MAX_VALUE;

    public void DFS(int L, int sum, Integer[] arr) {
        if (sum > m) {
            return;
        }
        if (L >= answer) {
            return;
        }
        if(sum == m) {
            answer = Math.min(answer, L);
        } else {
            for (int i = 0; i < n; i++) {
                DFS(L + 1, sum + arr[i], arr);
            }
        }
    }

    public static void main(String[] args) {
        Main2 T = new Main2();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt(); // 동전의 종류개수
        Integer[] arr = new Integer[n]; // n개 동전의 종류
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        Arrays.sort(arr, Collections.reverseOrder());
        m = kb.nextInt(); // 거슬러줄 금액
        T.DFS(0, 0, arr);
        System.out.println(answer);;
    }
}