package Jul_12;
/*
picks : dia,iron,stone
minerals : 제공되는 광물의 배열
곡괭이 : 광물을 5개 캐면 소진
종료조건 : 곡괭이를 다 소진하거나, 광물을 다 캔 경우
종료시 기록된 최소 피로도를 출력

1. 곡괭이의 갯수를 파악해 minerals를 캘 수 있는 범위까지만 설정
2. mineral을 5개씩 나눠서 diamond의 갯수에 *25 / iron의 갯수에 * 5 / stone의 갯수에 * 1 을해 합산한 점수가 높은 곳에 좋은 곡괭이를 우선적으로 배치
3. 해당 경우의 피로도 합계를 계산해 출력
*/

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Arrays;

public class programmers_광물캐기 {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        int fatigue = 0;
        int chunkSize = 5;

        String[] newMinerals = adjustMinerals(picks,minerals);

        List<LinkedList<String>> result = splitArrayToChunks(newMinerals, chunkSize);
        List<Integer> scoreList = new ArrayList<>();

        for(List<String> chunk: result){
            int diamondCnt=0,ironCnt=0,stoneCnt=0;
            for(String element: chunk) {
                switch(element) {
                    case "diamond":
                        diamondCnt++;
                        break;
                    case "iron":
                        ironCnt++;
                        break;
                    case "stone":
                        stoneCnt++;
                        break;
                }
            }
            int score = diamondCnt*25+ironCnt*5+stoneCnt;
            scoreList.add(score);
        }

        System.out.println(scoreList);

        return answer;
    }
    // 광물을 5개씩 나눠서 리스트에 저장
    List<LinkedList<String>> splitArrayToChunks(String[] array, int chunkSize) {
        List<LinkedList<String>> chunks = new LinkedList<>();

        for (int i = 0; i < array.length; i += chunkSize) {
            LinkedList<String> chunk = new LinkedList<>();
            for (int j = 0; j < chunkSize && i + j < array.length; j++) {
                chunk.add(array[i + j]);
            }
            chunks.add(chunk);
        }

        return chunks;
    }
    // minerals를 캘 수 있는 만큼만 나오게 변환
    String[] adjustMinerals(int[] picks, String[] minerals){
        int pickSum = 0;
        for(int pick:picks){
            pickSum+=pick;
        }
        int mineralMaxLength = pickSum*5;

        if(mineralMaxLength < minerals.length){
            return Arrays.copyOf(minerals, mineralMaxLength);
        } else {
            return minerals;
        }
    }

    //최대값을 가지는 요소에 넣을 수 있는 가장 좋은 곡괭이를 배치하는 함수

}