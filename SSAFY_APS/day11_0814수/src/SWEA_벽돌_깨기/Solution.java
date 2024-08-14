package SWEA_벽돌_깨기;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


//8.15. 추가 진행 예정, 주석 달기
class Solution
{
	static int N, W, H;
	static int[] dC = {0, 0, 1, -1};
	static int[] dR = {0, 0, 1, -1};
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{
			N = sc.nextInt();
			W = sc.nextInt();
			H = sc.nextInt();
			int[][] doll = new int[H][W];
			for (int i = 0; i < H; i++ ) {
				for (int j = 0; j <W; j++) {
					doll[i][j] = sc.nextInt();
				}
			}
			
			
			
			
			System.out.println("#"+test_case+" "  );
        }
	}
	public static int[][] setting(int[][] endGame) {
		for (int i = 0; i < W; i++) {
			boolean test = false;
			int tmp= 1;
			for (int j = H; j >= 1; j--) {
				if (endGame[j][i] == 0) {
					test = true;
					tmp = j;
				}
				else if (test) {
					for (int t = j; t >=1; t--) {
						endGame[tmp+t-j][i] = endGame[t][i];
					}
					j = tmp;
				}
			}
		}
		return endGame;
	}
	
	public static int[][] boom(int[][] doll, int idx) {
		if (idx == N) {
			return doll;
		}
		List<int[]> target = findT(doll);
		for (int j = 0;j < W; j++) {
			int c = target.get(j)[0];
			int r = target.get(j)[1];
			int del = target.get(j)[2];
			int[][] endGame = del(doll, c, r, del);
			int[][] startGame = setting(endGame);
			boom(startGame, idx+1);
		}
		return doll;
	}
	
	public static int[][] del(int[][] doll, int c, int r, int del) {
		doll[c][r] = 0;
		for (int j = 0; j < 4; j++) {
			int cc = c +dC[j];
			int rr = r +dR[j];
			for (int i = 0; i < del-1; i++) {
				if (doll[cc][rr] != 0) {
					del(doll, cc, rr, doll[cc][rr]);
				}
				doll[cc][rr] = 0;
				cc += dC[j];
				rr += dR[j];
			}
		}
		return doll;
	}
	
	public static List<int[]> findT(int[][] doll) {
		List<int[]> list = new ArrayList<>();
		for (int i = 0; i < W; i++) {
			for (int j = 0; j <H; j++) {
				if (doll[j][i] != 0) {
					list.add(new int[] {j, i, doll[j][i]});
					continue;
				}
			}
		}
		return list;
	}
	
	public static int countA(int[][] doll) {
		return 1;
	}
}
