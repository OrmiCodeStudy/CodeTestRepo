package y2024.Sep.Sep_30;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
과일 탕후루 - 실버2

N개의 과일이 꽂혀있는 과일 탕후루가 있다

각 과일의 종류에는 1~9까지 번호가 붙어있고,
과일을 두종류 이하로 사용해달라는 요청

막대의 앞과 뒤쪽에서 몇개의 과일을 빼서 두종류 이하의 과일만 남기기로 했다.

과일을 두종류 이하로 사용한 탕후루 중에서 과일의 개수가 가장 많은 탕후루의 과일 개수를 구하라

1. 과일을 종류가 2보다 작은지 확인
2. 종류가 2보다 많으면 a 또는 b를 증가시켜 다시 확인
3. 2보다 작으면 반환

슬라이딩 윈도우를 통해 해결 가능
start : 종류가 2보다 커지면 증가
end : 종류가 2보다 작거나 같을때 증가

종류가 2일때 과일 숫자의 최대값을 저장
 */
public class beakjoon_30804 {

    int slideWindow(int[] tangHuru, int start, int end) {

        int maxFruit = Integer.MIN_VALUE;
        int fruitCnt = 0;
        int[] cnt = new int[10];

        while (end < tangHuru.length) {
            if (cnt[tangHuru[end]] == 0) {
                fruitCnt++;
            }
            cnt[tangHuru[end]]++;

            while (fruitCnt > 2) {
                cnt[tangHuru[start]]--;
                if (cnt[tangHuru[start]] == 0) {
                    fruitCnt--;
                }
                start++;
            }

            maxFruit = Math.max(maxFruit, end - start + 1);
            end++;
        }

        return maxFruit;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] tangHuru = new int[n];

        StringTokenizer stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int fruit = Integer.parseInt(stk.nextToken());
            tangHuru[i] = fruit;
        }

        beakjoon_30804 T = new beakjoon_30804();
        bw.write(T.slideWindow(tangHuru, 0, 0) + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
