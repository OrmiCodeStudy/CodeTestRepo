package y2024.Nov.Nov_13;

import java.io.*;
import java.util.*;

public class beakjoon_1967 {
    static ArrayList<ArrayList<Node>> tree;
    static int maxDist, farthestNode;

    static class Node {
        int to, weight;
        Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static void dfs(int node, int parent, int distance) {
        if (distance > maxDist) {
            maxDist = distance;
            farthestNode = node;
        }

        for (Node next : tree.get(node)) {
            if (next.to != parent) {
                dfs(next.to, node, distance + next.weight);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        tree = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            tree.get(parent).add(new Node(child, weight));
            tree.get(child).add(new Node(parent, weight));
        }

        maxDist = 0;
        dfs(1, 0, 0);
        maxDist = 0;
        dfs(farthestNode, 0, 0);

        bw.write(String.valueOf(maxDist));
        bw.flush();
        bw.close();
        br.close();
    }
}