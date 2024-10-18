package y2024.Oct.Oct_18;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
public class programmers_17680 {
    public int solution(int cacheSize, String[] cities) {
        final int HIT = 1;
        final int MISS = 5;

        int answer = 0;

        if(cacheSize==0){
            answer=MISS*cities.length;
            return answer;
        }

        LinkedList<String> cache = new LinkedList<>();
        for(int i =0;i<cities.length;i++){
            String lowerCity = cities[i].toLowerCase();

            if(cache.remove(lowerCity)){
                answer+=HIT;
            } else {
                answer+=MISS;
                if(cache.size()==cacheSize){
                    cache.removeLast();
                }
            }
            cache.addFirst(lowerCity);
        }
        return answer;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int cacheSize = Integer.parseInt(br.readLine());
        String[] cities = br.readLine().replace("[","").replace("]","").split(",");

        programmers_17680 T = new programmers_17680();
        bw.write(String.valueOf(T.solution(cacheSize,cities)));
        bw.flush();
        bw.close();
        br.close();
    }
}
