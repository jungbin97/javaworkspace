package 완전탐색.피로도;

import java.util.ArrayList;

public class Solution {
    /**********************************************************************
     * DFS 백트래킹 사용
     **********************************************************************/
    static int answer = 0;
    static boolean[] visited = new boolean[8];
    public int solution(int k, int[][] doungeons){

        // cnt : 탐험한 던전 개수, k : 남은 피로도
        DFS(k, 0, doungeons, visited);
        return answer;
    }

    public void DFS(int k, int cnt, int[][] doungeons, boolean[] visited){
        answer = Math.max(answer, cnt);     // answer 갱신

        for (int i = 0; i < doungeons.length; i++){
            if (!visited[i] && k >= doungeons[i][0]){
                visited[i] = true;
                // 이전 노드 다시 back  할때 visted[i] 값 false로 돌림
                // 현재 피로도의 수 해당 노드 방문하지 전으로 돌림
                DFS(k-doungeons[i][1], cnt+1, doungeons, visited);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.solution(80, new int[][]{{80, 20}, {50, 40}, {30, 10}});
        System.out.println(answer);
    }
}
