import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public String[] solution(String[] record) {

        String[] answer = {};
        ArrayList<String[]> newRecord = new ArrayList<>();
        HashMap<String, String> nickMap = new HashMap<String, String>();

        for(String data:record){
            String[] dataList = data.split(" ",3);
            newRecord.add(dataList);
        }

        for(String[] dataArray:newRecord){
            if(dataArray[0].equals("Enter")){
                if(nickMap.isEmpty() || !nickMap.containsKey(dataArray[1])){
                    nickMap.put(dataArray[1],dataArray[2]);
                } else {
                    nickMap.replace(dataArray[1],dataArray[2]);
                }
            } else if (dataArray[0].equals("Change")){
                nickMap.replace(dataArray[1],dataArray[2]);
            }
        }

        for(String[] dataArray:newRecord){
            String newElement=null;
            if (dataArray[0].equals("Enter")){
                newElement = nickMap.get(dataArray[1]) + "님이 들어왔습니다.";
            } else if (dataArray[0].equals("Leave")){
                newElement = nickMap.get(dataArray[1]) + "님이 나갔습니다.";
            } else {
                continue;
            }

            String[] newArray = Arrays.copyOf(answer, answer.length + 1);
            newArray[answer.length] = newElement;
            answer = newArray;
        }

        return answer;
    }
}