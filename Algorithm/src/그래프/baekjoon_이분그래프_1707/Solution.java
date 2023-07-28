package 그래프.baekjoon_이분그래프_1707;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Solution {
        /**********************************************************************
         *
         *
         **********************************************************************/
        static ArrayList<Integer>[] A;
        static int[] check;
        static boolean[] visited;
        static boolean IsEven;
        public static void main(String[] args) throws Exception{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            int testCase = Integer.parseInt(br.readLine());

            for(int t = 0; t < testCase; t++){  // 주어진 테스트 케이스만큼 돌려준다.
                // 노드의 개수 V, 엣지의 개수 E
                String[] s = br.readLine().split(" ");
                int V = Integer.parseInt(s[0]);
                int E = Integer.parseInt(s[1]);

                A = new ArrayList[V+1];
                visited = new boolean[V+1];
                check = new int[V+1];
                IsEven = true;

                for(int i = 1; i<= V; i++){
                    A[i] = new ArrayList<Integer>();
                }

                // 에지 데이터 저장하기
                for(int i = 0; i<E; i++){
                    s = br.readLine().split(" ");
                    int start = Integer.parseInt(s[0]);
                    int end = Integer.parseInt(s[1]);

                    // 양 방향(무방향)
                    A[start].add(end);
                    A[end].add(start);
                }
                // 노드가 연결되있지 않는 경우도 있으므로 => 모든 노드에 대해 DFS 싦행
                for(int i = 1; i<=V; i++){
                    if(IsEven){
                        DFS(i);
                    }else{
                        break;
                    }
                }

                if(IsEven) System.out.println("YES");
                else System.out.println("NO");

            }

        }

    private static void DFS(int start) {
            visited[start] = true;
            for(int i : A[start]){  // 인접 리스트 이기때문에 start에 연결된 모든 노드 탐색
                if (!visited[i]) {
                    // 그전에 있는 노드와 다른 집합으로 분류를 해주는 것이 필요
                    check[i] = (check[start]+1) % 2;
                    DFS(i);
                }else{
                    if(check[start]==check[i]){
                        IsEven = false;
                    }
                }
            }
    }
}
