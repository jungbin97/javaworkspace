package 완전탐색.programmers_모의고사;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    /**********************************************************************
     *
     *
     **********************************************************************/
    public int[] solution(int[] answers) {
        int[] a1 = {1, 2, 3, 4, 5};
        int[] a2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] a3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int[] people = new int[3];

        for(int i = 0; i < answers.length; i++){
            if (answers[i] == a1[i%5]){
                people[0] += 1;
            }
            if (answers[i] == a2[i%8]){
                people[1] += 1;
            }
            if(answers[i] == a3[i%10]){
                people[2] += 1;
            }
        }

        // 정렬 후 최댓값 뽑기(오름차순) => 순서가 바뀌기 떄문에 안됨(1번 수포자 2번 수포자, 3번수포자)
//        Arrays.sort(people);
//        int winner = people[people.length-1];

        int winner = Math.max(Math.max(people[0], people[1]), people[2]);

        ArrayList<Integer> answer = new ArrayList<>();
        for(int i = 0; i < people.length; i++){
            if(people[i] == winner){
                answer.add(i+1);
            }
        }

        // 리스트를 배열로
        int[] answer1 = new int[answer.size()];
        for(int i =  0; i < answer.size(); i++){
            answer1[i] = answer.get(i);
        }

        return answer1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(Arrays.toString(s.solution(new int[]{1,2,3,4,5})));

    }
}
