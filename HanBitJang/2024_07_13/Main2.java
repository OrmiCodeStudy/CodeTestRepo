import java.util.Scanner;
import java.util.Stack;
// 이전 풀이
public class MetalRod {
    public int solution(String str) {
        int answer = 0;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                stack.push(str.charAt(i));
            } else {
                if(str.charAt(i - 1) == '(') {
                    stack.pop();
                    answer += stack.size();
                } else if (str.charAt(i - 1) == ')') {
                    stack.pop();
                    answer += 1;
                }
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        MetalRod T = new MetalRod();
        String str = kb.next();
        System.out.println(T.solution(str));
    }
}