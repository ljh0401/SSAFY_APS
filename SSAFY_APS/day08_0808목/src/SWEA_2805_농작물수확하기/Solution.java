package SWEA_2805_농작물수확하기;

import java.util.Scanner;

class Solution
{
	// 수확할 수 있는 농작물 위치 판단 위한 min과 max의 조절을 위한 delta 설정
    static int[] dMin = {-1, 1};
    static int[] dMax = {1, -1};
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        
        // test_case 횟수 입력 받기
        int T;
        T=sc.nextInt();
        
        // test 수 만큼 loop
        for(int test_case = 1; test_case <= T; test_case++)
        {
        	
        	// N 입력 받기
            int N = sc.nextInt();
            
            // 수확할 수 있는 농작물 위치 판단 위한 min과 max 기본 설정
            int min = N/2;
            int max = N/2;
            
            // 수확한 농산물 수 저장할 sum, delta 조절할 idx 생성
            int sum = 0;
            int idx = 0;
            
            // loop를 통해 입력 받으면서 필요한 부분만 발췌하여 sum에 더하기
            for (int i = 0; i < N ; i++ ) {
                String nums = sc.next();
                for (int j = 0; j < N; j++) {
                    int num = nums.charAt(j) - '0';
                    if (min <= j && j <= max) {
                        sum += num;
                    }
                }
                
                // 만약 중간 지점이면 delta 조절
                if (i == N/2) {
                    idx = 1;
                }
                
                // min과 max 값 적절하게 조정
                min += dMin[idx];
                max += dMax[idx];
            }
            
            // 정답 출력
            System.out.println("#"+test_case+" "+sum);
        }
    }
}