package y2024.Sep.Sep_06;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
랜선 자르기(1654)
N : 만들어야 하는 랜선의 갯수 (길이가 같아야 함)
K : 이미 있는 랜선의 갯수 (길이가 다름)
이미 자른 랜선은 붙일 수 없다.
항상 정수길이만큼 자른다

만들 수 있는 최대 랜선의 길이를 구하라
 */
public class beakjoon_1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(stk.nextToken());
        int n = Integer.parseInt(stk.nextToken());

        int[] lenArr = new int[k];
        for (int i = 0; i < k; i++) {
            lenArr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(lenArr);

        int maxLen = lenArr[k-1];
        long low = 1;
        long high = maxLen;
        long result = 0;

        while(low <=high){
            long mid = (low+high)/2;
            long cnt=0;

            for(int len: lenArr){
                cnt+=len/mid;
            }

            if(cnt>=n){
                result=mid;
                low=mid+1;
            } else {
                high = mid -1;
            }
        }

        bw.write(result + "");

        bw.flush();
        bw.close();
        br.close();
    }
}
