package 구현.이코테_럭키스트레이트;

import java.util.Scanner;

public class Solution {
        /**********************************************************************
         * 점수 N은 항상 짝수로 입력되므로 문자열로 절반 나눠서 인덱스 탐색
         * 시간 복잡도 : O(N)
         **********************************************************************/
//        public static void main(String[] args) {
//            Scanner sc = new Scanner(System.in);
//            String N = sc.next();
//
//            int leftIdx = (N.length()/2)-1;
//            int leftSum = 0;
//            int rightSum = 0;
//            for(int i = 0; i < N.length(); i++){
//                if (i<= leftIdx){
//                    leftSum += N.charAt(i)-'0';
//                }else{
//                    rightSum += N.charAt(i)-'0';
//                }
//            }
//
//            if (leftSum == rightSum){
//                System.out.println("LUCKY");
//            }
//            else {
//                System.out.println("READY");
//            }
//
//        }
    /**********************************************************************
     * 변수 사용 개선 코드
     * 시간 복잡도 : O(N)
     **********************************************************************/
    public static String str;
    public static int summary = 0;

        public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);
            str = sc.next();

            // 왼쪽 부분 자리수 합 더하기
            for(int i = 0; i < str.length()/ 2; i++){
                summary += str.charAt(i) - '0';
            }

            // 오른쪽 부분의 자리수의 합 빼기
            for(int i = str.length()/ 2; i < str.length(); i++){
                summary -= str.charAt(i) - '0';
            }

            // 왼쪽 부분과 오른쪽 부분의 자리수의 합이 동일한지 검사
            if(summary == 0){
                System.out.println("LUCKY");
            }else{
                System.out.println("READY");
            }
        }
}
