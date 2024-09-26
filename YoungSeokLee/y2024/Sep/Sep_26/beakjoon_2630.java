package y2024.Sep.Sep_26;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
색종이 만들기 - 실버2

전체 종이가 모두 같은색으로 칠해져 있지 않으면 가로와 세로로 중간부분을 잘라서  4등분한다
그 4등분한 종이가 하나의 색으로 칠해져있으면 cnt++;

4등분한 종이의 변 길이가 1이 될때까지 반복

재귀로 풀면될듯하다.
종이의 첫번째 칸과 nxn 칸의 색이 같은지 확인 다른 칸이 하나라도 있다면 4등분 후 하나씩 확인


N : 전체 종이의 한변의 길이 (2,4,8,16,32,64,128)
2~n줄 : 색종이의 각 가로줄의 정사각형칸들의 색
0 : 하얀색
1 : 파란색

잘라진 하얀색 색종이와 파란색 색종이의 개수를 구하라
 */
public class beakjoon_2630 {

    static int whiteCnt = 0;
    static int blueCnt = 0;

    void solution(int[][] paper, boolean[][] isChecked, int length,int x, int y){
        int tempCnt = 0;
        outerLoop:
        for(int i =y;i<y+length;i++){
            for(int j =x;j<x+length;j++){
                if(!isChecked[i][j] && paper[y][x]==paper[i][j]){
                    tempCnt++;
                } else {
                    break outerLoop;
                }
            }
        }
        if(tempCnt==Math.pow(length,2)){
            for(int i =y;i<y+length;i++){
                for(int j =x;j<x+length;j++){
                    isChecked[i][j]=true;
                }
            }
            if(paper[y][x]==1){
                blueCnt++;
                return;
            } else {
                whiteCnt++;
                return;
            }
        }

        int newSize = length / 2;
        solution(paper,isChecked,newSize,x, y);
        solution(paper,isChecked,newSize,x, y + newSize);
        solution(paper,isChecked,newSize,x + newSize, y);
        solution(paper,isChecked,newSize,x + newSize, y + newSize);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        int n = Integer.parseInt(br.readLine());

        int[][] paper = new int[n][n];
        for(int i =0;i<n;i++){
            stk = new StringTokenizer(br.readLine());
            for(int j =0;j<n;j++){
                paper[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        beakjoon_2630 T = new beakjoon_2630();

        boolean[][] isChecked = new boolean[n][n];
        T.solution(paper,isChecked,n,0,0);

        bw.write(whiteCnt+"\n"+blueCnt);
        bw.flush();
        bw.close();
        br.close();
    }
}
