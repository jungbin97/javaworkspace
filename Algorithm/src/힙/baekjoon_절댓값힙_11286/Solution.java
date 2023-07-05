package 힙.baekjoon_절댓값힙_11286;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Solution {
        /**********************************************************************
         *
         *
         **********************************************************************/
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int N = Integer.parseInt(br.readLine());

            // 최소힙
            PriorityQueue<Integer> minHeap = new PriorityQueue<>((o1, o2) -> {

                // 절댓값이 작은 데이터 우선
                int first_abs = Math.abs(o1);
                int second_abs = Math.abs(o2);
                // 절댓값이 같으면 음수 우선
                if (first_abs == second_abs){
                    return o1 > o2 ? 1 : -1;
                }
                return first_abs - second_abs;
            });

            for(int i=0; i<N; i++){
                int num = Integer.parseInt(br.readLine());

                if (num == 0){
                    if (minHeap.size()>0){
                        System.out.println(minHeap.poll());
                    }else{
                        System.out.println(0);
                    }
                }else{
                    minHeap.add(num);
                }
            }
        }
}
