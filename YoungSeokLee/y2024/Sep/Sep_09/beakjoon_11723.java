package y2024.Sep.Sep_09;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class beakjoon_11723 {
    static HashSet<Integer> s = new HashSet<>();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static void solution(String inputVal) throws IOException {
        StringTokenizer stk = new StringTokenizer(inputVal);
        String order = stk.nextToken();
        int value;

        switch (order){
            case "add":
                value = Integer.parseInt(stk.nextToken());
                s.add(value);
                break;
            case "remove":
                value = Integer.parseInt(stk.nextToken());
                s.remove(value);
                break;
            case "check":
                value = Integer.parseInt(stk.nextToken());
                String answer = s.contains(value)?"1":"0";
                bw.write(answer+"\n");
                break;
            case "toggle":
                value = Integer.parseInt(stk.nextToken());
                if(s.contains(value)){
                    s.remove(value);
                } else {
                    s.add(value);
                }
                break;
            case "all":
                s.clear();
                for(int i=1;i<=20;i++)
                    s.add(i);
                break;
            case "empty":
                s.clear();
                break;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for(int i =0;i<n;i++){
            solution(br.readLine());
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
