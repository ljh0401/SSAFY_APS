package SWEA_2806_NQueen;

import java.util.Scanner;

public class Solution {
	static int N;
	static int answer;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		// T만큼 loop
		for (int test = 1; test <= T; test++ ) {
			N = sc.nextInt();
			answer = 0;
			
			// queen 놓을 map 생성
			boolean[][] map = new boolean[N][N];
			find(map, 0);
			System.out.println("#"+test+" "+ answer);
		}
	}
	public static void find(boolean[][] map, int count) {
		
		// queen이 N개일 때 +1
		if (count == N) {
			answer += 1;
			return;
		}
		
		// queen이 다 놓아지지 않았다면 놓을 수 있는 자리일 때 queen 놓기.
		A:
		for (int i = 0; i < N; i++) {
			if(!map[count][i]) {
				for (int j = 0; j < count; j++) {
					if (map[j][i]) continue A;
				}
				for (int s = count-1, t = i-1; s >= 0 && t >=0; s--, t--) {
					if (map[s][t]) continue A;
				}
				for (int s = count-1, t = i+1; s >= 0 && t < N; s--, t++) {
					if (map[s][t]) continue A;
				}
				map[count][i] = true;
				find(map, count+1);
				map[count][i] = false;
			}
		}
	}
}