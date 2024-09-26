package y2024.Sep.Sep_26;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
나무 자르기 - 실버2

N : 나무의 수
M : 집으로 가져가려는 나무의 길이

나무의 높이의 합은 항상 M보다 크거나 같다

절단기에 높이 h를 설정하면 톱날이 땅으로부터 h미터 위로 올라간다
한줄에 연속해있는 나무를 모두 절단한다.

적어도 m미터의 나무를 집에 가져가기 위해 절단기에 설정할 수 있는 높이의 최댓값을 구하라.

tree[n]-h 의 합 >= M

각 나무를 높이 순으로 정렬한 뒤, 크기가 큰 나무를 기준으로 결과를 계산해본다.
k번째 나무의 높이를 기준으로 자른경우에 결과가 n을 초과한다면, 역으로 계산해 얼마나 올릴 수 있는지 구할 수 있다.

결과 +=(결과 - n)/(m-k)
 */
public class beakjoon_2805_my {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(stk.nextToken());
        int n = Integer.parseInt(stk.nextToken());

        long[] tree = new long[m+1];
        long maxHeight = Integer.MIN_VALUE;
        stk = new StringTokenizer(br.readLine());
        for(int i =1;i<=m;i++){
            tree[i]=Integer.parseInt(stk.nextToken());
            if(maxHeight<tree[i])
                maxHeight = tree[i];
        }
        Arrays.sort(tree);

        int totalHeight = 0;
        long answer = 0;
        for(int i=m;i>=0;i--){
            totalHeight = 0;
            for(int j =i;j<=m;j++){
                totalHeight+=tree[j]-tree[i];
            }
            if(totalHeight>=n){
                answer = tree[i];
                answer += (totalHeight-n)/(m-i);
                break;
            }
        }

        bw.write(answer+"");
        bw.flush();
        bw.close();
        br.close();
    }
}
