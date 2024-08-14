package y2024.Aug.Aug_10;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class beakjoon_베스트셀러 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        HashMap<String,Integer> bookCntMap = new HashMap<>();

        for(int i =0;i<n;i++){
            String bookName = br.readLine();

            if(bookCntMap.containsKey(bookName)){
                int newValue = bookCntMap.get(bookName)+1;
                bookCntMap.replace(bookName,newValue);
            } else {
                bookCntMap.put(bookName,1);
            }
        }

        TreeMap<String, Integer> sortedMap = new TreeMap<>(bookCntMap);

        int maxValue=Integer.MIN_VALUE;
        String answer = "";
        for(Map.Entry<String, Integer> entry: sortedMap.entrySet()){
            String key = entry.getKey();
            int value = entry.getValue();

            if(maxValue<value){
                maxValue=value;
                answer = key;
            }
        }
        bw.write(answer);

        br.close();
        bw.flush();
        bw.close();
    }
}
