package y2024.Nov.Nov_01;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
치킨 배달 - 골드5

n : 도시의 크기
치킨거리 : 집과 가장 가까운 치킨집 사이의 거리

0 : 빈칸
1 : 집
2 : 치킨집

도시에 있는 치킨집 중에서 최대 m개를 고르고, 나머지 치킨집은 모두 폐업해야한다.
어떻게 고르면 도시의 치킨 거리가 가장 작게 될지 구하라

풀이
치킨집 좌표중 m개를 선택해 각 경우의 치킨 거리를 구해 최소거리를 구한다.
 */
public class beakjoon_15686 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        ArrayList<int[]> chickens = new ArrayList<>();
        ArrayList<int[]> homes = new ArrayList<>();
        for(int i =0;i<n;i++){
            stk = new StringTokenizer(br.readLine());
            for(int j =0;j<n;j++){
                int place = Integer.parseInt(stk.nextToken());
                if(place==1){
                    homes.add(new int[]{i,j});
                } else if(place==2){
                    chickens.add(new int[]{i,j});
                }
            }
        }

        List<List<int[]>> combi = combine(chickens,m);

        int answer = Integer.MAX_VALUE;
        for(List<int[]> combination : combi){
            int totalDist = 0;
            for(int[] home : homes){
                int minDist = Integer.MAX_VALUE;
                for(int i =0;i<combination.size();i++){
                    int chickenDist = Math.abs(home[0]-combination.get(i)[0])+Math.abs(home[1]-combination.get(i)[1]);
                    if(minDist>chickenDist){
                        minDist = chickenDist;
                    }
                }
                totalDist+=minDist;
            }
            answer=Math.min(answer,totalDist);
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
        br.close();
    }

    static List<List<int[]>> combine(ArrayList<int[]> coordinates, int n) {
        List<List<int[]>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), coordinates, n, 0);
        return result;
    }

    static void backtrack(List<List<int[]>> result, List<int[]> current, List<int[]> coordinates, int n, int start) {
        if (current.size() == n) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < coordinates.size(); i++) {
            current.add(coordinates.get(i));
            backtrack(result, current, coordinates, n, i + 1);
            current.remove(current.size() - 1);
        }
    }
}
