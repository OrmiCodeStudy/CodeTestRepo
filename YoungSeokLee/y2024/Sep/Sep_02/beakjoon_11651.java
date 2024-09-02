package y2024.Sep.Sep_02;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Coordinate2 implements Comparable<Coordinate2> {
    public int x;
    public int y;
    Coordinate2(int x, int y){
        this.x = x;
        this.y = y;
    }
    @Override
    public int compareTo(Coordinate2 co){
        if(this.y == co.y){
            return this.x-co.x;
        } else{
            return this.y-co.y;
        }
    }
}
public class beakjoon_11651 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer stk;
        ArrayList<Coordinate2> arr = new ArrayList<>();
        for(int i =0;i<n;i++){
            stk = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(stk.nextToken());
            int y = Integer.parseInt(stk.nextToken());

            arr.add(new Coordinate2(x,y));
        }
        Collections.sort(arr);
        for(Coordinate2 co: arr){
            bw.write(co.x+" "+co.y);
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
