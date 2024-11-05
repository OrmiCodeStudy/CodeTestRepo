package y2024.Nov.Nov_05;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
거짓말 - 골드4

진실을 아는 사람이 파티에 왔으면 진실을 이야기 해야한다
한 사람이 어떤 파티에서 진실을 듣고 다른 파티에서 거짓말을 들으면 거짓말쟁이로 알려지게 된다.

N : 전체 사람 수
M : 파티의 수

지민이가 거짓말쟁이로 알려지지 않으면서 과장된 이야기를 할 수 있는 파티의 개수의 최댓값을 구하라

풀이

파티의 모든 참가자의 isTruthKnower이 false라면 cnt++

반례

4 3
1 1
2 3 4
2 2 3
2 1 2
1
(0이 나와야 함)
 */
public class beakjoon_1043 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        stk = new StringTokenizer(br.readLine());
        int lierNum = Integer.parseInt(stk.nextToken());

        boolean[] isTruthKnower = new boolean[n+1];
        for(int i =0;i<lierNum;i++){
            int num = Integer.parseInt(stk.nextToken());
            isTruthKnower[num]=true;
        }

        List<List<Integer>> parties = new ArrayList<>();
        boolean[] isTruthParty = new boolean[m];
        for(int i =0;i<m;i++){
            stk = new StringTokenizer(br.readLine());
            int personNum = Integer.parseInt(stk.nextToken());
            parties.add(new ArrayList<>());
            for(int j=0;j<personNum;j++){
                int participant = Integer.parseInt(stk.nextToken());
                parties.get(i).add(participant);
                if(isTruthKnower[participant]){
                    isTruthParty[i]=true;
                }
            }
            if(isTruthParty[i]){
                for(int participant:parties.get(i)){
                    isTruthKnower[participant]=true;
                }
            }
        }

        int cnt = m;
        for(List<Integer> party: parties){
            for(int participant:party){
                if(isTruthKnower[participant]){
                    cnt--;
                    break;
                }
            }
        }

        bw.write(String.valueOf(cnt));
        bw.flush();
        bw.close();
        br.close();
    }
}
