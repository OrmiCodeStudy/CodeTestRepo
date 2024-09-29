import java.util.Scanner;

public class Main {
    static int n;
    static int[] ch;

    public void DFS(int L) {
        if (L == n + 1) { // 종학점에 도착했을 때
            String tmp = "";
            for (int i = 1; i <= n; i++) {
                if (ch[i] == 1) {
                    tmp += (i + " ");
                }
            }
            if (tmp.length() > 0) {
                System.out.println(tmp);
            }
        } else { // 종착점에 도달하지 못했을 때 -> 트리 두 갈래로 뻗어나가야 한다
            ch[L] = 1; // 해당 원소는 사용한다는 의미
            DFS(L + 1); // 왼쪽 노드 -> 사용한다는 의미에서 뻗는 함수
            ch[L] = 0; // 해당 원소는 사용하지 않는다는 의미
            DFS(L + 1); // 오른쪽 노드
        }
    }


    public static void main(String[] args) {
        Main T = new Main();
        n = 3;
        ch = new int[n + 1];
        T.DFS(1);
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
    }
}