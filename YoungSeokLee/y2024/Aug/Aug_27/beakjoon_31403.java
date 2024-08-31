package y2024.Aug.Aug_27;

import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;

public class beakjoon_31403 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String a = br.readLine(), b = br.readLine(), c = br.readLine();
        int aNum = Integer.parseInt(a), bNum = Integer.parseInt(b), cNum = Integer.parseInt(c);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write((aNum + bNum - cNum)+"");
        bw.newLine();
        bw.write(Integer.parseInt(a+b)-cNum+"");

        bw.flush();
        bw.close();
        br.close();
    }
}