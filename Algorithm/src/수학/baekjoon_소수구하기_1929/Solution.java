package 수학.baekjoon_소수구하기_1929;

import java.util.Scanner;

public class Solution {
        /**********************************************************************
         *
         *
         **********************************************************************/
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int M = sc.nextInt();
            int N = sc.nextInt();

            int[] arr = new int[N+1];

            // 배열 초기화
            for(int i = 2; i<=N; i++){
                arr[i] = i;
            }


            // 제곱근 까지만 판별
            for(int i = 2; i <=Math.sqrt(N); i++){
                if (arr[i] == 0) continue;
                // 에라토스테네스의 채 (소수의 배수를 모두 제거)
                for(int j = i+i; j<=N; j=j+i){
                    arr[j] = 0;
                }
            }

            for(int i = M; i<=N; i++){
                if (arr[i] != 0) System.out.println(arr[i]);
            }
        }
}
