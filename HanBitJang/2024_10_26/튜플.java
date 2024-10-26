
import java.util.Arrays;
import java.util.Comparator;
import java.util.ArrayList;

class Solution {
    public ArrayList<Integer> solution(String s) {
        // s에 담긴 집합을 길이가 짧은 순서대로 정렬해보자

        ArrayList<Integer> answer = new ArrayList<>();

        // 처음의 {, 마지막의 } 제거
        String str1 = s.substring(2, s.length() - 2);

        // },{를 기준으로 분리한 후 요소의 길이가 짧은 순서대로 배열 정렬하기
        String[] str2 = str1.replace("},{", "-").split("-");
        //String[] str2 = str1.split("},\\{");
        Arrays.sort(str2, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.length() - s2.length();
            }
        });


        for(String str : str2) {
            String[] arr = str.split(","); // 정렬된 배열을 ,을 기준으로 분리
            for(String a : arr) {
                int x = Integer.parseInt(a);
                if(!answer.contains(x)) { // 정렬된 배열 내부 정수(문자열 -> 정수)가 tmp에 없는 수라면 포함시키기
                    answer.add(x);
                }
            }
        }
        return answer;
    }
}
