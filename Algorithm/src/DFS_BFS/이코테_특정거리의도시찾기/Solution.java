package DFS_BFS.이코테_특정거리의도시찾기;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
        /**********************************************************************
         * BFS(너비 우선 탐색)으로 현재 노드와 연결되 있는 노드(도착노드)가 거리 테이블이 -1이면 갱신한다. => 최단 거리
         * 시간복잡도 : 최단거리 테이블 초기화 O(N) + BFS알고리즘 출발도시에서 모든 도시를 방문하며 각도로가 한번만 통과하므로 O(M)
         * O(N+M)
         **********************************************************************/
        // 도시의 개수, 도로의 개수, 거리정보, 출발 도시 번호
        public static int n, m, k, x;
        public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        // 모든 도시에 대한 최단 거리 초기화
        public static int[] d = new int[300001];

        public static void main(String[] args) {
            Scanner sc= new Scanner(System.in);

            n = sc.nextInt();
            m = sc.nextInt();
            k = sc.nextInt();
            x = sc.nextInt();

            //  그래프 최단 거리 테이블 초기화
            for(int i = 0; i <= n; i++){
                graph.add(new ArrayList<>());
                d[i] = -1;
            }

            // 모든 도로 정보 입력 받기
            for(int i = 0; i <m; i++){
                int a = sc.nextInt();
                int b = sc.nextInt();
                graph.get(a).add(b);
            }

            // 출발 도시까지의 거리는 0으로 설정
            d[x] = 0;

            // 너비 우선 탐색(BFS) 수행
            Queue<Integer> q = new LinkedList<>();
            q.offer(x);
            while(!q.isEmpty()){
                int now = q.poll();
                // 현재 도시에서 이동할 수 있는 모든 도시 확인
                for(int i = 0; i<graph.get(now).size(); i++){
                    int nextNode = graph.get(now).get(i);
                    // 아직 방문하지 않은 도시면
                    if(d[nextNode] == -1){
                        // 최단 거리 갱신
                        d[nextNode] = d[now]+1;
                        q.offer(nextNode);
                    }
                }
            }

            // 최단 거리가 k인 모든 도시의 번호를 오름차순으로 출력
            boolean check = false;
            for(int i = 1; i <= n; i++){
                if(d[i] == k){
                    System.out.println(i);
                    check = true;
                }
            }

            // 만약 최단 거리가 k인 도시가 없다면 -1 출력
            if(!check){
                System.out.println(-1);
            }
        }
}
