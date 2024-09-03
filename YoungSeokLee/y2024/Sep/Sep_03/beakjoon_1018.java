package y2024.Sep.Sep_03;

import java.io.*;
import java.util.StringTokenizer;
/*
8*8 체스판을 만들어야한다
8*8 크기의 영역을 순회하면서 규칙을 지키는지 확인
바꿔야하는 칸의 갯수가 이전 최솟값보다 작다면 교체

기준칸의 인덱스와 인덱스 차의 합이 홀수이면 색이 달라야 한다
색이 같아야 한다.
기준칸의 색이 유지되었을때 변경해야하는 갯수가 32개를 넘는다면, 기준칸의 색을 변경하고 다시 수행
 */
public class beakjoon_1018 {
    public static int solution(boolean[][] chessBoard,int m, int n) {

        int minVal = Integer.MAX_VALUE;

        for(int i =0;i<m-7;i++){
            for(int j =0;j<n-7;j++){
                int cnt=0;
                int cnt2=0;
                boolean baseColor = chessBoard[i][j];
                boolean baseColor2 = !chessBoard[i][j];
                for(int k = i;k<i+8;k++){
                    for(int l = j;l<j+8;l++){
                        if(((k-i)+(l-j))%2==0){
                            if(chessBoard[k][l]!=baseColor)
                                cnt++;
                            if(chessBoard[k][l]!=baseColor2)
                                cnt2++;
                        } else {
                            if(chessBoard[k][l]==baseColor)
                                cnt++;
                            if(chessBoard[k][l]==baseColor2)
                                cnt2++;
                        }
                    }
                }
                int value = Math.min(cnt,cnt2);
                if(minVal>value){
                    minVal = value;
                }
            }
        }

        return minVal;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stk = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(stk.nextToken());
        int n = Integer.parseInt(stk.nextToken());

        boolean[][] chessBoard = new boolean[m][n];
        for(int i =0;i<m;i++){
            String line = br.readLine();
            for(int j=0;j<n;j++){
                chessBoard[i][j] = line.charAt(j)=='W';
            }
        }

        bw.write(solution(chessBoard,m,n)+"");
        bw.flush();
        bw.close();
        br.close();
    }
}
