package y2024.Nov.Nov_05;

import java.io.*;
import java.util.*;

public class beakjoon_1043_unionFind {
    static int[] parent;
    static boolean[] knowsTruth;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];
        knowsTruth = new boolean[N + 1];
        for (int i = 0; i <= N; i++) {
            parent[i] = i;
        }

        st = new StringTokenizer(br.readLine());
        int truthNum = Integer.parseInt(st.nextToken());
        for (int i = 0; i < truthNum; i++) {
            int person = Integer.parseInt(st.nextToken());
            knowsTruth[person] = true;
        }

        List<List<Integer>> parties = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int partySize = Integer.parseInt(st.nextToken());
            List<Integer> party = new ArrayList<>();
            for (int j = 0; j < partySize; j++) {
                party.add(Integer.parseInt(st.nextToken()));
            }
            parties.add(party);

            for (int j = 1; j < partySize; j++) {
                union(party.get(0), party.get(j));
            }
        }

        // 진실을 아는 사람들의 정보 전파
        for (int i = 1; i <= N; i++) {
            if (knowsTruth[i]) {
                int root = find(i);
                knowsTruth[root] = true;
            }
        }

        int count = 0;
        for (List<Integer> party : parties) {
            boolean canLie = true;
            for (int person : party) {
                if (knowsTruth[find(person)]) {
                    canLie = false;
                    break;
                }
            }
            if (canLie) count++;
        }

        System.out.println(count);
    }

    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            parent[b] = a;
            knowsTruth[a] |= knowsTruth[b];
        }
    }
}