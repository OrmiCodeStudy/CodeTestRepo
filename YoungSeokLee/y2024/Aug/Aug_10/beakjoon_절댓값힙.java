package y2024.Aug.Aug_10;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
minHeap과 maxHeap을 둘다 구현

양수인 경우, minHeap에 추가
음수인 경우, maxHeap에 추가

출력시, 두 Heap의 peek값의 절대값을 비교해 더 작은쪽을 poll
둘이 같다면 maxHeap에서 poll

만약 두 Heap이 다 비어있다면 0을 출력
둘중 하나라도 있다면 해당 Heap에서 poll
*/
public class beakjoon_절댓값힙 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int x;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return - Integer.compare(o1,o2);
            }
        });

        for(int i =0;i<n;i++){
            x = Integer.parseInt(br.readLine());
            if(x == 0) {
                int answer=0;

                if(minHeap.isEmpty() && maxHeap.isEmpty()){
                    System.out.println(0);
                } else if(maxHeap.isEmpty()) {
                    System.out.println(minHeap.poll());
                } else if (minHeap.isEmpty()) {
                    System.out.println(maxHeap.poll());
                }
                else {
                    int minPeek = minHeap.peek();
                    int maxPeek = maxHeap.peek();

                    if (-maxPeek > minPeek) {
                        System.out.println(minHeap.poll());
                    } else if (-maxPeek < minPeek) {
                        System.out.println(maxHeap.poll());
                    } else if (-maxPeek == minPeek) {
                        System.out.println(maxHeap.poll());
                    }
                }
            } else if(x>0) {
                minHeap.add(x);
            } else {
                maxHeap.add(x);
            }
        }
    }
}
