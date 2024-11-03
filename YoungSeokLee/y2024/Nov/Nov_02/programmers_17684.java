package y2024.Nov.Nov_02;

import java.io.*;
import java.util.*;

/*
압축

lzw 압축
1. 길이가 1인 모든 단어를 포함하도록 사전을 초기화
2. 사전에서 현재 입력과 일치하는 가장 긴 문자열 w를 찾는다
3. w에서 해당하는 사전의 색인 번호를 출력하고, 입력에서 w를 제거한다
4. 입력에서 처리되지 않은 다음 글자(c)가 남아있다면, w+c에 해당하는 단어를 사전에 등록한다
5. 단계2로 돌아간다.

영문의 대문자만 처리

주어진 문자열을 압축한 후의 사전 색인 번호를 배열로 출력하라

사전을 순회하면서 key값이 가장 긴 매치를 구한다
 */
public class programmers_17684 {

    static Map<String, Integer> dict;

    static int[] solution(String inputStr) {
        ArrayList<Integer> outArr = new ArrayList<>();
        int maxIdx = 26;

        while (!inputStr.isEmpty()) {
            List<Map.Entry<String, Integer>> sortedEntries = new ArrayList<>(dict.entrySet());
            sortedEntries.sort((e1, e2) -> Integer.compare(e2.getKey().length(), e1.getKey().length()));

            for (Map.Entry<String, Integer> entry : sortedEntries) {
                String key = entry.getKey();
                int value = entry.getValue();

                int keyLen = key.length();
                if (inputStr.length() >= keyLen && inputStr.substring(0, keyLen).equals(key)) {
                    ++maxIdx;
                    outArr.add(value);
                    if(inputStr.length()>keyLen){
                        dict.put(inputStr.substring(0, keyLen + 1), maxIdx);
                        inputStr = inputStr.substring(keyLen);
                    } else {
                        inputStr="";
                    }
                    break;
                }
            }
        }

        return outArr.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        dict = new HashMap<>();

        for (int i = 1; i <= 26; i++) {
            String value = String.valueOf((char) (i + 64));
            dict.put(value, i);
        }

        String inputStr = br.readLine();

        bw.write(Arrays.toString(solution(inputStr)));
        bw.flush();
        bw.close();
        br.close();
    }
}
