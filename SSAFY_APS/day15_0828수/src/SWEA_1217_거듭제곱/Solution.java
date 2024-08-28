package SWEA_1217_거듭제곱;

import java.util.Scanner;
class Solution
{
    static int N;
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		
		// 10개의 test loop
		int T;
		T=10;
		for(int test_case = 1; test_case <= T; test_case++)
		{
			// test 번호 입력 받기
			int test = sc.nextInt();
			
			// 기본 정답 0 설정
            int ans = 0;
            
            // N, M 입력 받기
            N = sc.nextInt();
            int M = sc.nextInt();
            
            // 분학 정복으로 정답 계산
            ans = mult (M, N);
            System.out.println("#"+test+" "+ans);
		}
	}
	
	// 분할 정복하기
    public static int mult (int m, int cur) {
        // m을 기준으로 1일 때 cur(N) return;
    	if (m == 1) return cur;
    	
    	// 1이 아니라면 N의 m/2승 제곱하여 N의 m승 구하기 (홀수, 짝수 구분) 
        if (m%2 == 1) {
            int num = mult(m/2, cur);
        	return num*num*N;
        }
        else {
        	int num = mult(m/2, cur);
            return num*num;
        }
    }
}