package 이진탐색.baekjoon_수찾기_1920;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
        /**********************************************************************
         * 정렬 시간 복잡도 : O(NlogN)
         * 이진 탐색 시간 복잡도 : O(MlogN)
         * 최종 시간 복잡도 : O(MlogN)
         **********************************************************************/
        public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                int N = sc.nextInt();
                int[] A = new int[N];

                for (int i = 0; i < N; i++) {
                        A[i] = sc.nextInt();
                }
                Arrays.sort(A);

                int M = sc.nextInt();

                for (int i = 0; i < M; i++) {
                        int target = sc.nextInt();
                        boolean find = false;
                        int start = 0;
                        int end = A.length - 1;

                        while(start <= end){
                                int midIdx = (start+end)/2;
                                int midValue = A[midIdx];

                                if(midValue > target){
                                        end = midIdx - 1;
                                }else if (midValue < target){
                                        start = midIdx + 1;
                                }else {
                                        find = true;
                                        break;
                                }
                        }

                        if(find) System.out.println(1);
                        else System.out.println(0);
                }

        }
}