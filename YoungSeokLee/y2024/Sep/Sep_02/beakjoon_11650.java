package y2024.Sep.Sep_02;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Coordinate implements Comparable<Coordinate> {
    public int x;
    public int y;
    public Coordinate(int x, int y){
        this.x = x;
        this.y = y;
    }
    @Override
    public int compareTo(Coordinate co) {
        if(this.x==co.x){
            return this.y-co.y;
        } else {
            return this.x-co.x;
        }
    }
}
public class beakjoon_11650 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        ArrayList<Coordinate> arr = new ArrayList<>();
        StringTokenizer stk;

        for(int i =0;i<n;i++){
            stk = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(stk.nextToken());
            int y = Integer.parseInt(stk.nextToken());

            arr.add(new Coordinate(x,y));
        }

        Collections.sort(arr);
        for(Coordinate co:arr){
            bw.write(co.x + " " + co.y);
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();
    }

}
