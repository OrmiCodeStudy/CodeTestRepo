package y2024.Oct.Oct_03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
카잉 달력 - 실버1

M과 N보다 작거나 같은 두개의 자연수 X,Y를 가지고 각 년도를 <X:Y>같은 형식으로 표현

첫번째 해 : <1:1>
두번째 해 : <2:2>
X<M 이면 X'=X+1
아니면 X'=1
Y<N 이면 Y'=Y+1
아니면 Y'=1
<M:N> : 달력의 마지막 해

M:N 과 X:Y가 주어질때 X:Y가 몇번째 해인지 출력하라

n과 m의 최소공배수 : 마지막 해까지의 햇수
둘중 더 작은 숫자로 후보군을 추린다
후보군 : 둘중 더 작은 숫자 * i + x or y <= 최소공배수
해당 후보군을 다른 숫자의 배수+나머지로 대입해봤을때 존재한다면 cnt 출력
아니면 -1 출력
 */
public class beakjoon_6064 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        StringTokenizer stk;
        for(int i =0;i<t;i++){
            stk = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(stk.nextToken());
            int n = Integer.parseInt(stk.nextToken());
            int x = Integer.parseInt(stk.nextToken());
            int y = Integer.parseInt(stk.nextToken());

            bw.write(calendar(m,n,x,y)+"\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static int lcm(int a, int b) {
        return Math.abs(a * b) / gcd(a, b);
    }

    // 최대공약수 계산 메서드 (유클리드 호제법)
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static int calendar(int m, int n, int x, int y) {
        int lcm = lcm(m,n);
        x--;
        y--;

        int currNum = 0;
        for(int i =x;i<lcm;i+=m){
            if(i%n==y)
                return i+1;
        }

        return -1;
    }
}
