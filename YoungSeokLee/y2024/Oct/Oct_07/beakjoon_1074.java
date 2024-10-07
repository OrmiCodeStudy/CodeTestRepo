package y2024.Oct.Oct_07;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
Z - 골드 5

크기가 2^N X 2^N인 2차원 배열을 Z모양으로 탐색할때,
r행 c열을 몇번째로 방문하는지 출력하는 프로그램을 작성하라

계산을 하면 되지 않나
 */
public class beakjoon_1074 {

    long cntZ(Long n, Long r, Long c, Long cnt){

        if(n==0){
            return cnt;
        }

        Long halfN = 1L << (n - 1);
        Long halfCnt = halfN*halfN;

        Long newRow,newCol;
        if(halfN <= r){
            newRow = r-halfN;
            if(halfN<= c){ //4사분면
                newCol = c-halfN;
                cnt += halfCnt*3;
            } else { // 3사분면
                newCol = c;
                cnt += halfCnt*2;
            }
        } else {
            newRow = r;
            if(halfN<= c){ // 2사분면
                newCol = c-halfN;
                cnt += halfCnt;
            } else { // 1사분면
                newCol = c;
            }
        }

        return cntZ(n-1,newRow,newCol,cnt);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        Long n = Long.parseLong(stk.nextToken());
        Long r = Long.parseLong(stk.nextToken());
        Long c = Long.parseLong(stk.nextToken());
        Long cnt = 0L;

        beakjoon_1074 T = new beakjoon_1074();
        bw.write(String.valueOf(T.cntZ(n,r,c,cnt)));
        bw.flush();
        bw.close();
        br.close();
    }
}
