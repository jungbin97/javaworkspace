package sort.programmers_k번째수;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
    /**********************************************************************
     * Arrays.copyOfRange() 메소드 활용
     * copyOfRange(arr, n1, n2)  (원본 배열, 복사할 시작 인덱스, 마지막 인덱스)
     **********************************************************************/
//        public static int[] solution(int[] array,int[][] commands) {
//            int[] answer = new int[commands.length];
//
//            for (int i = 0; i < commands.length; i++) {
//                int[] temp = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
//                Arrays.sort(temp);      // 배열 오름차순 정렬
//                answer[i] = temp[commands[i][2] -1];
//            }
//            return answer;
//        }

    /**********************************************************************
     * 반복문을 사용해 배열 인덱싱
     **********************************************************************/
//    public static int[] solution(int[] array, int[][] commands){
//        int[] answer = new int[commands.length];
//        int n = 0;
//
//        for(int i = 0; i < commands.length; i++){
//            int k = 0;
//
//            int[] list = new int[commands[i][1] - commands[i][0] + 1];      // 배열의 크기 지정
//
//            for (int j = commands[i][0]; j <= commands[i][1]; j++){
//                list[k++] = array[j-1];     // {5,2,6,3}
//            }
//            Arrays.sort(list);              // 오름차순 정렬 {2,3,5,6}
//            answer[n++] = list[commands[i][2] - 1]; // {5,6,3}
//        }
//        return answer;
//    }

    /**********************************************************************
     * 배열 대신 ArrayList 사용
     **********************************************************************/
    public static int[] solution(int[] array, int[][] commands){
        int[] answer = new int[commands.length];    // 3
        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < commands.length; i++){
            for(int j = commands[i][0]; j <= commands[i][1]; j++){
                list.add(array[j-1]);
            }
            Collections.sort(list);
            answer[i] = list.get(commands[i][2]-1);
            list.clear();
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] solution;
        solution = Solution.solution(new int[]{1, 5, 2, 6, 3, 7, 4}, new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}});

        String str=Arrays.toString(solution);
        System.out.println(str);
    }


}
