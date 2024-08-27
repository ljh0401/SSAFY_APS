package SWEA_4012_요리사;

import java.util.Scanner;
import java.util.Arrays;

class Solution
{
	
	// N, N/2 (size), min, 2차원 배열 score global 선언
	static int N, size, min;
	static int[][] score;
	public static void main(String args[]) throws Exception
	{
		
		// T 입력 받고 그만큼 loop
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{
			
			// 전역 변수 값 할당
			N= sc.nextInt();
			size = N/2;
			min = Integer.MAX_VALUE;
			score = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					score[i][j] = sc.nextInt();
				}
			}
			
			// 재료로 사용했는지 확인할 yam 생성
			boolean[] yam = new boolean[N];
			
			// 우린 모든 경우가 필요 없으니 0은 true로 설정
			yam[0] = true;
			yamyam(1, 1, yam);
			System.out.println("#"+test_case+" "+min);
		}
	}
	
	
	// 재료 소분하는 메서드 yamyam
	public static void yamyam(int idx , int sidx, boolean[] yam) {
		
		// 만약 차의 최소가 0이면 다 무시
		if (min == 0) return;
		if (idx >= N && sidx != size) return;
		
		// size 크기만큼 소분했으면 차 계산
		if (sidx == size) {
			System.out.println(Arrays.toString(yam));
			int sum1 = 0;
			int sum2 = 0;
			for (int i = 0; i < N; i++) {
				for (int j = i+1; j < N; j++) {
					if (yam[i]) {
						if (yam[j]) {
							sum1 += (score[i][j] + score[j][i]);
						}
					}
					else {
						if (!yam[j]) {
							sum2 += (score[i][j] + score[j][i]);
						}						
					}
				}
			}
			min = Math.min(min, Math.abs(sum1-sum2));
			return;
		}
		
		// sidx가 size 될 때까지 계속 소분해보자
		for (int i = idx; i <= N - size + sidx; i++) {
			yam[i] = true;
			yamyam(i+1, sidx+1, yam);
			yam[i] = false;
		}
	}
}

