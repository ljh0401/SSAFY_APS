package SWEA_1989_초심자의회문검사;

import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{
			// 정답으로 출력할 int ans 생성
			int ans = 0;
			
            // 단어 입력 받기 (쪼개서)
            String[] word = sc.next().split(""); 
            
            // 회문임을 판단할 지표 Find 생성
			int Find = 0;
            
            // 단어의 길이 N
            int N = word.length;
            
			// 배열 회문 검사
			for (int i = 0; i < N/2 ; i++) {
                if (word[i].equals(word[N-1-i])) {
                Find += 1;
                }
            }
            
            // 회문인지 판단
			if (Find == N/2) {
				ans =1;
			}
                    
			// 정답 출력
			System.out.println("#"+test_case+" "+ans);
		}
	}
}