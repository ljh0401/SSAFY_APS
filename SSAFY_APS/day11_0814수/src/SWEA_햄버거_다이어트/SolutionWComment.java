package SWEA_햄버거_다이어트;

import java.util.Scanner;

class SolutionWComment
{
	// 재료의 수 N, 칼로리 제한 L global 선언
	static int N, L;
	
	// 재료들의 점수, 칼로리를 저장할 배열 ham global 선언
	static int[][] ham;
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		
		// 입력된 T 만큼 loop
		int T;
		T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{
			
			// N 입력
			N = sc.nextInt();
			
			// L 입력
			L = sc.nextInt();
			
			// 먹기위한 선택을 했는지 판단하기 위한 boolean 배열 생성
			boolean[] eat = new boolean[N];
			
			// 재료들의 정보(스코어, 칼로리)를 저장할 행렬 ham 정의
			ham = new int[N][2];
			
			// ham에 재료들 정보 입력
			for (int i = 0; i < N; i++) {
				ham[i][0] = sc.nextInt();
				ham[i][1] = sc.nextInt();
			}
			
			// 최적의 칼로리 제한을 지키면서 가장 좋은 점수를 얻는 함수 findCal을 통해 답을 얻고 출력
			System.out.println("#"+test_case+" " + findCal(eat, 0, 0, 0));
        }
	}
	
	// 한정된 칼로리 내에서 최적에 점수를 찾기 위한 재귀
	public static int findCal(boolean[] eat, int sumScore, int sumCal, int idx) {
		// 기본 점수 0점 설정
		int bestScore = 0;
		
		// 계속 돌면서 만약 칼로리가 초과하면 그 선택은 잘못됨을 알려줌
		if (sumCal > L) {
			return 0;
		}
		
		// 만약 N개의 재료 중 모든 선택을 마쳤으면 뒤에서 bestScore하고 비교
		else if (idx >= N) {
		}
		
		// 만약 아직 재료를 선택 다 하지 않았다면 idx마다 선택 실시, 모든 idx에 대한 결정을 마칠 때 return하는 Score과 현재 bestScore 비교.
		else {
			eat[idx] = true;
			int score = findCal(eat, sumScore + ham[idx][0], sumCal + ham[idx][1], idx+1);
			eat[idx] = false;
			int score1 = findCal(eat, sumScore, sumCal, idx+1);
			score = Math.max(score, score1);
			bestScore = Math.max(score, bestScore);
		}
		bestScore = Math.max(sumScore, bestScore);
		
		// bestScore return
		return bestScore;
	}
}