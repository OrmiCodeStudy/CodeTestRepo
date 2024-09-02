package y2024.Sep.Sep_02;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Member implements Comparable<Member> {
    public int age;
    public String name;
    public int index;
    Member(int age, String name,int index) {
        this.age = age;
        this.name = name;
        this.index = index;
    }
    @Override
    public int compareTo(Member mem) {
        if(this.age == mem.age) {
            return this.index-mem.index;
        } else {
            return this.age-mem.age;
        }
    }
}
public class beakjoon_10814 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer stk;

        ArrayList<Member> arr = new ArrayList<Member>();
        for(int i =0;i<n;i++){
            stk = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(stk.nextToken());
            String name = stk.nextToken();
            int index = arr.size();
            arr.add(new Member(age,name,index));
        }
        Collections.sort(arr);

        for(Member mem: arr){
            bw.write(mem.age + " " + mem.name);
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
