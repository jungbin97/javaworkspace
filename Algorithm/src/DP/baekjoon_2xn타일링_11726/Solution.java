package DP.baekjoon_2xn타일링_11726;

import java.util.Scanner;

public class Solution {
        /***********************************************************************
         *
         *
         **********************************************************************/
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            int n = sc.nextInt();

            long dp[] = new long[1001];

            dp[1] = 1;  // N이 1일때 타일 경우의 수
            dp[2] = 2;  // N이 2일때 타일 경우의 수

            for(int i = 3; i<=n; i++){
                dp[i] = (dp[i-1] + dp[i-2])%10007;
            }
            System.out.println(dp[n]);
        }
}
