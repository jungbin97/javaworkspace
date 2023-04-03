package 완전탐색.전력망을둘로나누기;
import java.util.*;

public class Solution {
    /**********************************************************************
     * 연결된 간선을 모두 끊어 BFS로 노드 개수 카운트(완전 탐색)
     * 시간 복잡도 : O(N^2)
     **********************************************************************/

    static ArrayList<Integer> list[];

    public int solution(int n, int[][] wires){
        int answer = 100;

        // 간선 정보를 graph에 초기화
        list = new ArrayList[n+1];
        // 2차 배열
        for(int i = 1; i<=n; i++){
            list[i] = new ArrayList<>();
        }

        // 양방향 연결
        for(int i = 0; i < wires.length; i++){
            list[wires[i][0]].add(wires[i][1]);
            list[wires[i][1]].add(wires[i][0]);
        }

        //그래프 연결 하나씩 끊고 bfs로 탐색
        for(int i = 0; i< wires.length; i++) {
            int n1 = bfs(wires[i][0], wires[i][1], n);

            // 노드 개수  차이(전체 노드 - n1)는 나머지 또다른 전력망
            answer = Math.min(answer, Math.abs(n1 - (n - n1)));
        }
        return answer;
    }

    public static int bfs(int v1, int v2, int n){
        Queue<Integer> q = new LinkedList<>();
        boolean visited[] = new boolean[n+1];

        int count = 0;
        // v1 Queue 삽입 및 방문처리
        q.add(v1);
        visited[v1] = true;

        while(!q.isEmpty()){
            int cur = q.poll();
            count++;

            for(int next: list[cur]){
                if(!visited[next] && next != v2){   // v2를 방문하지 않도록 체크(연결 끊음)
                    q.add(next);
                    visited[next] = true;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int result = s.solution(9, new int[][]{{1,3}, {2,3}, {3,4}, {4,5}, {4,6}, {4,7}, {7,8}, {7,9}});
        System.out.println(result);
    }
}
