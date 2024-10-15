package y2024.Oct.Oct_15;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

/*
N과M (4) - 실버3

조건
1. 1부터 N까지 자연수 중에서 M개를 고른 수열
2. 같은 수를 여러번 골라도 된다
3. 고른 수열은 비내림차순이어야 한다.
 */

public class beakjoon_15652 {
    String BFS(int start,int n, int m){

        StringBuilder sb = new StringBuilder();
        Stack<combination> s = new Stack<>();
        s.push(new combination(start,1,String.valueOf(start)));

        while(!s.isEmpty()){
            combination curr = s.pop();

            if(curr.len==m)
                sb.append(curr.combi+"\n");

            if(curr.len<m){
                for(int i=n-1;i>=curr.currNum-1;i--){
                    int newCurrNum = i+1;
                    int newLen = curr.len+1;
                    String newCombi = curr.combi+" "+newCurrNum;

                    s.push(new combination(newCurrNum,newLen,newCombi));
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        beakjoon_15652 T = new beakjoon_15652();

        for(int i =1;i<=n;i++){
            bw.write(T.BFS(i,n,m));
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
