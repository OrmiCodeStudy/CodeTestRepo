import java.util.HashMap;
import java.util.Map;
class Solution {
    public String[] solution(String[] record) {
        HashMap<String, String> map = new HashMap<>(); // 유저 아이디, 닉네임 쌍 저장
        int cnt = 0;
        int idx = 0;

        String ENT = "Enter";
        String LV = "Leave";
        String CNG = "Change";

        for(int i = 0; i < record.length; i++) {
            String[] arr = record[i].split(" ");

            if(arr[0].equals(ENT)) {
                map.put(arr[1], arr[2]);
            } else if(arr[0].equals(LV)) {
                continue;
            } else if(arr[0].equals(CNG)) {
                map.put(arr[1], arr[2]);
                cnt++;
            }
        }

        String[] answer = new String[record.length - cnt]; // 결과 -> Change 명령어 포함 x

        for(int i = 0; i < record.length; i++) {
            String[] arr = record[i].split(" ");
            String nickname = map.get(arr[1]);

            if(arr[0].equals(ENT)) {
                answer[idx++] = nickname + "님이 들어왔습니다.";
            } else if(arr[0].equals(LV)) {
                answer[idx++] = nickname + "님이 나갔습니다.";
            }
        }


        return answer;
    }
}