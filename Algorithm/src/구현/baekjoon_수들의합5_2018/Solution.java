package 구현.baekjoon_수들의합5_2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
        /**********************************************************************
         *
         *
         **********************************************************************/
        public static void main(String[] args) throws IOException {
            BufferedReader bufferedReader =
                    new BufferedReader(new InputStreamReader(System.in));
            int N = Integer.parseInt(bufferedReader.readLine());
            int startPoint = 1;
            int endPoint = 1;
            int count = 1;
            int sum = 1;

            while(endPoint != N){
                // count 증가, endPoint 증가, sum + endPoint
                if (sum == N){
                    count++;
                    endPoint++;
                    sum += endPoint;
                }else if (sum>N){   // startPoint감소, sum-startPoint
                    sum -= startPoint;
                    startPoint++;
                } else if (sum < N) {   // endPoint증가, sum+endPoint
                    endPoint++;
                    sum+=endPoint;
                }
            }
            System.out.println(count);
        }
}
