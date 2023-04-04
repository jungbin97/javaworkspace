package 완전탐색.programmers_피로도;

import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    /**********************************************************************
     * DFS 백트래킹 사용
     **********************************************************************/
//    static int answer = 0;
//    static boolean[] visited = new boolean[8];
//    public int solution(int k, int[][] doungeons){
//
//        // cnt : 탐험한 던전 개수, k : 남은 피로도
//        DFS(k, 0, doungeons, visited);
//        return answer;
//    }
//
//    public void DFS(int k, int cnt, int[][] doungeons, boolean[] visited){
//        answer = Math.max(answer, cnt);     // answer 갱신
//
//        for (int i = 0; i < doungeons.length; i++){
//            if (!visited[i] && k >= doungeons[i][0]){
//                visited[i] = true;
//                // 이전 노드 다시 back  할때 visted[i] 값 false로 돌림
//                // 현재 피로도의 수 해당 노드 방문하지 전으로 돌림
//                DFS(k-doungeons[i][1], cnt+1, doungeons, visited);
//                visited[i] = false;
//            }
//        }
//    }

    /**********************************************************************
     * 순열을 이용한 완전 탐색 구현
     *  Swap과정에서 오류 발생
     **********************************************************************/
    static int answer = 0;
    static ArrayList<ArrayList<Integer>> sequence = new ArrayList<>();
    public int solution(int k, int[][] doungeons){
        ArrayList<Integer> arr = new ArrayList<>();
        int l = doungeons.length;

        // 던전 개수만큼 인덱스 배열 생성
        for (int i = 0; i<l; i++){
            arr.add(i);
        }

        // 이차 순열 리스트 생성
        per1(arr, 0, arr.size(), arr.size());

        for (ArrayList<Integer> i :sequence){
            int current_k = k;
            int cnt = 0;
            for(int j : i){     // 순서 가져오기
                int require = doungeons[j][0];
                int consum = doungeons[j][1];
                // 현재 피로도가 최소 피로도 보다 같거나 크면
                if (current_k >= require){
                    cnt += 1;
                    current_k -= consum;
                }
            }
            answer = Math.max(answer, cnt);
        }

        return answer;
    }

    static void per1(ArrayList<Integer> arr, int depth, int n, int r){
        if(depth == r) {
            // 이중리스트에 순열 순서 추가
            sequence.add(arr);
            return;
        }

        for(int i = depth; i<n; i++){
            swap(arr, depth, i);
            per1(arr, depth+1, n, r);
            swap(arr, depth, i);
        }
    }

    static void swap(ArrayList<Integer> arr, int depth, int i){
        Collections.swap(arr, depth, i);        // 인덱스depth와 i 데이터 싀왑
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.solution(80, new int[][]{{80, 20}, {50, 40}, {30, 10}});
        System.out.println(answer);
    }
}
