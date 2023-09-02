package DFS_BFS.쉬운최단거리_14940;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    /**********************************************************************
    *
    *
    **********************************************************************/
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        int startX = 0;
        int startY = 0;

        int[][] arr = new int[n][m];
        int[][] distance = new int[n][m];

        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j<m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                distance[i][j] = -1;
            }
        }

        for(int i = 0; i<n; i++){
            for (int j =0; j<m; j++){
                if(arr[i][j] == 2){
                    startX = i;
                    startY = j;
                    distance[i][j] = 0;
                    break;
                }
            }
        }

        Queue<int []> q = new LinkedList<>();
        q.add(new int[] {startX, startY});

        int[] dx = {-1, 1, 0, 0}, dy = {0,0,1,-1};
        while(!q.isEmpty()){
            int[] xy = q.poll();

            for(int i =0; i<4; i++){
                int nx = xy[0] + dx[i];
                int ny = xy[1] + dy[i];

                if(nx < 0 || nx>=n || ny < 0 || ny >=m){
                    continue;
                }

                if (arr[nx][ny] == 1 && distance[nx][ny] == -1){
                    distance[nx][ny] = distance[xy[0]][xy[1]] + 1;
                    q.add(new int[] {nx, ny});
                }
            }
        }

        for (int i = 0; i<n; i++){
            for (int j =0; j<m; j++){
                if (arr[i][j] == 0) {
                    System.out.print(0 + " ");
                }else {
                    System.out.print(distance[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}
