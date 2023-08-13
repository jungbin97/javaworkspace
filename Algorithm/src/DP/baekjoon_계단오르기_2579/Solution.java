package DP.baekjoon_계단오르기_2579;

import java.util.Scanner;

public class Solution {
    /**********************************************************************
     *
     *
     **********************************************************************/
    static int[] arr = new int[301];
    static int[] dp = new int[301];



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        for (int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        // 각 dp테이블에 올수 있는 값 하드 코딩(이전단계 부터 최댓값)
        dp[0] = arr[0];
        dp[1] = arr[0] + arr[1];
        dp[2] = Math.max(arr[0]+arr[2], arr[1]+arr[2]);

        for(int i = 3; i<n; i++){
            dp[i] = Math.max(dp[i-3]+arr[i-1]+arr[i], dp[i-2]+arr[i]);
        }

        System.out.println(dp[n-1]);
    }
}
