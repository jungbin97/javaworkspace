package 그래프.baekjoon_집합의표현_1717;

import java.util.Scanner;

public class Solution {
        /**********************************************************************
         * union- find 알고리즘 대표 문제!!
         *
         **********************************************************************/
        static int[] parent;
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            int N = sc.nextInt();
            int M = sc.nextInt();
            parent = new int[N+1];

            // 대표노드 저장
            // 대표노드를 자기 자신으로 초기화
            for(int i = 0; i<=N; i++){
                parent[i] = i;
            }

            for(int i=0; i<M; i++){
                int question = sc.nextInt();
                int a = sc.nextInt();
                int b = sc.nextInt();

                if(question == 0){  // union
                    union(a, b);
                }else{  // find (두 원소 같은지 보기)
                    boolean result= checkSame(a, b);
                    if(result){
                        System.out.println("YES");
                    }else{
                        System.out.println("NO");
                    }
                }
            }
        }

    private static void union(int a, int b) {
            // 대표노드 찾아서 연결
            a = find(a);
            b = find(b);
            if(a != b){
                parent[b] = a;  // 두개 연결
            }
    }

    private static int find(int a) {
            // 인덱스와 값이 같이면 대표노드 자기 자신 반환
        if (a == parent[a]) {
            return a;
        }else{
            // 값을 인덱스로 바꾸어서 재귀로 대표노드를 찾음
            return parent[a] = find(parent[a]);
        }
    }

    private static boolean checkSame(int a, int b){
            a = find(a);
            b = find(b);
            if(a == b){
                return true;
            }else{
                return false;
            }
    }
}
