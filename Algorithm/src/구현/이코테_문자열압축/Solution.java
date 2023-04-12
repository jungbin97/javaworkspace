package 구현.이코테_문자열압축;

import java.util.ArrayList;

public class Solution {
    /**********************************************************************
     * 문자열 1~ 절반까지 단위로 자를떄 압축한 길이를 저장
     * 시간복잡도 : O(N/2 * N) => O(N^2)
     **********************************************************************/
    public int solution(String s) {
        int answer = s.length();
        //문자열 압축 단위 1~ 절반까지
        for (int i = 1; i <= s.length() / 2; i++) {
            String target = s.substring(0, i);    // 시작 문자열
            String cur = "";                    // 비교할 문자열
            int cnt = 1;                        // 압축카운트(시작문자열 때문에 1로 초기화)
            StringBuilder sb = new StringBuilder();    // 압축 문자열

            for (int start = i; start <= s.length(); start += i) {
                // 비교할 현재 문자열 세팅

                // 다음 비교할 문자열의 길이가 전체 문자열 보다 클 경우
                // 남은 문자열 그대로 저장
                if (start + i >= s.length()) {
                    cur = s.substring(start, s.length());
                } else {
                    cur = s.substring(start, start + i);
                }

                // 시작 문자열과 비교할 문자열과 같으면 압축카운트 증가
                if (target.equals(cur)) {
                    cnt++;
                }
                // 다르면 압축된 문자열을 추가 시작 문자열 변경
                else if (cnt == 1) {    // 문자만
                    sb.append(target);
                    target = cur;
                } else {    // 압축카운트 + 문자
                    sb.append(cnt).append(target);
                    target = cur;
                    cnt = 1;    // 새로운 문자 비교 이므로 압축카운트 초기화
                }
            }
            // 자르고 마지막에 남는 문자열 그대로 추가
            if (i != target.length()) {
                sb.append(target);
            }
            answer = Math.min(answer, sb.toString().length());
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int reuslt = s.solution("abcabcabcabcdededededede");
        System.out.println(reuslt);
    }
}
