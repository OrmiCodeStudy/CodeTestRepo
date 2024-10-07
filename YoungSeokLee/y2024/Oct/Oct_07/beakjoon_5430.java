package y2024.Oct.Oct_07;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Iterator;

/*
AC - 골드 5

AC는 정수 배열에 연산을 하기 위해 만든 언어

두가지 함수가 있다
R : 배열에 있는 수의 순서를 뒤집는 함수
D : 첫번째 수를 버리는 함수

단순 구현일듯
D를 기준으로 앞에 온 R의 갯수가 짝수이면 유지 홀수이면 R연산 수행

 */
public class beakjoon_5430 {

    String operation(char[] command, ArrayDeque<Integer> numArr) {

        boolean isR = false;

        for (char c : command) {
            if (c == 'R') {
                isR = !isR;
            }

            if (c == 'D') {
                if (numArr.isEmpty()) {
                    return "error";
                }

                if (isR) {
                    numArr.pollLast();
                } else {
                    numArr.pollFirst();
                }
            }
        }

        int finalArrSize = numArr.size();

        StringBuilder sb = new StringBuilder("[");
        if (!numArr.isEmpty()) {
            Iterator<Integer> it = isR ? numArr.descendingIterator() : numArr.iterator();
            sb.append(it.next());
            while (it.hasNext()) {
                sb.append(",").append(it.next());
            }
        }
        return sb.append("]").toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            char[] command = br.readLine().toCharArray();
            int n = Integer.parseInt(br.readLine());
            String inputArr = br.readLine();
            String[] numbers = inputArr.substring(1, inputArr.length() - 1).split(",");
            ArrayDeque<Integer> numArr = new ArrayDeque<>();
            for (String num : numbers) {
                if (!num.trim().isEmpty()) {
                    numArr.add(Integer.parseInt(num.trim()));
                }
            }
            beakjoon_5430 T = new beakjoon_5430();
            bw.write(T.operation(command, numArr) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}