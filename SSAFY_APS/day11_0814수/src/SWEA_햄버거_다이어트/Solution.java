package SWEA_햄버거_다이어트;

import java.util.Scanner;

class Solution
{
	static int N, L;
	static int[][] ham;
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{
			N = sc.nextInt();
			L = sc.nextInt();
			boolean[] eat = new boolean[N];
			ham = new int[N][2];
			for (int i = 0; i < N; i++) {
				ham[i][0] = sc.nextInt();
				ham[i][1] = sc.nextInt();
			}
			System.out.println("#"+test_case+" " + findCal(eat, 0, 0, 0));
        }
	}
	
	public static int findCal(boolean[] eat, int sumScore, int sumCal, int idx) {
		int bestScore = 0;
		if (sumCal > L) {
			return 0;
		}
		else if (idx >= N) {
		}
		else {
			eat[idx] = true;
			int score = findCal(eat, sumScore + ham[idx][0], sumCal + ham[idx][1], idx+1);
			eat[idx] = false;
			int score1 = findCal(eat, sumScore, sumCal, idx+1);
			score = Math.max(score, score1);
			bestScore = Math.max(score, bestScore);
		}
		bestScore = Math.max(sumScore, bestScore);
		return bestScore;
	}
}