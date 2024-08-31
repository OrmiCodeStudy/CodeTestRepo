package y2024.Aug.Aug_30;

import java.io.*;

/*
종말의 수 : 6이 적어도 3개이상 연속으로 들어가는 수

 */
public class beakjoon_1436 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String movieTitle = "";
        int cnt =0;
        int num =665;

        while(cnt!=n){
            num++;
            if((String.valueOf(num)).contains("666")){
                cnt++;
            }
        }

        bw.write(num+"");
        bw.flush();
        bw.close();
        br.close();
    }
}
