package y2024.Oct.Oct_23;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

/*
트리 순회 실버1

이진트리를 입력받아 전위순회, 중위순회, 후위 순회한 결과를 출력하는 프로그램을 만들어라

전위 순회한 결과 : ABDCEFG // (루트) (왼쪽 자식) (오른쪽 자식)
중위 순회한 결과 : DBAECFG // (왼쪽 자식) (루트) (오른쪽 자식)
후위 순회한 결과 : DBEGFCA // (왼쪽 자식) (오른쪽 자식) (루트)

풀이

int[][] tree = new int[n][3]
tree[n][0] : 왼쪽 자식
tree[n][1] : 오른쪽 자식
tree[n][2] : 루트
 */
public class beakjoon_1991 {
    static HashMap<Character, char[]> tree = new HashMap<Character, char[]>();
    static StringBuilder sb = new StringBuilder();

    void preorder(char node) {
        if (node == '.') return;
        sb.append(node);
        preorder(tree.get(node)[0]); // 왼쪽 자식 방문
        preorder(tree.get(node)[1]); // 오른쪽 자식 방문
    }

    void inorder(char node) {
        if (node == '.') return;
        inorder(tree.get(node)[0]); // 왼쪽 자식 방문
        sb.append(node); // 현재 노드 방문
        inorder(tree.get(node)[1]); // 오른쪽 자식 방문
    }

    void postorder(char node) {
        if (node == '.') return;
        postorder(tree.get(node)[0]); // 왼쪽 자식 방문
        postorder(tree.get(node)[1]); // 오른쪽 자식 방문
        sb.append(node); // 현재 노드 방문
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer stk;
        for (int i = 0; i < n; i++) {
            stk = new StringTokenizer(br.readLine());
            char root = stk.nextToken().charAt(0);
            char left = stk.nextToken().charAt(0);
            char right = stk.nextToken().charAt(0);
            tree.put(root,new char[]{left, right});
        }

        beakjoon_1991 T = new beakjoon_1991();
        T.preorder('A');
        sb.append("\n");
        T.inorder('A');
        sb.append("\n");
        T.postorder('A');
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
