package y2024.Oct.Oct_01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/*
회의실 배정 - 실버1

한개의 회의실이 있는데 이를 사용하고자 하는 N개의 회의에 대하여 회의실 사용표를 만들려고 한다
각 회의 I에 대해 시작시간과 끝나는 시간이 주어지고
각 회의가 겹치지 않게 하면서 회의실을 사용할 수 있는 회의의 최대 개수를 찾아라

N : 회의의 수
 */
class meeting implements Comparable<meeting>  {
    int start;
    int end;

    meeting(int start, int end){
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(meeting o) {
        if (this.end != o.end) {
            return Integer.compare(this.end, o.end);
        } else {
            return Integer.compare(this.start, o.start);
        }
    }
}

public class beakjoon_1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        ArrayList<meeting> meetingList = new ArrayList<>();

        StringTokenizer stk;
        for(int i =0;i<n;i++){
            stk = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(stk.nextToken());
            int end = Integer.parseInt(stk.nextToken());

            meetingList.add(new meeting(start,end));
        }
        Collections.sort(meetingList);

        int cnt = 0;
        int endTime = 0;
        for(int i =0;i<n;i++){
            int startTime = meetingList.get(i).start;
            if(endTime<=startTime){
                endTime = meetingList.get(i).end;
                cnt++;
            }
        }

        bw.write(String.valueOf(cnt));
        bw.flush();
        bw.close();
        br.close();
    }
}
