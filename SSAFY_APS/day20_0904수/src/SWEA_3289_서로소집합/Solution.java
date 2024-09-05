package SWEA_3289_���μ�����;

import java.util.*;
import java.io.*;

public class Solution {
	static int[] pa;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for (int test = 1; test <= T; test++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            pa = new int[N+1];
            for (int i = 1; i < N+1; i++) {
            	pa[i] = i;
            }
            StringBuilder answer = new StringBuilder();
            answer.append("#");
            answer.append(test);
            answer.append(" ");
            for (int i = 0; i < M; i++) {
            	st = new StringTokenizer(br.readLine());
            	int what = Integer.parseInt(st.nextToken());
            	int a = Integer.parseInt(st.nextToken());
            	int b = Integer.parseInt(st.nextToken());
            	switch (what) {
                case 0: 
                    union(a, b);
                    break;
                case 1: 
                    if (find(a) == find(b)) answer.append(1);
                    else answer.append(0);
                    break;
            	}
            }
            System.out.println(answer);
        }
    }
	
	public static int find(int a) {
		if(pa[a] == a) return a;
		pa[a] = find(pa[a]); 
		return pa[a];
	}
	
	public static void union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		
		if (rootA != rootB) {
			pa[rootA] = rootB;
		}
	}
}

