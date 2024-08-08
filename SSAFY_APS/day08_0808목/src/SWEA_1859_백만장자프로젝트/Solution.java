package SWEA_1859_백만장자프로젝트;

import java.util.Scanner;

//현재 최대한 획기적으로 풀어보고자 생각 및 추가 변경 중입니다. (큰 차이가 없을 것 같기도 합니다.)

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		// test_case 입력
		int T;
		T=sc.nextInt();
		// test 수 만큼 loop
		for(int test_case = 1; test_case <= T; test_case++)
		{
			
			int N = sc.nextInt();
         
			// 매매가 입력 받기 위한 배열 생성
			int[] nums = new int[N];
			
			// 매매가 입력 받기
         for (int i =0; i<N ; i++) {
             nums[i] = sc.nextInt();
         }
         
         // 이득, 언제 팔면 좋을지를 알려주는 변수 설정
         long sum = 0;
         int max = nums[N-1];
         
         // 뒤에서부터 천천히 작을 경우만 sum
         for (int i =N-2; i>=0 ; i--) {
             if(max < nums[i]) {
             	max = nums[i];
             	continue;
             }
             sum += (max - nums[i]);
         }
         
         // 정답 출력
         System.out.println("#"+test_case+" "+sum);
		}
	}
}