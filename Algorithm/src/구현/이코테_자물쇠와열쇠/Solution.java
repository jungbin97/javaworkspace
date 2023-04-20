package 구현.이코테_자물쇠와열쇠;

public class Solution {
    /**********************************************************************
     * 완전 탐색
     * 1. 열쇠가 자물쇠 영역을 벗어날수 있으므로 자물쇠 크기가 3배인 새로운 리스트로 만들어 중앙부분으로 옮긴다.
     * 2. 열쇠 배열을 왼쪽 위부터 시작해서 한칸씩 이동하는 방식으로 자물쇠의 모든 홈을 채울 수 있는지 확인(새로운 자물쇠 리스트에 열쇠리스트의 값을 더한뒤 기존 자물쇠 영역이 모두 1인지 확인)
     * 3. 열쇠 리스트를 90도로 회전해서 2번 반복
     **********************************************************************/
    // 2차원 리스트 90도 회전하기
    public static int[][] rotateMatrixBy90Degree(int[][] a){
        int n = a.length;
        int m = a[0].length;
        int[][] result = new int[n][m]; // 결과 리스트
        for(int i=0; i < n; i++){
            for (int j = 0; j < m; j++){
                result[j][n-i-1] = a[i][j];
            }
        }
        return result;
    }

    // 자물쇠의 중간 부분의 모두 1인지 확인
    public static boolean check(int[][] newLock){
        int lockLength = newLock.length / 3;
        for(int i = lockLength; i < lockLength*2; i++){
            for(int j = lockLength; j < lockLength * 2; j++){
                if(newLock[i][j] != 1){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean solution(int[][] key, int[][] lock){
        int n = lock.length;
        int m = key.length;
        // 자물쇠의 크기를 기존의 3배로 변환
        int[][] newLock = new int[n*3][n*3];
        // 새로운 자물쇠의 중앙 부분에 기존의 자물쇠 넣기
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                newLock[i+n][j+n] = lock[i][j];
            }
        }

        // 4가지 방향에서 확인
        for(int rotation = 0; rotation < 4; rotation++){
            key = rotateMatrixBy90Degree(key);  // 열쇠 회전
            for(int x = 0; x < n * 2+1; x++){
                for(int y = 0; y < n * 2+1; y++){
                    // 자물쇠에 열쇠를 끼워 넣기
                    for(int i = 0; i < m; i++){
                        for(int j = 0; j < m; j++){
                            newLock[x+i][y+j] += key[i][j];
                        }
                    }

                    // 새로운 자물쇠에 열쇠가 정확히 들어 맞는지 검사
                    if(check(newLock)){
                        return true;
                    }

                    // 자물쇠에서 열쇠를 다시 뺴기
                    for(int i = 0; i<m; i++){
                        for(int j = 0; j < m; j++){
                            newLock[x+i][y+j] -= key[i][j];
                        }
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(new int[][]{{0,0,0},{1,0,0},{0,1,1}}, new int[][]{{1,1,1},{1,1,0},{1,0,1}}));
    }
}
