package 슬라이딩윈도우.baekjoon_DNA비밀번호_12891;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Solution {
    /**********************************************************************
     *
     *
     **********************************************************************/
    static int myArr[];
    static int checkArr[];
    static int checkSecret;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        int result = 0;

        // 체크 배열
        checkArr = new int[4];
        // 현재 개수 체크
        myArr = new int[4];
        // 문자열 입력 받을 배열
        char[] A = new char[S];
        // 몇개의 문자가 만족하는지(4이면 result+=1)
        checkSecret = 0;

        A = br.readLine().toCharArray();
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 4; i++) {
            checkArr[i] = Integer.parseInt(st.nextToken());
            // 예외처리 만약 0이 입력될경우 확인 하지 않아도 되므로
            if (checkArr[i] == 0) {
                checkSecret++;
            }
        }

        // 부분문자열 처음 받을 때 세팅
        for (int i = 0; i < P; i++) {
            Add(A[i]);
        }

        if (checkSecret == 4){
            result ++;
        }

        // 슬라이딩 윈도우 시작
        for(int i=P; i<S; i++){
            int j = i-P;
            Add(A[i]);
            Remove(A[j]);
            if(checkSecret == 4){
                result++;
            }
        }
        System.out.println(result);
        br.close();
    }

    private static void Remove(char c) {
        switch (c) {
            case 'A':
                if (myArr[0] == checkArr[0]) {
                    checkSecret--;
                }
                myArr[0]--;
                break;
            case 'C':
                if (myArr[1] == checkArr[1]) {
                    checkSecret--;
                }
                myArr[1]--;
                break;
            case 'G':
                if (myArr[2] == checkArr[2]) {
                    checkSecret--;
                }
                myArr[2]--;
                break;
            case 'T':
                if (myArr[3] == checkArr[3]) {
                    checkSecret--;
                }
                myArr[3]--;
                break;
        }
    }

    private static void Add(char c) {
        switch (c) {
            case 'A':
                myArr[0]++;
                // 딱 맞을때만 한번 중가 시킴(>= 이면 넘을때마다 증가시 키므로 체크 불가)
                if (myArr[0] == checkArr[0]) {
                    checkSecret++;
                }
                break;
            case 'C':
                myArr[1]++;
                if (myArr[1] == checkArr[1]) {
                    checkSecret++;
                }
                break;
            case 'G':
                myArr[2]++;
                if (myArr[2] == checkArr[2]) {
                    checkSecret++;
                }
                break;
            case 'T':
                myArr[3]++;
                if (myArr[3] == checkArr[3]) {
                    checkSecret++;
                }
                break;
        }
    }
}
