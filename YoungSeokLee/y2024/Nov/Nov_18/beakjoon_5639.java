package y2024.Nov.Nov_18;

import java.io.*;
import java.util.ArrayList;

/*
이진 검색 트리

조건
1. 노드의 왼쪽 서브트리에 있는 모든 노드의 키는 노드의 키보다 작다
2. 노드의 오른쪽 서브트리에 있는 모든 노드의 키는 노드의 키보다 크다
3. 왼쪽, 오른쪽 서브트리도 이진 검색 트리이다.

전위순회(ROOT-LEFT-RIGHT) 한 결과가 주어질 때
후위 순회(LEFT-RIGHT-ROOT) 한 결과를 구하라
 */
class Node {
    Node left, right, parent;
    int key;

    public Node(int item) {
        key = item;
        left = right = parent = null;
    }
}

class BinarySearchTree {
    Node root;
    ArrayList<Integer> postOrder;

    BinarySearchTree() {
        root = null;
        postOrder = new ArrayList<>();
    }

    void insert(int key) {
        root = insertRec(root, key, null);
    }

    Node insertRec(Node root, int key, Node parent) {
        if (root == null) {
            root = new Node(key);
            root.parent = parent;
            return root;
        }

        if (key < root.key)
            root.left = insertRec(root.left, key, root);
        else if (key > root.key)
            root.right = insertRec(root.right, key, root);

        return root;
    }

    void postOrder(Node root) {
        if(root.left!=null)
            postOrder(root.left);
        if(root.right!=null)
            postOrder(root.right);
        postOrder.add(root.key);
    }
}

public class beakjoon_5639 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        BinarySearchTree tree = new BinarySearchTree();
        String inputStr;

        while ((inputStr = br.readLine()) != null && !inputStr.isEmpty()){
            tree.insert(Integer.parseInt(inputStr));
        }

        tree.postOrder(tree.root);
        for(int value:tree.postOrder){
            bw.write(value+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
