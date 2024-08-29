package SWEA_6808_규영이와_인영이의_카드게임;

import java.util.Scanner;

public class Solution {
	static int win, lose;
	static int[] card, inCard;
	static boolean[] use;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		// T 만큼 loop
		for (int test = 1; test <= T; test++) {
			
			// 규 와 인이 가지고 있는 카드 입력
			card = new int[9];
			inCard = new int[9];
			use = new boolean[9];
			boolean[] in = new boolean[18];
			for (int i = 0; i < 9; i++) {
				card[i] = sc.nextInt();
				in[card[i]-1] = true;
			}
			int idx = 0;
			for (int i = 0; i <18; i++) {
				if(!in[i]) {
					inCard[idx++] = i+1;
				}
			}
			
			// 기본 승, 패 0 설정
			win = 0;
			lose = 0;
			
			// 승, 패 case 모두 탐색
			find(0, 0, 0);
			
			// 출력
			System.out.println("#"+test+" "+win+" "+lose);
		}
	}
	public static void find(int count, int gu, int in) {
		
		// 만약 규가 171/2를 넘었다면 규 승리
		if (gu > 85) {
			int idx = 1;
			
			// 9-count만큼 loop 돌며 모든 경우의 수 계산
			for (int i = 0; i < 9-count; i++) {
				idx*=(i+1);
			}
			win += idx;
			return;
		}
		
		// 만약 인이 171/2를 넘었다면 인 승리
		else if (in > 85) {
			int idx = 1;
			
			// 9-count만큼 loop 돌며 모든 경우의 수 계산
			for (int i = 0; i < 9-count; i++) {
				idx*=(i+1);
			}
			lose += idx;
			return;
		}
		
		// 모든 경우 탐색
		for (int i = 0; i < 9; i++) {
			if (!use[i]) {
				use[i] = true;
				if (inCard[i] > card[count]) {
					find(count+1, gu, in+card[count]+inCard[i]);
				}
				else {
					find(count+1, gu+card[count]+inCard[i], in);
				}
				use[i] = false;
			}
		}
	}
}