import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int m1=Integer.parseInt(stk.nextToken()),d1 = Integer.parseInt(stk.nextToken());
        int m2 = Integer.parseInt(stk.nextToken()), d2 = Integer.parseInt(stk.nextToken());
        String date = br.readLine();

        System.out.println(cntDate(m1,d1,m2,d2));
    }

    public static int cntDate(int m1, int d1, int m2, int d2){
        int[] dates = {0,31,29,31,30,31,30,31,31,30,31,30,31};

        int totalDate = dates[m1]-d1 + d2;
        for(int i =m1+1;i<m2;i++){
            totalDate+=dates[i];
        }

        return totalDate/7+1;
    }
}