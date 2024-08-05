package SWEA_5432_쇠막대기자르기;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T=sc.nextInt();
		
		// T번의 테스트 케이스 반복
		for(int test_case = 1; test_case <= T; test_case++)
		{
			// iron List 구현
			List<String> iron = Arrays.asList(sc.next().split(""));
			
			// 기본 idx, 철 막대기의 수 (ans) 설정
			int idx = -1;
			int ans = 0;
			
			// 전체 부호를 살펴보자
			for (int i = 0; i < iron.size(); i++) {
				
				// 만약 i가 iron.size()-1보다 작고, "(", ")"가 연속되어 있다면 idx+1만큼의 쇠막대기가 더 생김.
				if (i < iron.size()-1 && iron.get(i).equals("(") && iron.get(i+1).equals(")")) {
					ans += (idx+1);
					i += 1;
					continue;
				}
				
				// 만약 "(" 이라면 쇠막대기 하나 추가
				if (iron.get(i).equals("(")) {
					idx += 1;
				}
				// 만약 ")" 이라면 더 이상 레이저로 잘리지 않지만 1개의 쇠막대기가 완성되므로 ans + 1
				else if (iron.get(i).equals(")")) {
					ans += 1;
					idx -= 1;
				}
			}
			
			// 정답 출력
			System.out.println("#"+test_case+" "+ans);
		}
	}
}
