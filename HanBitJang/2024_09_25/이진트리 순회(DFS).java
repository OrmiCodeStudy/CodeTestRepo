class Node {
    int data;
    Node lt, rt; // 노드 클래스의 객체 주소를 저장하는 변수

    public Node(int val) {
        data = val;
        lt = rt = null; // 객체가 생성되는 순간에는 null값
    }
}
public class Main {
    Node root;

    public void DFS(Node root) {
        if (root == null) { // 말단 노드로 온 것
            return;
        } else {
            //System.out.print(root.data + " "); // 전위 순회, 1 2 4 5 3 6 7
            DFS(root.lt);
            //System.out.print(root.data + " "); // 중위 순회, 4 2 5 1 6 3 7
            DFS(root.rt);
            System.out.print(root.data + " "); // 후위 순회, 4 5 2 6 7 3 1
        }

    }

    public static void main(String[] args) {
        Main tree = new Main();
        tree.root = new Node(1); // 객체가 생성되는 순간에는 data 값은 있지만 lt, rt가 모두 null이다.
        tree.root.lt = new Node(2); // lt, rt 변수에 새로운 Node 객체를 생성한다.
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        tree.root.rt.lt = new Node(6);
        tree.root.rt.rt = new Node(7);
        tree.DFS(tree.root); // 1번 데이터를 가지고 있는 노드(루트 노드, 100번지)

    }
}