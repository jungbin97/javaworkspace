package sort.이코테_실패율;

import java.util.*;

public class Solution {
        /**********************************************************************
         * 실패율 = (스테이지 도달했으나 아직 클리어 못한 플레이어수) / (스테이지에 도달한 플레이어 수)
         * 스테이지에 도달했으나 아직 클리어 못한 플레이어 수
         * => 현재 멈춰있는 스테이지 번호가 n보다 크거나 같은 플레이어 수
         * => stages[]에서 값이 n보다 크거나 같은 요소 개수
         *
         * 스테이지에 도달한 플레이어의 수
         * => 현재 멈춰있는 스테이지 번호가 n 보다 크거나 같은 플레이어 수
         * => stages[]에서 값이 n보다 크거나 같은 요소 개수
         *
         * 시간 복잡도 : O(N) + O(N) + O(NlogN) => O(NlogN)
         **********************************************************************/

        public static void main(String[] args) {

                int N = 5;
                int[] stages = {2, 1, 2, 6, 4, 3, 3};
                HashMap<Integer, Double> map = new HashMap<>();
                int[] userFailCnts = new int[N + 2];       // 각스테이지에 머물러 있는 플레이어 수
                int[] userTotalCnts = new int[N + 1];     // 각 스테이지에 도달한 플레이어 수

                // 스페이지 별 머물러 있는 플레이어 수 카운드
                for (int stage : stages) {
                        userFailCnts[stage]++;
                }

                // 스테이지 별 도달한 플레이어 수 카운드
                userTotalCnts[N] = userFailCnts[N] + userFailCnts[N + 1];
                for (int i = N - 1; i >= 1; i--) {
                        userTotalCnts[i] = userFailCnts[i] + userTotalCnts[i + 1];
                }

                // 스테이별 실패율 계산
                for (int i = 1; i < userTotalCnts.length; i++) {
                        if (userFailCnts[i] == 0 || userTotalCnts[i] == 0) {
                                map.put(i, 0.0);
                        } else {
                                map.put(i, (double) userFailCnts[i] / userTotalCnts[i]);
                        }
                }

                // 실패율(value) 값으로 스테이지 번호(key)를 내림차순 정렬
                List<Integer> list = new ArrayList<>(map.keySet());
                Collections.sort(list, new Comparator<Integer>() {
                        @Override
                        public int compare(Integer o1, Integer o2) {
                                double diff = map.get(o2) - map.get(o1);
                                if (diff > 0) {
                                        return 1;
                                } else if (diff < 0) {
                                        return -1;
                                } else {
                                        return o1 - o2;          // 실패율이 같다면 작은 번호 스테이지가 먼저 오도록함(오름차순)
                                }
                        }
                });

                System.out.println(Arrays.deepToString(list.toArray()));
        }

}
