package 그리디.이코테_문자열뒤집기;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    /**********************************************************************
     * 뒤집기 횟수가 최소가 되려면 0과 1의 그룹이 각각 몇개인지 알아내서 둘 중 최소값을 반환하면된다.
     * 그룹의 개수 => 회전횟수 => 최소그룹 개수 찾기
     **********************************************************************/

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.nextLine();
        int[] list = new int[2];    // 그룹의 갯수 저장할 배열

        int result = S.charAt(0) - '0';

        // 첫번째 원소그룹에 대해 처리
        if (result == 0){
            list[0] += 1;
        }else{
            list[1] += 1;
        }

        for(int i = 1; i<S.length(); i++){
            int num = S.charAt(i) - '0';
            if(result == num){
                result = num;
                continue;
            } else if (result != num) {
                if(num == 0){
                    list[0] +=1;
                    result = num;
                }else{
                    list[1] += 1;
                    result = num;
                }
            }
        }
        System.out.println(Math.min(list[0], list[1]));
    }
}
