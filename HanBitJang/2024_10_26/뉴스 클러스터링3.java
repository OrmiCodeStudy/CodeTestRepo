import java.util.HashMap;
import java.util.ArrayList;

// HashMap 사용 답안

class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();

        // str1의 유효한 쌍 개수 세기
        for(int i = 0; i < str1.length() - 1; i++) {
            char c1 = str1.charAt(i);
            char c2 = str1.charAt(i+1);

            if(Character.isAlphabetic(c1) && Character.isAlphabetic(c2)) {
                String key = str1.substring(i, i+2).toUpperCase();
                map1.put(key, map1.getOrDefault(key, 0) + 1);
            }

        }

        // str2의 유효한 쌍 개수 세기
        for(int i = 0; i < str2.length() - 1; i++) {
            char c1 = str2.charAt(i);
            char c2 = str2.charAt(i+1);

            if(Character.isAlphabetic(c1) && Character.isAlphabetic(c2)) {
                String key = str2.substring(i, i+2).toUpperCase();
                map2.put(key, map2.getOrDefault(key, 0) + 1);
            }
        }

        // 자카드 유사도 = 교집합 크기 / 합집합 크기
        double interNum = 0;
        double unionNum = 0;

        // 교집합의 크기 계산
        for(String key : map1.keySet()) {
            if(map2.containsKey(key)) {
                interNum += Math.min(map1.get(key), map2.get(key));
            }
        }

        // 합집합의 크기 계산
        for(String key : map1.keySet()) {
            unionNum += map1.get(key);
        }

        for(String key : map2.keySet()) {
            unionNum += map2.get(key);
        }

        unionNum -= interNum;

        // 자카드 유사도 계산
        if(unionNum == 0) {
            answer = 65536;
        } else {
            answer = (int) Math.floor(interNum / unionNum * 65536);
        }
        return answer;
    }
}
