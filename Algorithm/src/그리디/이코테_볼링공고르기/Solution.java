package 그리디.이코테_볼링공고르기;

import java.util.*;

public class Solution {
    /**********************************************************************
     *  1. 두사람이 뽑은 순서는 고려하지 않음(조합)
     *  2. 같은 무게 공은 뽑지 않는다.
     *  단순 이중 for문으로 해결 시간복잡도 : O(N^2)
     **********************************************************************/
//    static ArrayList<Integer> weightList = new ArrayList<>();
//    static int result = 0;
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        // 볼링공 개수 입력받기
//        int N = sc.nextInt();
//
//        // 무게 리스트 초기화
//        for (int i = 0; i < N; i++){
//            weightList.add(sc.nextInt());
//        }
//
//        // 이중 for문으로 확인
//        for(int i = 0; i < N; i++){
//            for (int j = i; j < N; j++){
//               if (weightList.get(i).equals(weightList.get(j))){
//                  continue;
//               }else{
//                   result++;
//               }
//            }
//        }
//        System.out.println(result);
//    }
    /**********************************************************************
     *  1. A가 특정 무게의 볼링공을 선택 후 B가 볼링공을 선택할 때 B는 A선택한 볼링공의 무게를 제외하고 나머지 무게 개수만큼 선택할 수 있다.
     *  2. 순서를 고려하지 않는 조합이므로 (1번공, 2번공)든 (2번공, 1번공)같은 경우라고 고려
     *  그러므로 A가 무게가 2인 공을 고리면 B는 2인 무게보다 큰 경우만 고를수 있다. (이전 단계에서 A가 무게 1인공을 뽑은 경우를 계산했으므로)
     **********************************************************************/
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N, M = 0;
        int result = 0;
        N = sc.nextInt();       // 볼링공 개수
        M = sc.nextInt();       // 최대 무게

//        int[] weightArr = new int[N];         필요 없음
        int[] arr = new int[M+1];   // 볼링공 무게별로 개수
        for(int i=0; i <N; i++){
            int x = sc.nextInt();
            arr[x] += 1;            // 각 무게에 해당하는 볼링공 개수 카운트
        }


        // 1부터 M까지 각 무게에 대해서 처리
        for(int i = 1; i < arr.length; i++){
            N -= arr[i];
            result += arr[i] * N;   // 볼링공 무게 X 자기자신 제외 and 큰 볼링공 개수
        }

        System.out.println(result);
    }
}
