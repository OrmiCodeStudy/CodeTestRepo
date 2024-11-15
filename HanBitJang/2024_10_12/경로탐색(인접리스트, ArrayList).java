import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int n, m, answer;
    static int[] ch;
    static ArrayList<ArrayList<Integer>> graph;

    public void DFS(int v) {
        if (v == n) {
            answer++;
        } else {
            // 정점의 개수만큼 for문을 순회하는 인접행렬 풀이(DFS) 대신 ArrayList 활용
            for(int i : graph.get(v)) {
                if(ch[i] == 0) {
                    ch[i] = 1;
                    DFS(i);
                    ch[i] = 0;
                }
            }

        }

    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        m = kb.nextInt();
        ch = new int[n + 1];
        graph = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < m; i++) {
            int a = kb.nextInt();
            int b = kb.nextInt();
            graph.get(a).add(b);
        }
        ch[1] = 1;
        T.DFS(1);
        System.out.println(answer);
    }
}