package y2024.Nov.Nov_09;

import java.io.*;
import java.util.*;

/*
주차 요금 계산
차량번호가 작은 자동차부터 청구할 주차 요금을 차례대로 정수 배열에 담아서 return 하도록 solution 함수를 완성하라.

- 차량이 입차된 후에 출차된 내역이 없다면 23:59에 출차된것으로 간주
- 00:00부터 23:59 까지의 입/출차 내역을 바탕으로 차량별 누적 주차 시간을 계산하여 요금을 일괄로 정산
- 누적 주차 시간이 기본시간 이하라면, 기본요금을 청구
- 누적 주차시간이 기본 시간을 초과하면, 기본요금에 더해서 초과한 시간에 대해 단위시간마다 단위 요금을 청구
  - 초과시간이 단위 시간으로 나눠떨어지지 않으면 올림
  - [a] : a보다 작지않은 최소의 정수를 의미(올림)

fees : 주차 요금을 나타내는 정수 배열
0: 기본 시간(분)
1: 기본 요금(원)
2: 단위 시간(분)
3: 단위 요금(원)

records : 자동차의 입/출차 내역을 나타내는 문자열 배열(최대길이 : 1000)
양식 : 시각 차량번호 내역
시각 : HH:MM 형식의 길이 5인 문자열
차량번호 : 0~9로 구성된 길이 4인 문자열
내역 : IN/OUT
- 시각을 기준으로 오름차순으로 정렬됨

풀이
1. fees 입력후 저장, record를 읽어 시각,차량번호,내역으로 저장
2. 차량번호를 key로 가지는 map 생성 value : 입차시간
  - IN이면 KEY추가, OUT이면 해당 키로 데이터 조회 후 주차요금 계산
  - 끝까지 OUT이 나오지 않은 경우, 23:59를 기준으로 주차 요금 계산 후, 이차원 배열로 저장
3. 차량 번호 낮은 순으로 배열로 정렬해 return
 */
public class programmers_92341 {
    public static int[] solution(int[] fees, String[] records) {
        int[] answer = {};

        Map<String,String> timeStamp = new HashMap<>();
        ArrayList<int[]> tempAnswer = new ArrayList<>();

        for(String record:records){
            String[] tempRec = record.split(" ");
            if(tempRec[2].equals("IN")){
                timeStamp.put(tempRec[1],tempRec[0]);
            } else {
                int[] inTime = Arrays.stream(timeStamp.remove(tempRec[1]).split(":")).mapToInt(Integer::parseInt).toArray();
                int[] outTime = Arrays.stream(tempRec[0].split(":")).mapToInt(Integer::parseInt).toArray();

                int fee = (inTime[0]-outTime[0])*60+(inTime[1]-outTime[1]);
                tempAnswer.add(new int[]{Integer.parseInt(tempRec[1]),fee});
            }

            while(!timeStamp.isEmpty()){
                for(Map.Entry<String,String> entry:timeStamp.entrySet()){
                    String key = entry.getKey();
                    String value = entry.getValue();
                    timeStamp.remove(key);
                }
            }
        }


        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int[] fees = new int[4];

        for(int i =0;i<4;i++){
            fees[i]=Integer.parseInt(stk.nextToken());
        }

        String[] records = br.readLine().split(", ");

        StringBuilder sb = new StringBuilder("[");
        int[] result = solution(fees,records);
        for(int i =0;i<result.length;i++){
            sb.append(result[i]);
            if(i!=result.length-1){
                sb.append(", ");
            }
        }
        sb.append("]");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
