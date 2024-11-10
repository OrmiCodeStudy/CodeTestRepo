import java.util.*;

public class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> totalTimeMap = new HashMap<>();  // 차량 번호별 누적 주차 시간
        Map<String, String> inTimeMap = new HashMap<>();  // 차량 번호별 입차 시간

        for (String record : records) {
            String[] parts = record.split(" ");
            String time = parts[0];
            String carNumber = parts[1];
            String action = parts[2];

            if (action.equals("IN")) {
                inTimeMap.put(carNumber, time);
            } else if (action.equals("OUT")) {
                int parkedTime = calculateTime(inTimeMap.get(carNumber), time);
                totalTimeMap.put(carNumber, totalTimeMap.getOrDefault(carNumber, 0) + parkedTime);
                inTimeMap.remove(carNumber);  // 출차 처리 완료 후 제거
            }
        }

        // 출차 기록이 없는 차량은 23:59에 출차한 것으로 간주해서 주차 시간 계산
        for (String carNumber : inTimeMap.keySet()) {
            int parkedTime = calculateTime(inTimeMap.get(carNumber), "23:59");
            totalTimeMap.put(carNumber, totalTimeMap.getOrDefault(carNumber, 0) + parkedTime);
        }

        // 차량 번호순으로 정렬해 요금 계산
        List<String> carNumbers = new ArrayList<>(totalTimeMap.keySet());
        Collections.sort(carNumbers);

        int[] answer = new int[carNumbers.size()];
        for (int i = 0; i < carNumbers.size(); i++) {
            String carNumber = carNumbers.get(i);
            int totalTime = totalTimeMap.get(carNumber);
            answer[i] = calculateFee(fees, totalTime);
        }

        return answer;
    }

    // 주차 요금을 계산하는 함수
    private int calculateFee(int[] fees, int time) {
        int baseTime = fees[0];
        int baseFee = fees[1];
        int unitTime = fees[2];
        int unitFee = fees[3];

        if (time <= baseTime) {
            return baseFee;
        } else {
            return baseFee + (int) Math.ceil((time - baseTime) / (double) unitTime) * unitFee;
        }
    }

    // 주차 시간을 계산하는 함수
    private int calculateTime(String inTime, String outTime) {
        String[] inParts = inTime.split(":");
        String[] outParts = outTime.split(":");

        int inHours = Integer.parseInt(inParts[0]);
        int inMinutes = Integer.parseInt(inParts[1]);
        int outHours = Integer.parseInt(outParts[0]);
        int outMinutes = Integer.parseInt(outParts[1]);

        return (outHours * 60 + outMinutes) - (inHours * 60 + inMinutes);
    }
}
