import java.util.Scanner;
// 시간초과
public class Main {
    static int n, m, answer = Integer.MAX_VALUE;

    public void DFS(int L, int sum, int[] arr) {
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
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt(); // 동전의 종류개수
        int[] arr = new int[n]; // n개 동전의 종류
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        m = kb.nextInt(); // 거슬러줄 금액
        T.DFS(0, 0, arr);
        System.out.println(answer);;
    }
}