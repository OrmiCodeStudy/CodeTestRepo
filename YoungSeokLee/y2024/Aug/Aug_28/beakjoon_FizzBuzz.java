package y2024.Aug.Aug_28;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;

public class beakjoon_FizzBuzz {
        public static void main(String[] args) throws IOException {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String[] inputArr = new String[3];

            int num = 0;

            for(int i =0;i<inputArr.length;i++){
                inputArr[i] = br.readLine();
                if(!inputArr[i].equals("Fizz") && !inputArr[i].equals("Buzz") && !inputArr[i].equals("FizzBuzz")){
                    num = Integer.parseInt(inputArr[i])+3-i;
                }
            }


            String answer="";

            if(num%3==0){
                if(num%5==0){
                    answer = "FizzBuzz";
                } else {
                    answer = "Fizz";
                }
            } else {
                if(num%5==0){
                    answer = "Buzz";
                } else {
                    answer = num+"";
                }
            }

            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            bw.write(answer);
            bw.flush();
            bw.close();
            br.close();
        }
}
