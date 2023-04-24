package DFS_BFS.programmers_타겟넘버;

public class Solution {
        /**********************************************************************
         * 시간 복잡도 : O(2^n) : 현재 숫자를 빼는 경로, 더하는 경로 두개 탐색
         *
         **********************************************************************/
        public int dfs(int[] numbers,int target, int sum, int idx){
            int answer = 0;
          if(idx == numbers.length){
              if(sum  == target){
                  return 1;
              }else{
                  return 0;
              }
          }

          answer += dfs(numbers, target, sum+numbers[idx], idx+1);
          answer += dfs(numbers, target, sum-numbers[idx], idx+1);
          return answer;
        }

        public int solution(int[] numbers, int target){
            int result = dfs(numbers, target, 0,0);
            return result;
        }
}
