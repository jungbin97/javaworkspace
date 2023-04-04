package 완전탐색.모음사전;

import java.util.ArrayList;
import java.util.List;
class Solution {
    /**********************************************************************
     * 재귀함수로 생성될 수 있는 모든 경우의 수 생성
     * word (원하는 문자열)의 위치를 반환
     * 문자 개수 5개로 제한 => 전체 3905개 생성
     **********************************************************************/
//    static String[] arr;
//    static List<String> list;
//    public int solution(String word) {
//        int answer = 0;
//
//        list = new ArrayList<>();
//        arr = new String[]{"A", "E", "I", "O", "U"};
//        // 완전탐색 메서드 호출(모든 경우의 수 생성)
//        recursion(word, "", 0);
//
//        // 선형 탐색
//        for (int i = 0; i < list.size(); i++) {
//            if(list.get(i).equals(word)) {
//                answer = i;
//                break;
//            }
//        }
//        return answer;
//    }
//
//    // 완전탐색 메서드
//    static void recursion(String word, String str, int depth) {
//        list.add(str);
//
//        if(depth == 5) {
//            return;
//        }
//
//        for (int i = 0; i < arr.length; i++) {
//            recursion(word, str + arr[i], depth + 1);
//        }
//    }

    /**********************************************************************
     * 수학적으로 접근
     **********************************************************************/

    static final String MAPPING = "AEIOU";
    static final int[] RATE_OF_INCRESE = {781, 156, 31, 6, 1};

    public int solution(String word) {
        int answer = word.length();     // 1 * (문자 갯수)

        for(int i = 0; i < word.length(); i++){
            int idx = MAPPING.indexOf(word.charAt(i));
            answer += RATE_OF_INCRESE[i] * idx;         // 각 숫자가 변하기 위한 수  * A와떨어진 거리(인덱스)
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int result = s.solution("AAAE");
        System.out.println(result);
    }
}
