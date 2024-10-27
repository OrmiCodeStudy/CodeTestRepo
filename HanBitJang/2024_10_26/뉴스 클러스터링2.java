import java.util.ArrayList;

// ArrayList, HashMap 사용 답안

class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        ArrayList<String> arr1 = new ArrayList<>();
        ArrayList<String> arr2 = new ArrayList<>();

        // str1의 유효한 쌍 개수 세기
        for(int i = 0; i < str1.length() - 1; i++) {
            char c1 = str1.charAt(i);
            char c2 = str1.charAt(i + 1);

            if(Character.isAlphabetic(c1) && Character.isAlphabetic(c2)) {
                arr1.add(str1.substring(i, i+2).toUpperCase());
            }
        }

        // str2의 유효한 쌍 개수 세기
        for(int i = 0; i < str2.length() - 1; i++) {
            char c1 = str2.charAt(i);
            char c2 = str2.charAt(i + 1);

            if(Character.isAlphabetic(c1) && Character.isAlphabetic(c2)) {
                arr2.add(str2.substring(i, i+2).toUpperCase());
            }
        }

        // 자카드 유사도 = 교집합 크기 / 합집합 크기
        double interNum = 0;
        double unionNum = arr1.size() + arr2.size();

        // 교집합을 저장하는 맵
        HashMap<String, Integer> countMap1 = new HashMap<>();
        HashMap<String, Integer> countMap2 = new HashMap<>();

        // arr1에서 각 원소의 발생 횟수 계산
        for(String str : arr1) {
            countMap1.put(str, countMap1.getOrDefault(str, 0) + 1);
        }

        // arr2에서 각 원소의 발생 횟수 계산
        for(String str : arr2) {
            countMap2.put(str, countMap2.getOrDefault(str, 0) + 1);
        }

        // 교집합 크기 계산
        for(String key : countMap1.keySet()) {
            if(countMap2.containsKey(key)) {
                interNum += Math.min(countMap1.get(key), countMap2.get(key));
            }
        }

        // 합집합 크기 계산
        unionNum = arr1.size() + arr2.size() - interNum;

        // 자카드 유사도 계산
        if(unionNum == 0) {
            answer = 65536;
        } else {
            answer = (int) Math.floor(interNum / unionNum * 65536);
        }

        return answer;
    }
}