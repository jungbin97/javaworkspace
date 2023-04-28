package 그리디.programmers_체육복;
import java.util.*;

public class Solution {
        /**********************************************************************
         * 1. lost, reserve 정렬(정렬되지 않은 테스트 케이스 고려)
         * 2. 여별의 체육복을 가져온 학생의 값을 -1로 변경(lost, reserve 둘다)
         * 3. 잃어 버린 학생의 앞, 뒤 있는 다른 학생으로 부터 체육복을 빌려올수 있는 경우 => 빌려주는 학생(reserve)를 -1로 변경
         **********************************************************************/
        public int solution(int n, int[] lost, int[] reserve){
            int count = 0;
            Arrays.sort(lost);
            Arrays.sort(reserve);

            for(int i = 0; i < lost.length; i++){
                for(int j = 0; j < reserve.length; j++){
                    if(lost[i] == reserve[j]){
                        lost[i] = -1;
                        reserve[j] = -1;
                        count++;
                        break;
                    }
                }
            }

            for(int i = 0; i < lost.length; i++){
                for(int j = 0; j < reserve.length; j++){
                    if(lost[i] == reserve[j]+1 || lost[i] == reserve[j]-1){
                        count++;
                        reserve[j] = -1;
                        break;
                    }
                }
            }
            return n - lost.length + count;
        }

    public static void main(String[] args) {
        Solution s = new Solution();
        int result = s.solution(5, new int[]{2,4}, new int[]{1,3,5});
        System.out.println(result);
    }
}
