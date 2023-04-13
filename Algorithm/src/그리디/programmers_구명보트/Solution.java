package 그리디.programmers_구명보트;
import java.util.*;

public class Solution {
        /**********************************************************************
         *  구명보트 인원 제한 : 최대 2명, 무게제한
         *  1. 가장 큰값과 가장 작은 값을 더함
         *  2. 제한 무게 초과시 보트  +1, 가장 큰값 인덱스 -1
         *  3. 제한 무게 초과하지 않을 경우 보트 +1, 가장 큰 값 인덱스 -1, 가장 작은 값 인덱스 +1
         *  시간 복잡도 : O(NlogN) + O(N) => O(NlogN)
         **********************************************************************/
        public int solution(int[] people, int limit){
            int answer = 0;
            int minIdx = 0;             // 최소 인덱스
            int maxIdx = people.length - 1;             // 최대 인덱스
            Arrays.sort(people);        // 오름차순

            while(maxIdx >= minIdx){
                if (people[minIdx] + people[maxIdx] <= limit){
                    answer++;
                    minIdx++;
                    maxIdx--;
                }else {
                    maxIdx--;
                    answer++;
                }
            }
            return answer;
        }

    public static void main(String[] args) {
        Solution s = new Solution();
        int result = s.solution(new int[]{70, 50, 80, 50}, 100);
        System.out.println(result);
    }
}
