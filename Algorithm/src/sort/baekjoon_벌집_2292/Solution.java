package sort.baekjoon_벌집_2292;

import java.util.Scanner;

public class Solution {
        /**********************************************************************
         *
         *
         **********************************************************************/
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            int n = sc.nextInt();
            int house = 1;
            int cnt = 1;

            while (n > house){
                house += 6*cnt;
                cnt += 1;
            }

            System.out.println(cnt);

        }
}
