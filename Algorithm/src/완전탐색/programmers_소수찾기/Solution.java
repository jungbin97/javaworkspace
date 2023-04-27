package 완전탐색.programmers_소수찾기;

import java.util.HashSet;

public class Solution {
        /**********************************************************************
         * 1. 순열로 모든 경우의 수 문자열 생성
         * 2. 생성된 문자열을 int 형으로 변환 후 중복 제거
         * 3. 소수 찾기 알고리즘으로 소수 구하기
         **********************************************************************/
        public int solution(String numbers){
                HashSet<Integer> set = new HashSet<>();
                permutation("", numbers, set);
                int count = 0;


                // 경우의 수가 소수인지 확인
                while(set.iterator().hasNext()){
                        int a= set.iterator().next();
                        set.remove(a);
                        if(a==2){
                                count ++;
                        }
                        if(a%2!=0 && isPrime(a)){
                                count ++;
                        }
                }
                return count;

        }

        public boolean isPrime(int n){
                if(n==0 || n==1){
                        return false;
                }

                for(int i = 3; i<=(int)Math.sqrt(n);i++){
                        if(n%i==0){
                                return false;
                        }
                }
                return true;
        }

        public void permutation(String prefix, String str, HashSet<Integer> set){
                int n = str.length();
                if(!prefix.equals("")){
                        // 문자열 정수값으로 변환
                        set.add(Integer.valueOf(prefix));
                }
                for(int i = 0; i < n; i++){
                        permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n), set);
                }
        }


        public static void main(String[] args) {
                Solution s = new Solution();
                int result = s.solution("17");
                System.out.println(result);
        }
}
