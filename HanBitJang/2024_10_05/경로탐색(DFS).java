import java.util.Scanner;
// 나의 풀이
public class Main {
    static int n, m;
    static int[] ch;
    static int[][] arr;
    int answer = 0;

    public int DFS(int i) {
        ch[i] = 1;
        if (i == n) {
            answer++;
        } else {
            for (int j = 1; j <= n; j++) {
                if(ch[j] == 0 && arr[i][j] == 1) {
                    ch[j] = 1;
                    DFS(j);
                }
            }

        }
        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        m = kb.nextInt();
        ch = new int[n + 1];
        arr = new int[n + 1][n + 1];

        for (int i = 0; i < m; i++) {
            int a = kb.nextInt();
            int b = kb.nextInt();
            arr[a][b] = 1;
        }
        System.out.println(T.DFS(1));;
    }

}