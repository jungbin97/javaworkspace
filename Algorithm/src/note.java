import java.util.ArrayList;
import java.util.Arrays;

public class note {
    // Swap을 이용한 DFS 구현
    static void per1(int[] arr, int depth, int n, int r){
        if(depth == r){
            print(arr, r);
            return;
        }

        for (int i = depth; i<n; i++){
            swap(arr, depth, i);
            per1(arr, depth+1, n, r);
            swap(arr, depth, i);        // 다시 위에 노드로 복귀
        }
    }
    static void swap(int[] arr, int depth, int i){
        int temp = arr[depth];
        arr[depth] = arr[i];
        arr[i] = temp;
    }

    static void print(int[] arr, int r){
        for(int i = 0; i < r; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3};
        int n = arr.length;
        int[] output = new int[n];      // 순열 출력을 위한 배열
        boolean[] visited = new boolean[n]; // 중복해서 뽑지 않기 위해 방문했는지 체크

        System.out.println("------------- Swap --------------");
        // Swap 메서드를 이용해서 구현(r = 3 3개를 뽑을 것)
        per1(arr, 0, n, 3);

    }
}
