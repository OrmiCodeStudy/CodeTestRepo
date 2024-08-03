import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int m1=Integer.parseInt(stk.nextToken()),d1 = Integer.parseInt(stk.nextToken());
        int m2 = Integer.parseInt(stk.nextToken()), d2 = Integer.parseInt(stk.nextToken());
        String day = br.readLine();

        System.out.println(cntDate(m1,d1,m2,d2,day));
    }

    public static int cntDate(int m1, int d1, int m2, int d2,String day){
        int[] dates = {0,31,29,31,30,31,30,31,31,30,31,30,31};
        HashMap<String, Integer> days = new HashMap<String, Integer>(){
            {
                put("Mon",0);
                put("Tue",1);
                put("Wed",2);
                put("Thu",3);
                put("Fri",4);
                put("Sat",5);
                put("Sun",6);
            }
        };

        int dateCnt = 0;
        int answer = 0;
        if(day.equals("Mon"))
            answer = 1;

        while(true){
            if(m1==m2&&d1==d2)
                break;

            dateCnt++;
            d1++;
            if(d1>dates[m1]){
                m1++;
                d1=1;
            }
            if(dateCnt%7==days.get(day))
                answer++;
        }

        return answer;
    }
}