package y2024.Aug.Aug_25;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class beakjoon_연결요소의개수 {

    static boolean[] visited;
    static ArrayList<Integer>[] arrayLists;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(stk.nextToken()),m = Integer.parseInt(stk.nextToken());

        visited = new boolean[n+1];
        arrayLists = new ArrayList[n+1];

        for(int i =1;i<n+1;i++){
            arrayLists[i] = new ArrayList<Integer>();
        }

        for(int i =0;i<m;i++){
            stk = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(stk.nextToken());
            int y = Integer.parseInt(stk.nextToken());
            arrayLists[x].add(y);
            arrayLists[y].add(x);
        }

        int cnt = 0;
        // DFS로 진행하면 연결된 엣지들은 visited처리되었기 때문에 연결요소를 구할 수 있다.
        for(int i =1;i<n+1;i++){
            if(!visited[i]){
                cnt++;
                DFS(i);
            }
        }

        bw.write(cnt+"");
        bw.close();
        br.close();
    }

    private static void DFS(int v) {
        if(visited[v]){
            return;
        }
        visited[v] = true;
        for(int i : arrayLists[v]){
            if(!visited[i]){
                DFS(i);
            }
        }
    }
}