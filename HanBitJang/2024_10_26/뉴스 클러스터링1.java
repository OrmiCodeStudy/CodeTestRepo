import java.util.ArrayList;
// 정답률 61.5
// AB, AB, CD / AB, EF가 있다면 교집합 1이 아니라 2로 계산됨
class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        ArrayList<String> arr1 = new ArrayList<>();
        ArrayList<String> arr2 = new ArrayList<>();

        for(int i = 0; i < str1.length() - 1; i++) {
            char c1 = str1.charAt(i);
            char c2 = str1.charAt(i + 1);

            if(Character.isAlphabetic(c1) && Character.isAlphabetic(c2)) {
                arr1.add(str1.substring(i, i+2).toUpperCase());
            }
        }

        for(int i = 0; i < str2.length() - 1; i++) {
            char c1 = str2.charAt(i);
            char c2 = str2.charAt(i + 1);

            if(Character.isAlphabetic(c1) && Character.isAlphabetic(c2)) {
                arr2.add(str2.substring(i, i+2).toUpperCase());
            }
        }

        // 자카드 유사도 = 교집합 크기 / 합집합 크기
        double interNum = 0;
        double unionNum = 0;

        for(int i = 0; i < arr1.size(); i++) {
            if (arr2.contains(arr1.get(i))) {
                interNum++;
            }
        }

        unionNum = arr1.size() + arr2.size() - interNum;


        if(unionNum == 0) {
            answer = 65536;
        } else {
            answer = (int) Math.floor(interNum / unionNum * 65536);
        }

        return answer;
    }
}