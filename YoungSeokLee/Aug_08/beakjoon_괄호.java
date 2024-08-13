package Aug_08;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.Stack;

public class beakjoon_괄호{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for(int i =0;i<n;i++){
            Stack<String> stackStr = new Stack<>();
            String[] chars = br.readLine().split("");
            int cnt = 0;
            while(chars.length>cnt){
                String gualho = chars[cnt];

                if(gualho.equals("("))
                    stackStr.push(chars[cnt]);
                else if(gualho.equals(")") && !stackStr.empty())
                    stackStr.pop();
                else if(gualho.equals(")") && stackStr.empty()) {
                    stackStr.push(chars[cnt]);
                    break;
                }
                cnt++;
            }
            if(stackStr.empty())
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}