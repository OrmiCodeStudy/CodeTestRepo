package y2024.Aug.Aug_12;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class beakjoon_일곱난쟁이 {
    static boolean found = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] nanjeng = new int[9];

        for(int i =0;i<9;i++){
            nanjeng[i]=Integer.parseInt(br.readLine());
        }
        boolean[] visited = new boolean[9];

        combination(nanjeng, visited,0,0,7);
    }

    public static void combination(int[] arr, boolean[] visited, int start, int depth, int r){
        if(found) return;

        List<Integer> sumArr = new ArrayList<>();
        int sumVal = 0;
        if(depth == r){
            for(int i =0;i<arr.length;i++){
                if(visited[i]){
                    sumArr.add(arr[i]);
                    sumVal+= arr[i];
                }
            }
            if(sumVal == 100){
                sumArr.sort(Comparator.naturalOrder());
                for(int i =0;i<sumArr.size();i++){
                    System.out.println(sumArr.get(i));
                }
                found = true;
            }
            return;
        }

        for(int i =start;i<arr.length;i++){
            if(!visited[i]){
                visited[i] = true;
                combination(arr,visited,i+1,depth+1,r);
                visited[i] = false;
            }
        }
    }

}
