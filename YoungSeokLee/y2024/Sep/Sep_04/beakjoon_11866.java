package y2024.Sep.Sep_04;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;
/*
요세푸스 문제 0
1번부터 N번까지 N명의 사람이 원을 이루며 앉아있고, 양의 정수k가 주어진다
k 번째 사람을 제거한다. n명의 사람이 모두 제거될때까지 계속된다.
원에서 사람들이 제거되는 순서를 (N,K) - 요세푸스 순열이라고 한다
 */
public class beakjoon_11866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken()), k = Integer.parseInt(stk.nextToken());

        LinkedList<Integer> nList = new LinkedList<>();

        for(int i =1;i<=n;i++){
            nList.add(i);
        }
        bw.write("<");
        int pos = 0;
        for(int i =0;i<n;i++){
            pos = (pos+k)%nList.size()-1;
            pos = pos==-1?nList.size()-1:pos;
            int numVal = nList.get(pos);
            bw.write(numVal+"");
            nList.remove(pos);
            if(i!=n-1){
                bw.write(", ");
            }
        }
        bw.write(">");

        bw.flush();
        bw.close();
        br.close();

    }
}
