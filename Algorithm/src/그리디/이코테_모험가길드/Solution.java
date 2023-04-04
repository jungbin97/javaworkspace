package 그리디.이코테_모험가길드;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Solution {
    /**********************************************************************
     * 그룹수의 최대값을 구하기 => 최소한의 인원으로 그룹 생성
     * 1. 모험가 공포도 리스트를 오름차순으로 정렬
     * 2. 현재 파티의 인원수가 모험가 공포도보다 같거나 클 때 그룹 수를 증가 시긴다.
     **********************************************************************/
    // 모험가 인원
    static int N = 0;
    // 공포도 리스트
    static ArrayList<Integer> arrayList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        //공포도 리스트 초기화
        for (int i = 0; i < N; i++){
            arrayList.add(sc.nextInt());
        }
        // 공포도 리스트 정렬
        Collections.sort(arrayList);

        int result = 0;
        int count = 0;

        for (int i=0; i < N; i++){      // 공포도 낮은 것 부터 하나씩 확인
            count += 1;
            if(count >= arrayList.get(i)){
                result += 1;    // 그룹수 증가 시키기
                count = 0;  // 모험가 수 초기화
            }
        }
        System.out.println(result);
    }
}
