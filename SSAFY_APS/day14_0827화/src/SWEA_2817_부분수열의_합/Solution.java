package SWEA_2817_부분수열의_합;

import java.util.Scanner;

public class Solution {
	
	// 처음에 다른 메서드 만들려고 해서 global 선언
	static int answer, N, K;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test = 1; test <= T; test++) {
			
			// 기본 정답 0 
			answer = 0;
			
			// N, K 입력
			N = sc.nextInt();
			K = sc.nextInt();
			
			// arr 배열 생성, 입력 받기
			int[] arr = new int[N];
			for (int i = 0 ; i < N; i++) {
				arr[i] = sc.nextInt();
			}
			
			// 비트 마스킹으로 부분집합 별 더한 값이 K와 같으면 answer += 1;
			for (int i = 1; i < 1 << N; i++) {
				int sum = 0;
				for (int j = 0; j < N; j++) {
					if ((i & 1 << j) > 0) sum +=arr[j]; 
				}
				if (sum == K)
					answer += 1;
			}
			
			// 정답 출력
			System.out.println("#"+test+" "+answer);
		}
	}
}