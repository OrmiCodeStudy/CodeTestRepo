package y2024.Aug.Aug_28;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.StringTokenizer;

public class beakjoon_11050 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken()), k = Integer.parseInt(stk.nextToken());

        int nMul = 1;
        for(int i =1;i<=n;i++){
            nMul*=i;
        }
        int kMul = 1;
        for(int i =1;i<=k;i++){
            kMul*=i;
        }
        int nkMul = 1;
        for(int i =1;i<=n-k;i++){
            nkMul*=i;
        }
        bw.write(nMul/(kMul*nkMul)+"");
        bw.flush();
        bw.close();
        br.close();
    }
}
