import java.util.Comparator;
import java.util.NoSuchElementException;

public class Heap<E> {
    private final Comparator<? super E> comparator;     // E 타입이나 상속받은 부모 클래스 타입 사용가능
    private static final int DEFAULT_CAPACITY = 10;     // 최소(기본) 배열 크기

    private int size;   // 요소 개수(의미가 담긴 배열 개수)

    private Object[] array;     // 요소를 담을 배열

    // 생성자 Type 1 (초기 공간 할당 X)
    public Heap(){
        this(null);
    }

    public Heap(Comparator<? super E> comparator){
        this.array = new Object[DEFAULT_CAPACITY];
        this.size = 0;
        this.comparator = comparator;
    }

    // 생성자 Type 2 (초기 공간 할당 O)
    public Heap(int capacity){
        this(capacity, null);
    }

    public Heap(int capacity, Comparator<? super E> comparator){
        this.array = new Object[capacity];
        this.size = 0;
        this.comparator = comparator;
    }

    // 받은 인덱스의 부모 노드 인덱스를 반환
    private int getParent(int index){
        return index / 2;
    }

    // 받은 인덱스의 왼쪽 자식 노드 인덱스르 반환
    private int getLeftChild(int index){
        return index * 2;
    }

    // 받은 인덱스의 오른쪽 자식 노드 인덱스 반환
    private int getRightChild(int index){
        return index * 2 + 1;
    }

    // 배열 크기 재조정 메소드
    private void resize(int newCapcity){
        // 새로 만든 배열
        Object[] newArray = new Object[newCapcity];

        // 새 배열에 기존에 있던 배열의 요소들을 모두 복사
        for(int i=1; i<= size; i++){
             newArray[i] = array[i];
        }

        /*
         * 현재 배열은 GC 처리를 위해 null로 처리한 뒤,
         * 새 배열을 연결해준다.
         */
        this.array = null;
        this.array = newArray;
    }

    public void add(E value){
        // 배열의 크기가 꽉차있을 경우 크기를 두배 늘림
        if(size+1 == array.length){
            resize(array.length * 2);
        }

        siftUp(size+1, value);      // 가장 마지막에 추가 되는 위치와 얺을 값(타겟)을 넘겨줌
        size++;                     // 정상적으로 재배치가 끝나면 요소 크기 증
    }

    /* 상향 선별
     *   @param idx     추가할 노드의 인덱스
     *   @param target  재배치 할 노드
     */
    private void siftUp(int idx, E target){
        // comparator가 존재할 경우 comparator을 인자로 넘겨준다.
        if(comparator != null){
            siftUpComparator(idx, target, comparator);
        }
        else{
            siftUpComparable(idx, target);
        }
    }

    // Comparator을 이용한 sift-up
    @SuppressWarnings("unchecked")
    private void siftUpComparator(int idx, E target, Comparator<? super E> comp) {

        // root노드보다 클 때까지만 탐색한다.
        while(idx > 1){
            int parent = getParent(idx);        // 현재 인덱스 부모 인덱스 반환 하는 함수
            Object parentVal = array[parent];   // 부모노드의 값

            // 타겟 노드값이 부모노드보다 크면 반복문 종료
            if(comp.compare(target, (E) parentVal) >= 0){
                break;
            }

            /*
             * 부모노드가 타겟 노드 보다 크므로
             * 현재 삽입 될 위치에 부모노드 값으로 교체해주고
             * 타겟 노드의 위치를 부모노드의 위치로 변경해준다.
             */
            array[idx] = parentVal;
            idx = parent;
        }

        // 최종적으로 삽입될 위치에 타겟 노드 값을 저장해준다.
        array[idx] = target;
    }

    // 삽입 할 객체의 Comparable을 이용한 sift-up
    @SuppressWarnings("unchecked")
    private void siftUpComparable(int idx, E target){
        // 타겟 노드가 비교 될 수 있도록 한 변수를 만든다.
        Comparable<? super E> comp = (Comparable<? super E>)  target;

        while(idx > 1){
            int parent = getParent(idx);
            Object parentVal = array[parent];

            if(comp.compareTo((E)parentVal) >= 0){
                break;
            }
            array[idx] = parentVal;
            idx = parent;
        }
        array[idx] = comp;
    }

    @SuppressWarnings("unchecked")
    public E remove() {
        if (array[1] == null) {       // 만약 root가 비어있을 경우 예외를 던지도록 함
            throw new NoSuchElementException();
        }

        E result = (E) array[1];    // 삭제된 요소를 반환하기 위한 임시 변수
        E target = (E) array[size]; // 타겟이 될 요소
        array[size] = null;         // 타겟 노드가 있었던 곳 값 비움

        // 삭제할 노드의 인덱스와 이후 재배치 할 타겟 노드를 넘겨준다.
        siftDown(1, target);        // 루트 노드가 삭제 되므로 1을 넘겨준다.

        return result;
    }

    /*
    * @param idx 삭제할 노드의 인덱스
    * @param target 재배치 할 노드
     */
    private void siftDowm(int idx, E target){
        // comparator가 존재할경우 comparator을 인자로 넘겨준다.
        if(comparator != null){
            siftDownComparator(idx, target,comparator);
        }else{
            siftDownComparable(idx, target);
        }
    }


    // Compartator을 이용한 sift-down
    @SuppressWarnings("unchecked")
    private void siftDownComparator(int idx, E target, Comparator<? super E> comp){
        array[idx] = null;  // 삭제 할 인덱스의 노드를 삭제
        size--;

        int parent = idx;   // 삭제노드부터 시작 할 부모를 가리키는 변수
        int child;          // 교환될 자식을 가리키는 변수

        // 왼쪽 자식 노드의 인덱스가 요소의 개수보다 작을 떄까지 반복
    }

    @SuppressWarnings("unchecked")
    private void siftDownComparable(int idx, E target) {
    }
}
