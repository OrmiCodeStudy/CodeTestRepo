package y2024.Sep.Sep_25;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/*
잃어버린 괄호 - 실버2

양수와 + - 로 식을 입력받고
괄호를 적절히 사용해 식의 값을 최소로 만들어라

-인 경우 : 뒤의 수를 최대한 크게 만들어야 한다
 */
public class beakjoon_1541 {

    int solution(String[] minusEquation) {
        int sumVal = 0;
        for (int i = 0; i < minusEquation.length; i++) {
            String equation = minusEquation[i];
            int tempSum = 0;
            int[] plusEquation = Arrays.stream(equation.split("\\+")).mapToInt(Integer::parseInt).toArray();

            for (int num : plusEquation) {
                tempSum += num;
            }
            if (i == 0) {
                sumVal += tempSum;
            } else {
                sumVal -= tempSum;
            }
        }

        return sumVal;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] minusEquation = br.readLine().split("-");

        beakjoon_1541 T = new beakjoon_1541();

        bw.write(T.solution(minusEquation) + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
