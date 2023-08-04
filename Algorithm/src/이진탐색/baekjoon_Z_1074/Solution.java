package 이진탐색.baekjoon_Z_1074;

import java.util.Scanner;

public class Solution {
        /**********************************************************************
         *
         *
         **********************************************************************/
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            String[] arr = sc.nextLine().split(" ");

            int n = Integer.parseInt(arr[0]);
            int r = Integer.parseInt(arr[1]);
            int c = Integer.parseInt(arr[2]);

            int answer = 0;

            while(n!=0){
                n -= 1;
                // 1사분면
                if(r<Math.pow(2,n) && c<Math.pow(2, n)){
                    answer += (Math.pow(2,n)*(Math.pow(2,n)))*0;
                }
                else if (r<Math.pow(2,n) && c >=Math.pow(2,n)){
                    answer += (Math.pow(2,n))*(Math.pow(2,n))*1;
                    c -= Math.pow(2,n);
                } else if (r >= Math.pow(2, n) && c < Math.pow(2, n)) {
                    answer += (Math.pow(2,n))*(Math.pow(2,n))*2;
                    r -= Math.pow(2,n);
                }else{
                    answer += Math.pow(2,n)*Math.pow(2,n)*3;
                    r -= Math.pow(2,n);
                    c -= Math.pow(2,n);
                }
            }
            System.out.println(answer);





        }
}
