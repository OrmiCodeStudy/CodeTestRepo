package y2024.Sep.Sep_19;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

/*
패션왕 신해빈

한번 입었던 옷의 조합을 절대 다시 입지 않는다 (새로운 종류 추가 혹은 변경을 해야 입을 수 있다.)
해빈이가 가진 의상이 주어졌을때 해빈이는 알몸이 아닌 상태로 며칠동안 밖을 돌아다닐 수 있는가

t : 테스트 케이스 수
n : 해빈이가 가진 의상 수
해빈이가 가진 의상의 이름과 의상의 종류가 공백으로 구분되어 n개만큼 주어진다
같은 종류의 의상은 하나만 입을 수 있다.
 */
public class beakjoon_9375 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; i++){
            int n = Integer.parseInt(br.readLine());
            HashMap<String, Integer> clothes = new HashMap<>();

            for(int j = 0; j < n; j++){
                String[] input = br.readLine().split(" ");
                String clothPart = input[1];
                clothes.put(clothPart, clothes.getOrDefault(clothPart, 0) + 1);
            }

            int result = calculateOutfits(clothes);
            bw.write(result + "\n");

            clothes.clear();
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static int calculateOutfits(HashMap<String, Integer> clothes) {
        int totalOutfits = 1;
        for (int count : clothes.values()) {
            totalOutfits *= (count + 1);
        }
        return totalOutfits - 1;  // 알몸인 경우를 제외
    }
}