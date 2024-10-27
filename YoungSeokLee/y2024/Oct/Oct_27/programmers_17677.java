package y2024.Oct.Oct_27;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/*
뉴스 클러스터링

자카드 유사도 : 집합간의 유사도를 검사하는 방법
J(A,B) = 두 집합의 교집합 크기를 두 집합의 합집합 크기로 나눈 값

- 문자열을 두 글자씩 끊어서 다중 집합의 원소로 만든다
- 영문자로만 이루어진 글자 쌍만 유지
- 대소문자 무시 (한가자로 통일)

입력으로 들어온 두 문자열의 자카드 유사도에 65536을 곱하고 정수부만 출력하라

풀이

문자열을 소문자로 통일 후, 한 글자씩 window를 이동시키며 집합을 생성
해당 문자열이 전부 영문자인 경우, 소문자 처리 후 집합에 추가

HashSet으로 집합 구현
Key : 특정 문자열
value : 해당 요소의 개수

합집합 : 두 set들을 순회하면서, 새로운 set을 만든다. 공통 key 값이 있다면 더 큰쪽 value만 저장한다.
교집합 : 두 set들의 공통 key 값를 구하고, 둘중 더 작은 쪽의 value들을 합한다.
 */
public class programmers_17677 {
    public static boolean isAlphabetic(String str) {
        return str.matches("^[a-zA-Z]*$");
    }

    public static int solution(String str1, String str2){
        int answer = 0;

        Map<String,Integer> s1 = new HashMap<>();
        Map<String,Integer> s2 = new HashMap<>();

        for(int i=0;i<str1.length()-1;i++){
            String candidateStr = str1.substring(i,i+2);
            if(isAlphabetic(candidateStr)){
                candidateStr = candidateStr.toLowerCase();
                s1.put(candidateStr,s1.getOrDefault(candidateStr,0)+1);
            }
        }
        for(int i=0;i<str2.length()-1;i++){
            String candidateStr = str2.substring(i,i+2);
            if(isAlphabetic(candidateStr)){
                candidateStr = candidateStr.toLowerCase();
                s2.put(candidateStr,s2.getOrDefault(candidateStr,0)+1);
            }
        }

        int union = 0;
        Map<String, Integer> s3 = new HashMap<>(s1);
        int intersection = 0;
        for(Map.Entry<String,Integer> entry : s2.entrySet()) {
            String key = entry.getKey();
            int value = entry.getValue();
            if(s1.containsKey(key)){
                int minVal = Math.min(s1.get(key),value);
                int maxVal = Math.max(s1.get(key),value);
                s3.put(key,maxVal);
                intersection+=minVal;
            } else {
                s3.put(key,value);
            }
        }
        for(int value:s3.values())
            union+=value;

        if(union==0)
            return 65536;

        answer = 65536*intersection/union;
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str1 = br.readLine();
        String str2 = br.readLine();

        bw.write(String.valueOf(solution(str1,str2)));
        bw.flush();
        bw.close();
        br.close();
    }


}
