package DP.baekjoon_1로만들기_1463;

import java.util.Scanner;

public class Solution {
        /**********************************************************************
         * bottom up 방식
         *
         **********************************************************************/
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            int n = sc.nextInt();
            // dp 테이블
            int[] d = new int[n+1];


            for (int i = 2; i<=n; i++){
                // 1을 뺸경우를 선택 한 값
                d[i] = d[i-1]+1;
                if(i%3==0){
                    d[i] = Math.min(d[i], d[i/3]+1);
                }
                if(i%2==0){
                    d[i] = Math.min(d[i], d[i/2]+1);
                }
            }

            System.out.println(d[n]);
        }
}
