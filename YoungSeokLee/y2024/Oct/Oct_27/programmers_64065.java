package y2024.Oct.Oct_27;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/*
튜플

셀수있는 수량의 순서있는 열거

성질
1. 중복된 원소 가능
2. 원소에 순서가 있으며, 순서가 다르면 서로 다른 튜플
3. 튜플의 원소 개수는 유한하다.

특정 튜플을 표현하는 집합이 담긴 문자열 s가 매개변수로 주어질 때, s가 표현하ㅡㄴ 튜플을 배열에 담아 return 하라
 */
public class programmers_64065 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        s = s.substring(1,s.length()-1);
        String[] tempStrings = s.split("},*");

        ArrayList<int[]> inputArr = new ArrayList<>();
        for(String str:tempStrings){
            int[] numArr = Arrays.stream(str.replace("{", "").replace("}", "").split(",")).mapToInt(Integer::parseInt).toArray();
            inputArr.add(numArr);
        }

        inputArr.sort(Comparator.comparingInt(arr -> arr.length));

        ArrayList<Integer> ansArr = new ArrayList<>();
        for (int[] arr : inputArr) {
            for(int num:arr) {
                if(!ansArr.contains(num)){
                    ansArr.add(num);
                    break;
                }
            }
        }

        int[] answer = new int[ansArr.size()];
        for (int i = 0; i < ansArr.size(); i++) {
            answer[i] = ansArr.get(i);
        }
    }
}
