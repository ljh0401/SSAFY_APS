package SWEA_1873_상호의_배틀필드;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T =sc.nextInt();
		
		// T 만큼 loop
		for (int test = 1; test <= T; test++) {
			
			// 입력 받기
			int H = sc.nextInt();
			int W = sc.nextInt();
			int c = 0;
			int r = 0;
			
			// 게임 map의 요소들 다 나누어 저장
			char[][] map = new char[H][W];
			for (int i = 0; i < H; i++) {
				String word = sc.next();
				for (int j = 0; j < W; j++) {
					map[i][j] = word.charAt(j);
					if (map[i][j] == '<' || map[i][j] == 'v' || map[i][j] == '^' || map[i][j] == '>') {
						c = i;
						r = j;
					}
				}
			}
			
			// player 명령 입력 받기
			int N = sc.nextInt();
			String play = sc.next();
			
			// 명령 수행
			for (int i = 0; i < N; i++) {
				// 각 명령에 따라 탱크는 일을 한다
				char p = play.charAt(i);
				if (p == 'U') {
					if (c - 1 >= 0 && map[c-1][r] == '.') {
						map[c][r] = '.';
						c -= 1;
					}
					map[c][r] = '^';
				}
				else if (p == 'D') {
					if (c + 1 < H && map[c+1][r] == '.') {
						map[c][r] = '.';
						c += 1;
					}
					map[c][r] = 'v';
				}
				else if (p == 'L') {
					if (r - 1 >= 0 && map[c][r-1] == '.') {
						map[c][r] = '.';
						r -= 1;
					}
					map[c][r] = '<';
				}
				else if (p == 'R') {
					if (r + 1 < W && map[c][r+1] == '.') {
						map[c][r] = '.';
						r += 1;
					}
					map[c][r] = '>';
				}
				else {
					int cc = 0;
					int rr = 0;
					if (map[c][r] == '<') {
						rr = -1;
					}
					else if (map[c][r] == 'v') {
						cc = 1;
					}
					else if (map[c][r] == '^') {
						cc = -1;
					}
					else {
						rr = 1;
					}
					int C = c + cc;
					int R = r + rr;
					while (C >= 0 && C < H && R >= 0 && R < W) {
						if (map[C][R] == '#') {
							break;
						}
						if (map[C][R] == '*') {
							map[C][R] = '.';
							break;
						}
						C += cc;
						R += rr;
					}
				}
			}
			
			// 결과물 출력
			System.out.print("#"+test+" ");
			for (int i = 0; i < H; i++) {
				String print = ""; 
				for (int j = 0; j < W; j++) {
					print += map[i][j];
				}
				System.out.println(print);
			}
		}
	}
}