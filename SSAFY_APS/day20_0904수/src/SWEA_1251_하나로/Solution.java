package SWEA_1251_하나로;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for (int test = 1; test <= T; test++) {
            int N = sc.nextInt();
            int[][] land = new int[N][2];
            
            for (int i = 0; i < N; i++) {
                land[i][0] = sc.nextInt();
            }
            for (int i = 0; i < N; i++) {
                land[i][1] = sc.nextInt();
            }
            
            // 모든 쌍의 거리를 계산하고 우선순위 큐에 추가
            PriorityQueue<Edge> pq = new PriorityQueue<>();
            for (int i = 0; i < N; i++) {
                for (int j = i + 1; j < N; j++) {
                    double distance = Math.pow(land[i][0] - land[j][0], 2) + Math.pow(land[i][1] - land[j][1], 2);
                    pq.add(new Edge(distance, i, j));
                }
            }
            
            // 유니온-파인드 초기화
            UnionFind uf = new UnionFind(N);
            double answer = 0;
            
            // 크루스칼 알고리즘을 사용하여 최소 신장 트리 계산
            while (!pq.isEmpty()) {
                Edge edge = pq.poll();
                if (uf.find(edge.start) != uf.find(edge.end)) {
                    uf.union(edge.start, edge.end);
                    answer += edge.weight;
                }
            }
            
            double E = sc.nextDouble();
            answer *= E;
            System.out.println("#" + test + " " + Math.round(answer));
        }
        sc.close();
    }
    
    // 유니온-파인드 클래스
    static class UnionFind {
        int[] parent;
        int[] rank;
        
        UnionFind(int size) {
            parent = new int[size];
            rank = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }
        
        int find(int u) {
            if (parent[u] != u) {
                parent[u] = find(parent[u]);
            }
            return parent[u];
        }
        
        void union(int u, int v) {
            int rootU = find(u);
            int rootV = find(v);
            
            if (rootU != rootV) {
                if (rank[rootU] > rank[rootV]) {
                    parent[rootV] = rootU;
                } else if (rank[rootU] < rank[rootV]) {
                    parent[rootU] = rootV;
                } else {
                    parent[rootV] = rootU;
                    rank[rootU]++;
                }
            }
        }
    }
    
    // Edge 클래스
    static class Edge implements Comparable<Edge> {
        double weight;
        int start;
        int end;
        
        Edge(double weight, int start, int end) {
            this.weight = weight;
            this.start = start;
            this.end = end;
        }
        
        @Override
        public int compareTo(Edge other) {
            return Double.compare(this.weight, other.weight);
        }
    }
}

