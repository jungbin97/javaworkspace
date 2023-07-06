package sort.baekjoon_수정렬하기_2750;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
        /**********************************************************************
         *
         *
         **********************************************************************/
//        public static void main(String[] args) throws IOException {
//            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//            int N = Integer.parseInt(br.readLine());
//            int[] arr = new int[N];
//
//            for (int i = 0; i<N; i++){
//                arr[i] = Integer.parseInt(br.readLine());
//            }
//
//            // 버블 정렬
//            for(int i=0; i<N; i++){
//                for(int j = 0; j<N-i-1; j++){
//                    if (arr[j] > arr[j+1]){
//                        int temp = arr[j];
//                        arr[j] = arr[j+1];
//                        arr[j+1] = temp;
//                    }
//                }
//            }
//
//            for(int i =0; i<N; i++){
//                System.out.println(arr[i]);
//            }
//        }
        public static void main(String[] args) {
            Scanner s = new Scanner(System.in);

            int N = s.nextInt();
            int[] arr = new int[N];

            for(int i = 0; i < N; i++){
                arr[i] = s.nextInt();
            }

            Arrays.sort(arr);

            for(int i = 0; i<N; i++){
                System.out.println(arr[i]);
            }
        }
}
