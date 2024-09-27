package y2024.Sep.Sep_27;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
마인크래프트 - 실버2

집터 맨 왼쪽 위의 좌표 : (0,0)
세로 N, 가로 M 크기의 집터를 고르고, 집터 내의 땅의 높이를 일정하게 바꾸는 것
B : 작업을 시작할 때 가지고 있는 블록
땅 높이의 최대치 : 256
땅 높이의 최소치 : 0

할 수 있는 작업
1. 좌표 (i,j)의 가장 위에 있는 블록을 제거하여 인벤토리에 넣는다 (2초)
2. 인벤토리에서 블록하나를 꺼내서 (i,j)의 가장 위에 있는 블록 위에 놓는다. (1초)

땅 고르기 작업에 걸리는 최소 시간과 그 경우 땅의 높이를 출력하라
 */
public class beakjoon_18111 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());
        int inven = Integer.parseInt(stk.nextToken());

        int[][] ground = new int[n][m];
        int maxDirt = 0;
        int minDirt = 256;
        int totalDirt = 0;

        for(int i =0;i<n;i++){
            stk = new StringTokenizer(br.readLine());
            for(int j =0;j<m;j++){
                ground[i][j] = Integer.parseInt(stk.nextToken());
                totalDirt+=ground[i][j];
                if(maxDirt<ground[i][j])
                    maxDirt = ground[i][j];
                if(minDirt>ground[i][j])
                    minDirt = ground[i][j];
            }
        }

        int minTime = Integer.MAX_VALUE;
        int targetHeight = 0;
        for(int height =maxDirt;height>=minDirt;height--){
            int targetDirt = height*n*m;
            int usableDirt = inven+totalDirt;
            if(targetDirt>usableDirt)
                continue;

            int currTime=0;
            for(int i =0;i<n;i++){
                for(int j =0;j<m;j++){
                    int heightDiff = height-ground[i][j];
                    currTime+=heightDiff>=0?heightDiff:-heightDiff*2;
                }
            }

            if(currTime<minTime){
                minTime = currTime;
                targetHeight = height;
            }
        }

        bw.write(minTime+" "+targetHeight+"\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
