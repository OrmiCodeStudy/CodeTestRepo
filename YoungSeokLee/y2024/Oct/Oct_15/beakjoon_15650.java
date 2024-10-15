package y2024.Oct.Oct_15;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

/*
N과 M (2) - 실버3

자연수N과 M이 주어졌을때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하라

- 1부터 N까지 자연수 중에서 중복없이 M개를 고른 수열
- 고른 수열은 오름차순이어야 한다

이전에 선택된 숫자보다 큰 숫자만 선택 가능

 */

class combination{
    int currNum;
    int len;
    String combi;

    public combination(int currNum, int len, String combi){
        this.currNum = currNum;
        this.len = len;
        this.combi = combi;
    }
}
public class beakjoon_15650 {
    String DFS(int start,int n,int m){

        StringBuilder sb = new StringBuilder();

        Stack<combination> s = new Stack<>();
        s.push(new combination(start,1,String.valueOf(start)));

        while(!s.isEmpty()){
            combination curr = s.pop();
            if(curr.len == m)
                sb.append(curr.combi).append("\n");

            if(curr.len<m) {
                for(int i =n-1;i>=curr.currNum;i--){
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
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        beakjoon_15650 T = new beakjoon_15650();

        for(int i =1;i<=n-m+1;i++){
            bw.write(T.DFS(i,n,m));
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
