package 구현.이코테_문자열재정렬;

import java.util.*;

public class Solution {
        /**********************************************************************
         * 1. 문자(대문자)와 숫자 구분
         * 2. 문자 정렬(동적으로 처리 StringBuilder후 정렬)
         * 3. 숫자 합 출력(Character.isDigit로 숫자 판별)
         * 시간복잡도 : 정렬 때문에 O(NlogN)
         **********************************************************************/
//        public static void main(String[] args) {
//            Scanner sc = new Scanner(System.in);
//            String str = sc.next();                         // 문자열 입력 받기
//            int numSum = 0;
//            StringBuffer newStr= new StringBuffer();        // 문자만 저장할 공간
//
//            for(int i = 0; i<str.length(); i++){
//                if (Character.isDigit(str.charAt(i))){     // 숫자이면 true 반환
//                    numSum += (str.charAt(i) - '0');
//                }else{
//                    newStr.append(str.charAt(i));
//                }
//            }
//
//            // 문자열 정렬(오름차순)
//            char[] tmp = newStr.toString().toCharArray();   // StrinBuffer -> String -> Char[] 변환
//            Arrays.sort(tmp);
//            for (int i = 0; i< tmp.length; i++){
//                System.out.print(tmp[i]);
//            }
//            System.out.println(numSum);
//        }

        /**********************************************************************
         *  문자열 처리 최적화
         *  시간 복잡도 : O(N + NlogN) => O(NlogN)
         **********************************************************************/
        public static String str;
        public static ArrayList<Character> result = new ArrayList<>();
        public static int value = 0;

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            str = sc.next();

            // 문자를 하나씩 확인
            for (int i = 0; i < str.length(); i++){
                // 알파벳인 경우 결과 리스트에 삽입
                if(Character.isLetter(str.charAt(i))){
                    result.add(str.charAt(i));
                }
                // 숫자는 따로 처리
                else{
                    value += str.charAt(i) - '0';
                }
            }

            // 알파벳을 오름차순으로 정렬
            result.sort(Comparator.naturalOrder());     // 오름차순
            for (Character character : result) {
                System.out.print(character);
            }
            System.out.println(value);

        }
}
