package hash.programmers_완주하지못한선수;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    /**********************************************************************
     * 시간 복잡도 : O(N)
     * HashMap 컬렉션 사용(딕셔너리)
     **********************************************************************/
//    int hashCount = 0;
//    Map<Integer, String> map = new HashMap();
//
//    public String solution(String[] participant, String[] completion){
//        for (String par: participant){
//            map.put(par.hashCode(), par);
//            hashCount += par.hashCode();
//
//        }
//
//        for (String com : completion){
//            hashCount -= com.hashCode();
//        }
//
//        String answer = map.get(hashCount);
//        return answer;
//    }

    /**********************************************************************
     * HashMap 컬렉션 getOrDefault 메서드 사용
     * 메소드 원형 : getOrDefault(Object, key, V DefaultValue)
     * key값과 매핑되는 값이 없으면 DefaultValue 반환
     * HashMap안에 동일한 key 있는 경우 저장되있는값 다시 반환
     **********************************************************************/
    public String solution(String[] particiapnt, String[] completion){
        String answer = "";
        HashMap<String, Integer> map = new HashMap<>();
        for(String par : particiapnt){
            map.put(par, map.getOrDefault(par, 0)+1);
        }

        for(String com : completion){
            map.put(com, map.get(com)-1);
        }

        for (String key : map.keySet()){
            if(map.get(key)!= 0){
                answer = key;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String solution= s.solution(new String[]{"mislav", "stanko", "mislav", "ana"}, new String[]{"stanko", "ana", "mislav"});
        System.out.println(solution);
    }
}
