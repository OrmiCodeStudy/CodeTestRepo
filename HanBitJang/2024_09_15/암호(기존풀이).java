import java.util.Scanner;

public class Main {
    public String solution(int n, String s) {
        String answer = "";
        for (int i = 0; i < n; i++) {
            String tmp = s.substring(0, 7).replace('#', '1').replace('*', '0');
            int decimal = 0;
            String[] strArr = tmp.split("");
            for (int j = strArr.length - 1, k = 0; j >= 0; j--, k++) {
                decimal += Integer.parseInt(strArr[j]) * (int) Math.pow(2, k);
            }
            answer += (char) decimal;
            System.out.println(tmp + " " + decimal);
            s = s.substring(7);
        }
        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        String s = kb.next();
        System.out.println(T.solution(n, s));
    }
}