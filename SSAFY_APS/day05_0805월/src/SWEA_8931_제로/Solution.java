package SWEA_8931_제로;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Solution {
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T=sc.nextInt();
		
		// T번의 테스트 케이스 반복
		for(int test_case = 1; test_case <= T; test_case++)
		{
			
			// 재현이가 몇 번 부르는지 확인
			int K = sc.nextInt();
			
			// 재현이가 불러줄 값들을 합할 것이다.
			long sum = 0;
			
			// 적어 둘 장부 생성
			List<Integer> money = new ArrayList<>();
			
			// stack처럼 사용하기 위한 idx 생성
			int idx = -1;
			for (int i = 0; i < K; i++) {
				
				// 재현이가 숫자를 불러줬을 때
				int num = sc.nextInt();
				
				// 만약 0이면 가장 최근 값 삭제
				if (num == 0) {
					sum -= money.get(idx);
					money.remove(idx);
					idx--;
					continue;
				}
				
				// 아니면 장부에 추가
				sum += num;
				idx++;
				money.add(num);
			}
			
			// 장부에 적힌 값들의 합 출력
			System.out.println("#"+test_case+" "+sum);
		}
	}
}