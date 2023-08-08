package DFS_BFS.baekjoon_바이러스_2606;

import java.util.Scanner;

public class Solution {
        /**********************************************************************
         *
         *
         **********************************************************************/
        static int n,m;
        static int[][] graph;
        static boolean[] visited;
        static int count = 0;
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            // n 컴퓨터 개수, m 간선 개수
            n = sc.nextInt();
            m = sc.nextInt();

            graph = new int[n+1][n+1];
            visited = new boolean[n+1];
            for(int i= 0; i<m; i++){
                int a = sc.nextInt();
                int b = sc.nextInt();
                graph[a][b] = graph[b][a]=1;
            }
            System.out.println(dfs(1));

        }

    private static int dfs(int i) {
            visited[i] = true;
            for(int j=1; j<=n; j++){
                if(graph[i][j] ==1 && !visited[j]){
                    count ++;
                    dfs(j);
                }
            }
            return count;
    }
}
