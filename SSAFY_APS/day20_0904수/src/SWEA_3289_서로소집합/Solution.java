package SWEA_3289_서로소집합;

import java.util.*;

public class Solution {
	static int[] pa, ra;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for (int test = 1; test <= T; test++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            pa = new int[N+1];
            ra = new int[N+1];
            String answer = "";
            for (int i = 0; i < M; i++) {
            	int what = sc.nextInt();
            	int a = sc.nextInt();
            	int b = sc.nextInt();
            	if (what == 0) {
            		union(a, b);
            	}
            	else {
            		if (find(a) == find(b)) {
            			answer += "1";
            		}
            		else {
            			answer += "0";
            		}
            	}
            }
            System.out.println("#" + test + " " + answer);
        }
        sc.close();
    }
	
	public static int find(int a) {
		if(pa[a] != a) {
			pa[a] = find(pa[a]); 
		}
		return pa[a];
	}
	
	public static void union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		
		if (rootA != rootB) {
			if(ra[rootA] > ra[rootB]) {
				pa[rootB] = rootA;
			}
			else if (ra[rootA] < ra[rootB]) {
				pa[rootA] = rootB;
			}
			else {
				pa[rootB] = rootA;
				ra[rootA]++;
			}
		}
	}
}

