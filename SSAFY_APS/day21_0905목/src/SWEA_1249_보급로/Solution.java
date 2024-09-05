package SWEA_1249_보급로;


import java.util.*;
import java.io.*;

public class Solution {
	static int[] dC = {0, 0, 1, -1};
	static int[] dR = {1, -1, 0, 0};
	static int[][] map, find;
	static int N;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        // T만큼 loop
        for (int test = 1; test <= T; test++) {
        	N = Integer.parseInt(br.readLine());
        	map = new int[N][N];
        	find = new int[N][N];
        	for (int i = 0; i < N; i++) {
        		String[] st = br.readLine().split("");
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st[j]);
                    find[i][j] = Integer.MAX_VALUE;
                }
        	}
        	find[0][0] = 0;
        	find(0,0);
            System.out.println("#" + test + " " + find[N-1][N-1]);
        }
    }
    public static void find(int i, int j) {
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]); 
    	pq.add(new int[] {i, j, 0});
		while(!pq.isEmpty()) {
			int[] tmp = pq.poll();
			int C = tmp[0];
			int R = tmp[1];
			if (tmp[2] > find[C][R]) continue;
			for (int s = 0; s < 4; s++) {
				int CC = C+dC[s];
				int RR = R+dR[s];
				if (0 <= CC && CC < N && 0 <= RR && RR < N) {
					int[] num = new int[] {CC, RR, find[C][R] + map[CC][RR]};
					if (num[2] < find[CC][RR]) {
						find[CC][RR] = num[2];
						pq.add(num);
					}
				}
			}
			
		}
    }
}


