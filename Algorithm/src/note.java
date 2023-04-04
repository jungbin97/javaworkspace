import java.util.ArrayList;

public class note {
    public static void main(String[] args) {
        ArrayList<ArrayList<Boolean>> list = new ArrayList<>();

        // 중첩 리스트
        for(int i = 0; i < 3; i++){
            list.add(new ArrayList<Boolean>());
        }

        System.out.println(list.size());
    }
}
