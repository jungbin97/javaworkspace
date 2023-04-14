package sort.이코테_안테나;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.*;

public class Solution {
        /**********************************************************************
         * 제한 사항 :
         *  1. 안테나는 집이 있는 위치만 설치가능
         *  2. 집은 같은 위치에 여러개 존재 (중복 제거해야함)
         *
         *  1. 무작위 입력값 중복 제거
         *  2. 정렬 (오름차순)
         *  3. 각 원소를 순차탐색하면서 모든 집까지의 거리를 구한후 더한다.
         *  4. 각 값중 최소 거리를 가지는 집 위치 반환
         *  시간복잡도 : O(NlogN) + O(N^2) => O(N^2)
         **********************************************************************/
//        public static void main(String[] args) throws IOException{
//                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//                // 집 개수 입력 받기
//                int N = Integer.parseInt(br.readLine());
//
//                // 집위치 배열
//                HashSet<Integer> arr = new HashSet<>();
//                // 입력 받기
//                StringTokenizer st = new StringTokenizer(br.readLine());
//
//                for(int i = 0; i<N; i++){
//                        arr.add(Integer.valueOf(st.nextToken()));
//                }
//
//                // 정렬(HashSet(순서를 보장하지 않으므로) => List로 변환)
//                ArrayList<Integer> arr1 = new ArrayList<>(arr);
//                arr1.sort(Comparator.naturalOrder());   // 오름 차순 정렬
//
//
//                int result = 100001;
//                int antannaLocation = 0;
//                for(Integer i : arr1){
//                        int distanceSum = 0;
//                        int a = i;    // 안테나 설치 위치
//                        for (Integer j : arr1){
//                                int b = j;    // 비교할 위치
//                                distanceSum += Math.abs(b-a); // 거리의 총합
//                        }
//
//                        if(result > distanceSum){        // 작으면 현재 안테 설치위치 저장
//                                result = distanceSum;
//                                antannaLocation = a;
//                        }
//                }
//                System.out.println(antannaLocation);
//        }
        /**********************************************************************
         * 가장 중간위치에 있는 집이 모든 거리 총합에 대해 최소값이므로
         * 가장 중간위치의 집 위치를 출력한다.
         * 시간 복잡도 : O(NlogN)
         **********************************************************************/
        public static void main(String[] args) throws IOException{
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

                // 집 개수 입력
                int N = Integer.parseInt(br.readLine());

                ArrayList<Integer> arrayList = new ArrayList<>();
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int i = 0; i<N; i++){
                        arrayList.add(Integer.parseInt(st.nextToken()));
                }

                // 정렬 (오름차순)
                Collections.sort(arrayList);

                // 중간값 출력
                System.out.println(arrayList.get((N-1)/2));
        }
}
