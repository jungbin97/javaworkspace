package 완전탐색.programmers_최소직사각형;


public class Solution {
        /**********************************************************************
         *
         *
         **********************************************************************/
    public int solution(int[][] sizes){
        int width = 0;
        int hight = 0;

        // 최댓값 구하기
        for (int i = 0; i < sizes.length; i++) {
            int max = Math.max(sizes[i][0], sizes[i][1]);
            int min = Math.min(sizes[i][0], sizes[i][1]);

            // 해당 명함의 최대길이와 여태 들어온 명함중 최대길이 비교
            width = Math.max(width, max);
            hight = Math.max(hight, min);
        }
        return width * hight;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int result = s.solution(new int[][]{{60,50}, {30,70}, {60, 30}, {80, 40}});
        System.out.println(result);
    }
}
