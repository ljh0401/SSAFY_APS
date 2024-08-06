package SWEA_1217_거듭제곱;

import java.util.Scanner;
class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		
		// 10번의 test_case가 있으므로 T = 10
		int T;
		T=10;
		
		// 10번의 loop
		for(int test_case = 1; test_case <= T; test_case++)
		{
			// 현재의 test 번호 입력 받기
			int test = sc.nextInt();
			
			// 기본 정답 설정
            int ans = 0;
            
            // N, M 입력 받기
            int N = sc.nextInt();
            int M = sc.nextInt();
            
            // 기본 count = 1
            int count = 1;
            
            // mult 함수에 값 대입, return 값이 정답 
            ans = mult (N, M, count, N);
            
            // 정답 출력
            System.out.println("#"+test+" "+ans);
		}
	}
	
	// 거듭제곱 해주는 함수
    public static int mult (int N, int M, int count, int cur) {
        
    	// 원하는 만큼 거듭제곱 하였을 때 결과 return
    	if (count == M) return cur;
    	
    	// 아니라면 한 번 더 곱하기
        cur = cur*N;
        count++;
        
        // 그리고 다시 반복
        int ans = mult(N, M, count, cur);
        
        // 해당 함수보다 앞선 재귀함수가 모두 끝나면 결과 return
    	return ans;
    }
}