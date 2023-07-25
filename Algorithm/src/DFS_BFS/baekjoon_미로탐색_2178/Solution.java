package DFS_BFS.baekjoon_미로탐색_2178;

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
	static int n;
	static int m;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][m];	// 미로지도 초기화

		for(int i = 0; i<n; i++){
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			for(int j = 0; j<m; j++){
				map[i][j] = str.charAt(j) - '0';	// str => int 변환
			}
		}

		search(0, 0);

		System.out.println(map[n-1][m-1]);

	}

	public static void search(int x, int y){
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {x, y});

		// 이동 좌표 상하좌우
		int[] dx = {-1,1,0,0};
		int[] dy = {0,0,-1,1};

		while(!queue.isEmpty()){	//큐에 들어간 좌표 탐색이 모두 끝날때가지 반복
			int[] xy = queue.poll();

			for(int i=0; i < 4; i++){
				int nx = xy[0] + dx[i];
				int ny = xy[1] + dy[i];

				// 미로를 벗어 날경우
				if (nx<0 || nx >=n || ny < 0 || ny >= m){
					continue;
				}

				if (map[nx][ny] == 0){
					continue;
				}

				if (map[nx][ny] == 1) {
					map[nx][ny] = map[xy[0]][xy[1]] + 1;
					queue.add(new int[] {nx, ny});
				}
			}

		}
	}
}