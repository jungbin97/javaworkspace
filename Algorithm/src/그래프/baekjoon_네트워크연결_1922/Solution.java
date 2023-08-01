package 그래프.baekjoon_네트워크연결_1922;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Edge implements Comparable<Edge>{
    private int distance;
    private int nodeA;
    private int nodeB;

    public Edge(int distance, int nodeA, int nodeB) {
        this.distance = distance;
        this.nodeA = nodeA;
        this.nodeB = nodeB;
    }

    public int getDistance() {
        return distance;
    }

    public int getNodeA() {
        return nodeA;
    }

    public int getNodeB() {
        return nodeB;
    }

    public int compareTo(Edge o){
        if(this.distance < o.distance){
            return -1;
        }
        return 1;
    }
}



public class Solution {
    /**********************************************************************
     *
     *
     **********************************************************************/
    public static int N, M;    // 노드, 간선
    // 부모 테이블 초기화
    public static int[] parent = new int[1001];
    public static ArrayList<Edge> edges = new ArrayList<>();
    public static int result = 0;

    // 특정 원소가 속한 집합을 찾기
    public static int findParent(int x) {
        // 루트 노드가 아니라면, 루트 노드를 찾을 때까지 재귀적으로 호출
        if (x == parent[x]) {
            return x;
        }
        return parent[x] = findParent(parent[x]);
    }

    // 두 원소가 속한 집합 합치기
    public static void unionParent(int a, int b) {
        a = findParent(a);
        b = findParent(b);

        if (a < b) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        // 부모 테이블을 자기 자신으로 초기화
        for(int i = 1; i<=N; i++){
            parent[i] = i;
        }

        // 모든 간선에 대한 정보를 입력 받기
        for(int i = 0; i<M; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int cost = sc.nextInt();
            edges.add(new Edge(cost , a, b));
        }

        Collections.sort(edges);

        // 간선을 하나씩 확인하며
        for(int i = 0; i<edges.size(); i++){
            int cost = edges.get(i).getDistance();
            int a = edges.get(i).getNodeA();
            int b = edges.get(i).getNodeB();

            // 사이클이 발생하지 않은 겨우에만 집합에 포함
            if(findParent(a) != findParent(b)){
                unionParent(a, b);
                result += cost;
            }
        }
        System.out.println(result);
    }
}