package 완전탐색.programmers_카펫;

import java.util.Arrays;

public class Solution {
    /**********************************************************************
     *
     *  1.카펫의 사이즈 경우의 수 구하기
     *  2.가로의 길이와 세로의 길이가 같거나 가로가 더김
     *  3.가운데 노란색이 있으려면 가로와 세로가 3이상
     *  4. 해당 카펫이 입력으로 주어진 개수만큼 노란색격자가 가운데에 있을 수 있는지 구하기
     *
     **********************************************************************/
    public int[] solution(int brown, int yellow){
        int[] answer = {};
        int total = brown + yellow;

        for(int i = 1; i<=total; i++){
            if (total % i == 0) {
                int j = total / i;
                if (i >= j) {
                    if (((i - 2) * (j - 2)) == yellow) {
                        answer = new int[]{i, j};
                        return answer;
                    }
                }
            }
        }
        return answer;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        int[] result = s.solution(10, 2);
        System.out.println(Arrays.toString(result));
    }
}
