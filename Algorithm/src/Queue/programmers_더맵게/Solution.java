package Queue.programmers_더맵게;

import java.util.PriorityQueue;

public class Solution {
        /**********************************************************************
         * 우선 순위 큐를 사용해 가장 작은 두개의 음식을 꺼내 K이상이 될때까지 반복
         * 시간 복잡도 : 우선순위 큐 시간복잡도 O(NlogN)
         **********************************************************************/
        public int solution(int[] scoville, int K){
            int answer = 0;

            PriorityQueue<Integer> heap = new PriorityQueue<>();

            for(int aScoville : scoville){
                heap.add(aScoville);
            }
            // 힙에서 가장 작은 값이 K보다 작으면 반복
            while(heap.peek() < K){
                // 전부 더해도 K를 넘지 않을 경우
                if(heap.size() <= 1){
                    return -1;
                }

                // 힙에서 가장 작은 값, 두번째로 작은 값
                int a = heap.poll();
                int b = heap.poll();

                int result = a + (b*2);

                heap.add(result);
                answer++;
            }
            return answer;
        }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(new int[] {1, 2, 3, 9, 10, 12}, 7));
    }
}
