package y2024.Aug.Aug_28;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class beakjoon_10989 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] nArr = new int[10001];

        for(int i =0;i<n;i++){
            nArr[Integer.parseInt(br.readLine())] += 1;
        }

        for(int i =0;i<nArr.length;i++){
            if(nArr[i]!=0){
                for(int j =0;j<nArr[i];j++){
                    bw.write(i+"");
                    bw.newLine();
                }
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}