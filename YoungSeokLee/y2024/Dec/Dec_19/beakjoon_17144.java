package y2024.Dec.Dec_19;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
미세먼지 안녕!

r : 세로길이
c : 가로길이

공기 청정기는 항상 1번 열에 설치되어있고, 두행을 차지

확산 : 인접한 4 방향으로 해당 칸의 미세먼지의 양의 1/5이 이동(소숫점은 버린다)
확산이 끝나고 남은 미세먼지의 양 : 기존 미세먼지 양 - 확산된 미세먼지 양 x (확산된 방향의 개수)

위쪽 공기청정기 : 반시계 방향
아래쪽 공기청정기 : 시계 방향
바람의 방향대로 모두 한 칸씩 이동한다.
공기청정기에서 부는 바람은 미세먼지가 없는 바람이고, 공기청정기로 들어간 미세먼지는 모두 정화됨

풀이
DFS를 통해 T초 처리
1. 미세먼지가 0 또는 -1 이 아니면 확산처리
2. 미세먼지 이동 후 T+1
3. T == 기준시간 이면 종료 후, 미세먼지 총량 계산
 */
public class beakjoon_17144 {
    static private int r,c,t;
    static private int[][] room;
    static private ArrayList<int[]> filterPos;
    static final private int[][] dyx = {{-1,0},{0,1},{1,0},{0,-1}};

    private static int dfs(int time){
        if(time == t){
            int totalDust = 0;
            for(int i =0;i<r;i++){
                for(int j =0;j<c;j++){
                    if(room[i][j]>0){
                        totalDust+=room[i][j];
                    }
                }
            }

            return totalDust;
        }
        spread();
        filter();

        return dfs(time+1);
    }

    private static void spread(){
        int[][] newRoom = new int[r][c];

        for(int i =0;i<r;i++){
            for(int j =0;j<c;j++){
                int dust = room[i][j];
                int moveDust = dust/5;
                if(moveDust>=1){
                    for(int[] newXY:dyx){
                        int newY = i+newXY[0];
                        int newX = j+newXY[1];
                        if(0<=newY && newY<r && 0<=newX && newX<c){
                            if(room[newY][newX]!=-1){
                                newRoom[newY][newX]+=moveDust;
                                room[i][j]-=moveDust;
                            }
                        }
                    }
                }
            }
        }
        for(int i=0;i<r;i++){
            for(int j =0;j<c;j++){
                room[i][j]+=newRoom[i][j];
            }
        }
    }

    private static void filter(){
        // 위쪽 공기청정기
        int[] top = filterPos.get(0);
        int y = top[0];

        // 왼쪽
        for (int i = y - 1; i > 0; i--)
            room[i][0] = room[i-1][0];
        // 위쪽
        for (int j = 0; j < c - 1; j++)
            room[0][j] = room[0][j+1];
        // 오른쪽
        for (int i = 0; i < y; i++)
            room[i][c-1] = room[i+1][c-1];
        // 아래쪽
        for (int j = c - 1; j > 1; j--)
            room[y][j] = room[y][j-1];
        // 공기청정기에서 나오는 바람은 깨끗한 공기
        room[y][1] = 0;
        // 아래쪽 공기청정기
        int[] bottom = filterPos.get(1);
        y = bottom[0];

        // 왼쪽
        for (int i = y + 1; i < r - 1; i++)
            room[i][0] = room[i+1][0];
        // 아래쪽
        for (int j = 0; j < c - 1; j++)
            room[r-1][j] = room[r-1][j+1];
        // 오른쪽
        for (int i = r - 1; i > y; i--)
            room[i][c-1] = room[i-1][c-1];
        // 위쪽
        for (int j = c - 1; j > 1; j--)
            room[y][j] = room[y][j-1];
        // 공기청정기에서 나오는 바람은 깨끗한 공기
        room[y][1] = 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stk = new StringTokenizer(br.readLine());

        r = Integer.parseInt(stk.nextToken());
        c = Integer.parseInt(stk.nextToken());
        t = Integer.parseInt(stk.nextToken());

        room = new int[r][c];
        filterPos = new ArrayList<>();
        for(int i =0;i<r;i++){
            stk = new StringTokenizer(br.readLine());
            for(int j=0;j<c;j++){
                room[i][j]=Integer.parseInt(stk.nextToken());
                if(room[i][j]==-1){
                    filterPos.add(new int[]{i,j});
                }
            }
        }

        bw.write(String.valueOf(dfs(0)));
        bw.flush();
        bw.close();
        br.close();
    }
}
