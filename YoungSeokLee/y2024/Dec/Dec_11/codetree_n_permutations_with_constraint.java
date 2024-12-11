package y2024.Dec.Dec_11;

import java.io.*;
import java.util.*;

/*
1이상 k 이하의 숫자를 고르는 행위를 n번 반복하여 나올 수 있는 모두 다른 순서쌍을 구하는 프로그램

같은 숫자가 연속 3번 이상 나오는 경우는 제외
*/
public class codetree_n_permutations_with_constraint {
    static int k,n;
    static int[] numArr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stk = new StringTokenizer(br.readLine());

        k = Integer.parseInt(stk.nextToken());
        n = Integer.parseInt(stk.nextToken());

        numArr = new int[n];

        backtracking(0);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static void backtracking(int depth){
        if(depth == n){
            for(int num:numArr){
                sb.append(num).append(" ");
            }
            sb.append("\n");

            return;
        }

        for(int i =1;i<=k;i++){
            if(depth>=2){
                if(numArr[depth-2]==i && numArr[depth-1]==i){
                    continue;
                }
            }
            numArr[depth] = i;
            backtracking(depth+1);
        }
    }
}
