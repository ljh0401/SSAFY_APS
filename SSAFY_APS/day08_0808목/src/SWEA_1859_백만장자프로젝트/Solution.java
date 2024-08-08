package SWEA_1859_백만장자프로젝트;

import java.util.Scanner;

// 현재 최대한 획기적으로 풀어보고자 생각 및 추가 변경 중입니다. (큰 차이가 없을 것 같기도 합니다.)

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
			long[] S = new long[N];
			
			// 매매가 입력 받기
            for (int i =0; i<N ; i++) {
                S[i] = sc.nextLong();
            }
            
            // 이득, 언제 팔면 좋을지를 알려주는 변수 설정
            long sum = 0;
            long max = 0;
            
            // 모두 검사해보며 최대 이득(max)일 때 팔고 sum에 더하기
            for (int i =0; i<N ; i++) {
                max = S[i];
                int idx = i;
            	for (int j = i; j < N; j++) {
                	if (S[j] > max) {
                        max = S[j];
                        idx = j;
                    } 
                }
                if (idx != i){
                for (int s = i; s <= idx; s++){
                	 sum += max-S[s];
               	 	}
                    i = idx;
                }
            }
            
            // 정답 출력
            System.out.println("#"+test_case+" "+sum);
		}
	}
}