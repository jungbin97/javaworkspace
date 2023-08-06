package 그리디.baekjoon_리모컨_1107;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
        /**********************************************************************
         *
         *
         **********************************************************************/
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(br.readLine());
            int m = Integer.parseInt(br.readLine());

            ArrayList<Integer> arr = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int i = 0; i<m; i++){
                int num = Integer.parseInt(st.nextToken());
                arr.add(num);
            }

            // +, - 버튼으로만 움직였을 떄 횟수
            int answer = Math.abs(100-n);

            for(int i = 0; i<=999999; i++){
                String str = String.valueOf(i);
                boolean check = true;

                for(int k = 0; k<str.length(); k++){
                    if(arr.contains(str.charAt(k)-'0')){
                        check = false;
                        break;
                    }
                }
                if(check) {
                    answer = Math.min(str.length() + Math.abs(i-n), answer);
                }
            }
            System.out.println(answer);
        }

}
