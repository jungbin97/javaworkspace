package stack.baekjoon_스택수열_1874;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution {
        /**********************************************************************
         *
         *
         **********************************************************************/
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int N = Integer.parseInt(br.readLine());
            int[] A = new int[N];

            // 배열에 입력 받기
            for (int i=0; i<N; i++){
                A[i] = Integer.parseInt(br.readLine());
            }

            Stack<Integer> stack = new Stack<>();
            int num = 1;
            StringBuffer bf = new StringBuffer();
            boolean result = true;

            for(int i=0; i<N; i++){
                // pop할 숫자
                int current = A[i];
                if (current >= num){
                    while (current >= num){
                        // 숫자 stack 에 push, num ++,
                        stack.push(num++);
                        bf.append("+\n");
                    }
                    stack.pop();
                    bf.append("-\n");
                }else{
                    // stack에 있는 값이 더 큰경우
                    int n = stack.peek();
                    if(n>current){
                        System.out.println("NO");
                        result = false;
                        break;
                    }else{
                        stack.pop();
                        bf.append("-\n");
                    }

                }
            }

            if (result){
                System.out.println(bf.toString());
            }
        }
}
