package y2024.Aug.Aug_30;

import java.io.*;

public class beakjoon_2751 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] numArr = new int[2000001];
        for(int i = 0;i<n;i++){
            int num = Integer.parseInt(br.readLine());
            numArr[num+1000000]=1;
        }

        for(int i =0;i<2000001;i++){
            if(numArr[i]==1){
                bw.write(i-1000000+"");
                bw.newLine();
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
