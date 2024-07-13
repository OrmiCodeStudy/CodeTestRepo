import java.util.Scanner;
import java.util.Stack;
// 최종 풀이
public class Main {
    public int solution(String str) {
        int answer = 0;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                stack.push('(');
            } else {
                stack.pop();
                if (str.charAt(i - 1) == '(') { // 레이저의 끝을 나타내는 ')'인 경우
                    answer += stack.size();
                } else {						// 쇠막대기의 끝을 나타내는 ')'인 경우
                    answer ++;
                }
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        Main T = new Main();
        String str = kb.next();
        System.out.println(T.solution(str));
    }
}