package sort.이코테_국영수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution {
        /**********************************************************************
         *
         *
         **********************************************************************/
        public static void main(String[] args) throws IOException{
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

                // 학생 수 입력 받기
                int N = Integer.parseInt(br.readLine());

                // 이름, 국어, 영어, 수학 점수 입력받기
                String [][] arr = new String[N][4];
                for(int i = 0; i < N; i++){
                        StringTokenizer st = new StringTokenizer(br.readLine());

                        arr[i][0] = st.nextToken();
                        arr[i][1] = st.nextToken();
                        arr[i][2] = st.nextToken();
                        arr[i][3] = st.nextToken();
                }

                // 정렬 커스터마이징
                Arrays.sort(arr, new Comparator<String[]>(){

                        @Override
                        public int compare(String[] o1, String[] o2){
                                if(o1[1].equals(o2[1])){
                                        if (o1[2].equals(o2[2])){
                                                if(o1[3].equals(o2[3])){
                                                        return o1[0].compareTo(o2[0]);  // 사전순 오름차순
                                                }
                                                return Integer.parseInt(o2[3])-Integer.parseInt(o1[3]);   // 수학점수 내림차순
                                        }
                                        return Integer.parseInt(o1[2])-Integer.parseInt(o2[2]);         // 영어 점수 오름차순
                                }
                                return Integer.parseInt(o2[1])-Integer.parseInt(o1[1]);       // 국어 점수 내림차순
                        }
                });

                for(int i = 0; i<arr.length; i++){
                        System.out.println(arr[i][0]);
                }
        }
}
