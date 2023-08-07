package DFS_BFS.baekjoon_토마토_7569;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
class tomato{
    int x;
    int y;
    int z;
    public tomato(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}

public class Solution {
    /**********************************************************************
     *
     *
     **********************************************************************/
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        Queue<tomato> q = new LinkedList<tomato>();

        int[] dx = {-1, 1, 0, 0, 0, 0};
        int[] dy = {0, 0, 1, 0, 0, 0};
        int[] dz = {0, 0, 0, 0, 1, -1};

        // 토마토 판 초기화
        int[][][] graph = new int[h][n][m];

        // 토마토 정보 입력
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < m; k++) {
                    graph[i][j][k] = Integer.parseInt(st.nextToken());
                    // 만약 토마토가 익은거라면 큐에 추가해준다.
                    if (graph[i][j][k] == 1) {
                        q.add(new tomato(i, j, k));
                    }
                }
            }

        }
        while(!q.isEmpty()){
            tomato t = q.remove();

            int z = t.z;
            int x = t.x;
            int y = t.y;

            for(int i = 0; i<6;i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                int nz = z + dz[i];
                // 범위 안에 있어야 수행
                if(nx>=0&& ny>=0 && nz>=0&&nx<n&&ny<m&&nz<h){
                    // 토마토가 안익었다면
                    if(graph[nz][nx][ny]==0){
                        // 익게 하고 큐에 추가
                        q.add(new tomato(nz, nx, ny));

                        // 날짜 증가
                        graph[nz][nx][ny] = graph[z][x][y] + 1;
                    }
                }
            }

        }
        int day = 0;

        for(int i = 0; i<h; i++){
            for(int j = 0; j<n; j++){
                for(int k = 0; k<m; k++){
                    // 토마토가 안익은게 있으면
                    if(graph[i][j][k]==0){
                        System.out.println(-1);;
                        break;
                    }
                    day = Math.max(day, graph[i][j][k]);
                }
            }
        }
        // 토마토가 다익은 경우
        if(day==1){
            System.out.println(0);
        }else{
            System.out.println(day-1);
        }
    }
}

