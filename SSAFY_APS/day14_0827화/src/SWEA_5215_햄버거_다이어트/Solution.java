package SWEA_5215_햄버거_다이어트;

import java.util.Scanner;

public class Solution {
	
	// 재료 수 N, 제한 칼로리 L, 각 재료의 점수, 칼로리 저장할 배열 score, cal 전역 변수 설정
	static int N, L;
	static int[] score, cal;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// T 만큼 loop
		int T = sc.nextInt();
		for (int test = 1; test <= T; test++ ) {
			
			// N, L, score, cal 새로 설정, 입력 받기
			N = sc.nextInt();
			L = sc.nextInt();
			score = new int[N];
			cal = new int[N];
			for (int i = 0; i< N; i++) {
				score[i] = sc.nextInt();
				cal[i] = sc.nextInt();
			}
			
			// 기본값 min 0 설정
			int min = 0;
			
			// 모든 경우 탐색하며 최대 점수 탐색
			for (int i = 1; i < 1 << N; i++) {
				int calS = 0;
				int scoreS = 0;
				for (int j = 0; j < N; j++ ) {
					if ((i & 1 << j) > 0) {
						calS += cal[j];
						scoreS += score[j];
					}
					if (calS > L) break;
				}
				if (calS <= L) min = Math.max(min, scoreS);
			}
			
			// 정답 출력
			System.out.println("#"+test+" "+min);
		}
	}
}