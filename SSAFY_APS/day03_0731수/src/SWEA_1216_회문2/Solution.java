package SWEA_1216_회문2;

import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		for(int test_case = 1; test_case <= 10; test_case++)
		{
			// 정답으로 출력할 int len 생성
			int len = 0;
			
			// test 번호 입력 받음
			int T = sc.nextInt();
			
			// 100*100 배열 생성
			String[][] words = new String[100][100];
			
			// 배열 입력
			for (int i = 0; i < 100 ; i++) {
				words[i] = sc.next().split("");
			}
			
			int N = 100;
			len = find(words, N);
			// 정답 출력 (T로 입력받지 않으면 틀림)
			System.out.println("#"+T+" "+len);
		}
	}
	
	public static Integer find(String[][] words, int N) {
		// 모든 영역 회문 검사
		for (int i = 0; i < 100 ; i++) {
			for (int j = 0; j <= 100-N ; j++) {
				// 회문임을 판단할 지표 rFind, cFind 생성
				int rFind = 0;
				int cFind = 0;
				int rX = 0;
				int cX = 0;
				// 회문 판단을 위한 for문 생성
				for (int s = 0; s < N/2; s++) {
								
					// r 방향 j+s, j+N-1-s 의 index를 가진 값들이 같은지 비교 
					if (words[i][j+s].equals(words[i][j+N-1-s])) {
						rFind += 1;
					}
					// 아닐 경우 판정위해 rX -= 1
					else {
						rX-=1;
					}
					// c 방향 j+s, j+N-1-s 의 index를 가진 값들이 같은지 비교
					if (words[j+s][i].equals(words[j+N-1-s][i])) {
						cFind += 1;
					}
					// 아닐 경우 판정위해 cX -= 1
					else {
						cX-=1;
					}
					// 둘 다 한 번씩 틀렸으면 break;
					if (cX < 0 && rX < 0) break;
				}
				// 만약 모두 같았다 => N 값 return
				if (rFind == N/2) return N;
				else if (cFind == N/2) return N;
			}
		}
		
		// 다음 검사를 위해 N - 1
		N -= 1;
		
		// 만약 N == 1이면 그대로 종료
		if (N == 1) {
			return N;
		}
		// 아닐 경우 N -1인 상태로 다시 반복하여 결과 도출
		int ans = find(words, N);
		return ans;
	}
}