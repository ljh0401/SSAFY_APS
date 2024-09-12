package SWEA_1970_쉬운거스름돈;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// T만큼 loop
		int T = sc.nextInt();
		for (int test = 1; test <= T; test++) {
			
			// M(돈) 입력 받기
			int M = sc.nextInt();
			int t = 0;
			
			// 그냥 갑자기 이렇게 해보고 싶었습니다....
			StringBuilder sb = new StringBuilder();
			sb.append("#"+test + "\n");
			int tmp = M/50000;
			sb.append(tmp + " ");
			M -= tmp*50000;
			tmp = M/10000;
			sb.append(tmp + " ");
			M -= tmp*10000;
			tmp = M/5000;
			sb.append(tmp + " ");
			M -= tmp*5000;
			tmp = M/1000;
			sb.append(tmp + " ");
			M -= tmp*1000;
			tmp = M/500;
			sb.append(tmp + " ");
			M -= tmp*500;
			tmp = M/100;
			sb.append(tmp + " ");
			M -= tmp*100;
			tmp = M/50;
			sb.append(tmp + " ");
			M -= tmp*50;
			tmp = M/10;
			sb.append(tmp);
			M -= tmp*10;
			// 정답 출력
			System.out.println(sb);
		}
	}
}