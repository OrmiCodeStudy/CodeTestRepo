package y2025.Jan.Jan_09;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
사전 순 최대 공통 부분 수열 - 골드 4

어떤 수열이 다른 수열의 부분수열인 조건
1. 해당 수열의 원소들이 다른 수열 내에서 순서대로 등장

어떤 수열이 다른 수열보다 사전순으로 나중인 조건
1. 두 수열중 첫번째 수가 큰 쪽은 사전순으로 나중
2. 두 수열의 첫번째 수가 같다면, 첫번째 수를 빼고 두 수열을 다시 비교했을때 사전순으로 나중인 쪽

수열 a,b가 공통으로 갖는 부분 수열들 중 사전 순으로 가장 나중인 것을 구하라

풀이

두 수열을 동시에 순회하면서 같은 숫자가 나오면 해당 index를 기록,
가장 큰 숫자가 동시에 나오는 경우를 두 수열 끝까지 반복해서 찾으면 된다.
 */

public class beakjoon_30805 {
    static int n,m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        StringTokenizer stk = new StringTokenizer(br.readLine());
        for(int i =0;i<n;i++){
            a[i]=Integer.parseInt(stk.nextToken());
        }

        m = Integer.parseInt(br.readLine());
        int[] b = new int[m];
        stk = new StringTokenizer(br.readLine());
        for(int i =0;i<m;i++){
            b[i]=Integer.parseInt(stk.nextToken());
        }

        LinkedList<Integer> commonArrs = getCommonArr(a, b);

        bw.write(commonArrs.size()+"\n");
        for(int i =0;i<commonArrs.size();i++){
            bw.write(commonArrs.get(i)+" ");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static LinkedList<Integer> getCommonArr(int[] a, int[] b){
        LinkedList<Integer> result = new LinkedList<>();
        int idxA = 0, idxB =  0;

        while (idxA < a.length && idxB < b.length){
            int maxCommon = -1;
            int maxIdxA = -1, maxIdxB = -1;

            for(int i =idxA; i <a.length;i++){
                for(int j =idxB; j<b.length;j++){
                    if(a[i]==b[j] && a[i]>maxCommon){
                        maxCommon = a[i];
                        maxIdxA = i;
                        maxIdxB = j;
                    }
                }
            }

            if(maxCommon == -1)
                break;

            result.add(maxCommon);
            idxA = maxIdxA+1;
            idxB = maxIdxB+1;
        }

        return result;
    }
}
