package y2024.Oct.Oct_11;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
이중 우선순위 큐 - 골드 4

q : 정수를 저장하는 이중 우선순위 큐
q에 저장된 각 정수의 값 : 우선순위

최종 연산 후 q에 저장된 데이터 중 최댓값과 최솟값을 출력하라

T : 테스트 데이터 수
k : q에 적용할 연산의 개수
D n
    - n == -1 : 최댓값을 삭제
    - n == 1 : 최솟값을 삭제
I n: 정수 n을 q에 삽입

q가 비어있는데 d가 입력되면 무시
최종결과가 비어있다면 EMPTY 출력
 */
public class beakjoon_7662 {

    void insertSort(ArrayList<Integer> q, int newElement){
        int i;
        for(i=0;i<q.size()&&q.get(i)<newElement;i++);
        q.add(i, newElement);
    }

    void delete(ArrayList<Integer> q, int choice){
        if(q.isEmpty())
            return;

        if(choice == -1){
            q.remove(0);
        } else {
            q.remove(q.size()-1);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        StringTokenizer stk;

        ArrayList<Integer> q = new ArrayList<>();
        beakjoon_7662 T = new beakjoon_7662();

        for(int i =0;i<t;i++){
            int k = Integer.parseInt(br.readLine());
            for(int l=0;l<k;l++){
                stk = new StringTokenizer(br.readLine());
                char command = stk.nextToken().charAt(0);
                int n = Integer.parseInt(stk.nextToken());

                if(command =='I')
                    T.insertSort(q,n);
                else
                    T.delete(q,n);
            }
            if(!q.isEmpty())
                bw.write(q.get(q.size()-1)+" "+q.get(0)+"\n");
            else
                bw.write("EMPTY\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
