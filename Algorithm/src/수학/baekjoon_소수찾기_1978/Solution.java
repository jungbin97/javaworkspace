package 수학.baekjoon_소수찾기_1978;

import java.util.Scanner;

public class Solution {
        /**********************************************************************
         *
         *
         **********************************************************************/
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int cnt = 0;

            int[] arr = new int[n];

            for (int i =0; i<n; i++){
                int tmp = sc.nextInt();
                arr[i] = tmp;
            }

            for (int i = 0; i<n; i++){
                // 1제외 하기
                if(arr[i]==0 || arr[i]==1){
                    continue;
                }

                if (prime(arr[i])){
                    cnt += 1;
                }
            }
            System.out.println(cnt);
        }

    private static boolean prime(int x) {
            for(int i = 2; i <= Math.sqrt(x); i++){
                if (x%i==0){
                    return false;
                }
            }
            return true;
    }
}
