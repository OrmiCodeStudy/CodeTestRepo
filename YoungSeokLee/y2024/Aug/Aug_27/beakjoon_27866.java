package y2024.Aug.Aug_27;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class beakjoon_27866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        int i = Integer.parseInt(br.readLine());

        bw.write(s.charAt(i-1));
        bw.flush();
        bw.close();
        br.close();
    }
}
