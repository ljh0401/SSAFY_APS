package SWEA_1213_String;

import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		for(int test_case = 1; test_case <= 10; test_case++)
		{
            // 처음 test_case 번호 입력 처리 (직접 사용하지는 않음)
			int T;
			T=sc.nextInt();
			
			// target word 입력
			String target = sc.next();
			
			// 문자열 입력
			String word = sc.next();
			
			// 문자열 맨 앞, 맨 뒤 "*" 추가
			word = "*"+word+"*";
			
			// 문자열에 n개의 target word가 있을 경우 n+1개의 원소로 쪼개버림 
			String[]Word = word.split(target);
			
			// 쪼개진 원소들의 개수 -1 을 통해 n을 구함
			int ans = Word.length-1;
			
			// n 출력
			System.out.println("#"+test_case+" "+ans);
		}
	}
}