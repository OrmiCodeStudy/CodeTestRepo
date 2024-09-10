package y2024.Sep.Sep_10;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.StringTokenizer;

/*
듣보잡

김진영이 듣도 못한 사람의 명단과
보도 못한 사람의 명단이 주어질때
듣도 보도 못한 사람의 명단을 구하는 프로그램을 작성하라

 */
public class beakjoon_1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        String[] notHear = new String[n];
        HashMap<String,Integer> notSeen = new HashMap<>();

        for(int i =0;i<n;i++){
            notHear[i]=br.readLine();
        }

        for(int i =0;i<m;i++){
            notSeen.put(br.readLine(),i);
        }

        ArrayList<String> notHearSeen = new ArrayList<>();
        for(String person:notHear){
            if(notSeen.getOrDefault(person,-1)!=-1){
                notHearSeen.add(person);
            }
        }
        notHearSeen.sort(Comparator.naturalOrder());
        bw.write(notHearSeen.size()+"\n");
        for(String person: notHearSeen){
            bw.write(person+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
