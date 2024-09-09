package y2024.Sep.Sep_09;

import java.io.*;
import java.util.Arrays;

/*
0층의 i호에는 i명이 산다
아파트에 비어있는 집은 없고, 자신의 아래층의 1호부터 b호까지 사람들의 수의 합만큼 사람이 있어야 한다.
4층
1 6 21 56 126
1 1*4+2 1*10+2*4+3
3층
1 5 15 35 70
1 1*3+2 1*6+2*3+3
2층
1 4 10 20 35
1+ 1*2+2 1*3+2*2+3
1층
1 3 6 10 15
1 1+2 1+2+3
0층
1 2 3 4 5 ... 14
 */
public class beakjoon_2775 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        int[] k = new int[t];
        int[] n = new int[t];

        for(int i =0;i<t;i++){
            k[i]= Integer.parseInt(br.readLine());
            n[i]= Integer.parseInt(br.readLine());

            int[] lastFloor = new int[n[i]+1];
            for(int o = 1;o<=n[i];o++){
                lastFloor[o]= o;
            }

            for(int j = 0;j<k[i];j++){
                int[] thisFloor = new int[n[i]+1];
                for(int l = 1;l<=n[i];l++){
                    for(int m = 1;m<=l;m++){
                        thisFloor[l] += lastFloor[m];
                    }
                }
                lastFloor = Arrays.copyOf(thisFloor,n[i]+1);
            }
            bw.write(lastFloor[n[i]]+"\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
