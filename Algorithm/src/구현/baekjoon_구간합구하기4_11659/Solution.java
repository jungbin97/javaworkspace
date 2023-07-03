package 구현.baekjoon_구간합구하기4_11659;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
        /**********************************************************************
         *
         *
         **********************************************************************/
        public static void main(String[] args) throws IOException {
            BufferedReader bufferedReader =
                    new BufferedReader(new InputStreamReader(System.in));

            StringTokenizer stringTokenizer =
                    new StringTokenizer(bufferedReader.readLine());

            int N = Integer.parseInt(stringTokenizer.nextToken());
            int M = Integer.parseInt(stringTokenizer.nextToken());

            // 합 배열
            long[]S = new long[N+1];

            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int i = 0; i<N; i++){
                S[i+1] = S[i] + Integer.parseInt(stringTokenizer.nextToken());
            }

            for (int a = 0; a<M; a++){
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                int i = Integer.parseInt(stringTokenizer.nextToken());
                int j = Integer.parseInt(stringTokenizer.nextToken());

                System.out.println(S[j]-S[i-1]);
            }

        }
}
