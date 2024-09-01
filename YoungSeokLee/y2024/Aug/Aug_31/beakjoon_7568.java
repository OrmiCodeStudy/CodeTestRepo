package y2024.Aug.Aug_31;

import java.io.*;
import java.util.StringTokenizer;

/*
더 큰 덩치의 사람의 수를 저장
x>y a>b 인 경우에만 덩치가 더 크다
덩치 점수가 0이면 1등
그 다음으로 작으면 2등
....
 */
public class beakjoon_7568 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer stk;

        int[] weight = new int[n];
        int[] height = new int[n];

        for(int i =0;i<n;i++){
            stk= new StringTokenizer(br.readLine());
            weight[i] = Integer.parseInt(stk.nextToken());
            height[i] = Integer.parseInt(stk.nextToken());
        }

        int[] rank = new int[n];

        for(int i=0;i<n;i++){
            rank[i] =1;
            for(int j=0;j<n;j++){
                if(weight[j]>weight[i] && height[j]>height[i]){
                    rank[i]++;
                }
            }
            bw.write(rank[i]+" ");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
