package DFS_BFS.programmers_게임맵최단거리;

import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    /**********************************************************************
     * 최단 경로이므로 BFS(너비 우선 탐색)으로 접근
     * 목적지에 도달하면 현재 노드의 cost를 반환
     **********************************************************************/
//        int n, m;
//        int[][] visited;
//
//        //상하좌우
//        int[] dx = {0,1,0,-1};
//        int[] dy = {-1,0,1,0};
//
//        public int solution(int[][] maps){
//            // 행, 열 크기
//            n = maps.length;
//            m = maps[0].length;
//
//            // 방문 체크 배열 생성
//            visited = new int[n][m];
//
//            // x, y, maps
//            return BFS(0,0,maps);
//        }
//
//        public int BFS(int x, int y, int[][] maps){
//            // 큐 생성
//            Queue<Node> q = new LinkedList<>();
//            q.offer(new Node(x, y, 1));
//            visited[x][y] = 1;
//
//            while(!q.isEmpty()){
//                // 큐에서 뺴기
//                Node node = q.poll();
//
//                // 도착위치에 도달하면 카운트(cost) 반환
//                if(node.x == n-1 && node.y == m-1){
//                    return node.cost;
//                }
//
//                for(int i =0; i<4; i++){
//                    int nx = node.x + dx[i];
//                    int ny = node.y + dy[i];
//
//                    if(nx >= 0 && ny >=0 && nx<n && ny < m){
//                        if(maps[nx][ny] == 1 && visited[nx][ny] == 0){
//                            visited[nx][ny] = 1;
//                            q.offer(new Node(nx, ny, node.cost+1));
//                        }
//                    }
//                }
//            }
//            return -1;
//        }
//
//        public class Node{
//            int x;
//            int y;
//            int cost;
//
//            // 생성자 메소드
//            public Node(int x, int y, int cost){
//                this.x = x;
//                this.y = y;
//                this.cost = cost;
//            }
//        }
//
//
//    public static void main(String[] args) {
//        Solution s = new Solution();
//        int result = s.solution(new int[][] {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}});
//        System.out.println(result);
//    }
    /**********************************************************************
     * 다른 풀이
     *
     **********************************************************************/
}