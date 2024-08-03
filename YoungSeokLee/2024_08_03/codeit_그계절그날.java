import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int y=Integer.parseInt(stk.nextToken()),m=Integer.parseInt(stk.nextToken()),d=Integer.parseInt(stk.nextToken());

        System.out.println(seasons(y,m,d));
    }

    public static String seasons(int y, int m, int d) {
        int[] dates = {31,28,31,30,31,30,31,31,30,31,30,31};
        if(isYoon(y))
            dates[1]=29;

        if(!isValid(m,d,dates))
            return "-1";

        String answer = "";

        switch(m) {
            case 3: case 4: case 5:
                answer = "Spring";
                break;
            case 6: case 7: case 8:
                answer = "Summer";
                break;
            case 9: case 10: case 11:
                answer = "Fall";
                break;

            case 12: case 1: case 2:
                answer = "Winter";
                break;
        }

        return answer;
    }

    public static boolean isYoon(int y) {
        return (y%4==0&&y%100!=0) || (y%4==0&&y%100==0&&y%400==0)?true:false;
    }

    public static boolean isValid(int m, int d, int[] dates) {
        return m<=12&&dates[m-1]>=d?true:false;
    }
}