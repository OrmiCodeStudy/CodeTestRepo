package y2024.Sep.Sep_10;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

/*
나는야 포켓몬 마스터 이다솜

도감을 완성시켜야 한다
포켓몬 도감에서 포켓몬의 이름을 보면 포켓몬의 번호를 말하거나
포켓몬의 번호를 보면 포켓몬의 이름을 말하는 프로그램
N : 도감에 수록되어있는 포켓몬의 개수
M : 내가 맞춰야 하는 문제의 개수

 */
public class beakjoon_1620 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        String[] indexToName = new String[n+1];
        HashMap<String,Integer> nameToIndex = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            String name = br.readLine();
            indexToName[i]=name;
            nameToIndex.put(name,i);
        }

        for (int i = 0; i < m; i++) {
            String problem = br.readLine();
            if (Character.isDigit(problem.toCharArray()[0])) {
                bw.write(indexToName[Integer.parseInt(problem)]+"\n");
            } else {
                bw.write(nameToIndex.get(problem) + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
