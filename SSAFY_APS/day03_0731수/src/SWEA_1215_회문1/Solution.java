package SWEA_1215_회문1;

import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		for(int test_case = 1; test_case <= 10; test_case++)
		{
			// 정답으로 출력할 int ans 생성
			int ans = 0;
			
			// 회문의 길이 N 입력 받음
			int N = sc.nextInt();
			
			// 8*8 배열 생성
			String[][] words = new String[8][8];
			
			// 배열 입력
			for (int i = 0; i < 8 ; i++) {
				words[i] = sc.next().split("");
			}
			
			// 모든 영역 회문 검사
			for (int i = 0; i < 8 ; i++) {
				for (int j = 0; j <= 8-N ; j++) {
					// 회문임을 판단할 지표 rFind, cFind 생성
					int rFind = 0;
					int cFind = 0;
					
					// 회문 판단을 위한 for문 생성
					for (int s = 0; s < N/2; s++) {
						
						// r 방향 j+s, j+N-1-s 의 index를 가진 값들이 같은지 비교 
						if (words[i][j+s].equals(words[i][j+N-1-s])) {
							rFind += 1;
						}
						// c 방향 j+s, j+N-1-s 의 index를 가진 값들이 같은지 비교
						if (words[j+s][i].equals(words[j+N-1-s][i])) {
							cFind += 1;
						}
					}
					// 만약 모두 같았다 => ans + 1
					if (rFind == N/2) ans+=1;
					if (cFind == N/2) ans+=1;
				}
			}
			// 정답 출력
			System.out.println("#"+test_case+" "+ans);
		}
	}
}