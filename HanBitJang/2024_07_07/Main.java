import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    int[] dis = {1, -1, 5}; // 점프할 수 있는 거리를 저장하는 배열
    int[] ch; // 방문한 위치를 확인하는 배열 - 현수가 방문한 위치(인덱스)에는 1 저장
    Queue<Integer> Q = new LinkedList<>(); // 이진트리 레벨별로 현수가 방문한 위치를 저장

    public int BFS(int s, int e) {
        ch = new int[10001];
        ch[s] = 1; // 출발 지점
        Q.offer(s);
        int L = 0;
        while (!Q.isEmpty()) {
            int len = Q.size();
            for (int i = 0; i < len; i++) {
                int x = Q.poll();
                for (int j = 0; j < 3; j++) {
                    int nx = x + dis[j]; // 레벨별 노드에서 1/-1/5만큼 점프한 후의 위치
                    // 현수의 위치가 송아지와 같아질 경우
                    if(nx == e) {
                        return L+1;
                    }
                    // 현수의 위치가 문제 조건을 충족하고 아직 방문한 적 없는 노드인 경우
                    if (nx >= 1 && nx <= 10000 && ch[nx] == 0) {
                        ch[nx] = 1; // 방문했다고 표시하고
                        Q.offer(nx); // 큐에 저장
                    }

                }
            }
            L++;
        }
        return 0;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int s = kb.nextInt();
        int e = kb.nextInt();
        System.out.println(T.BFS(s, e));
    }
}