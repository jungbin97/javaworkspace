package 그리디.이코테_곱하기혹은더하기;

import java.util.*;

public class Solution {
    static String S;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        S = sc.nextLine();      // 문자열 입력 받음

        // 문자열을 정수값으로 변환
        int result = S.charAt(0)-'0';
        for(int i = 1; i <S.length(); i++){
            // 두 수중 하나만 0 or 1이면 곱하기보다 더하기 연산
            int num = S.charAt(i)-'0';
            if (num <= 1 || result <= 1){
                result += num;
            }
            else{
                result *= num;
            }
        }
        System.out.println(result);
    }
}
