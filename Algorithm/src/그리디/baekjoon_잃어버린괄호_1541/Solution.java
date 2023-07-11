package 그리디.baekjoon_잃어버린괄호_1541;

import java.util.Scanner;

public class Solution {
        /**********************************************************************
         *  String[] str = s.split("[+]") 부분
         *  + 인식 부분 버그 발생 대괄호로 묶어줌
         **********************************************************************/
        public static void main(String[] args) {
            int answer = 0;
            Scanner sc = new Scanner(System.in);
            String example = sc.nextLine();
            String[] str = example.split("-");
            
            for(int i = 0; i<str.length; i++){
                int temp = mySum(str[i]);
                if (i==0){
                    answer += temp;
                }else{
                    answer -= temp;
                }
            }
            System.out.println(answer);
        }

    private static int mySum(String s){
            int sum = 0;
            String[] str = s.split("[+]");
            for(int i = 0; i<str.length; i++){
                sum += Integer.parseInt(str[i]);
            }
            return sum;
    }
}
