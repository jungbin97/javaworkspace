package hash.programmers_완주하지못한선수;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    /**********************************************************************
     * 시간 복잡도 : O(N)
     * HashMap 컬렉션 사용(딕셔너리)
     **********************************************************************/
    int hashCount = 0;
    Map<Integer, String> map = new HashMap();

    public String solution(String[] participant, String[] completion){
        for (String par: participant){
            map.put(par.hashCode(), par);
            hashCount += par.hashCode();

        }

        for (String com : completion){
            hashCount -= com.hashCode();
        }

        String answer = map.get(hashCount);
        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String solution= s.solution(new String[]{"mislav", "stanko", "mislav", "ana"}, new String[]{"stanko", "ana", "mislav"});
        System.out.println(solution);
    }
}
