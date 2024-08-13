package SWEA_6190_정곤이의단조증가하는수;

import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		
		// test_case 입력 받기
		int T;
		T=sc.nextInt();
		
		// test_case 수만큼 반복
		for(int test_case = 1; test_case <= T; test_case++)
		{
			
			// N 입력 받기
            int N = sc.nextInt();
            
            // 입력 받은 수 저장할 배열 생성
            int[] nums = new int[N];
            
            // 입력 받으면서 삽입 정렬 (sort 활용)
            for (int i = 0; i < N; i++) {
            	int num = sc.nextInt();
                if (i != 0) nums = sort(nums, num, i);
                else nums[i] = num;
            }
            
            // 가장 큰 수 max 설정
            int max = -1;
            
            // 라벨 A 붙이기, 단조인지 isDan으로 검사, 단조일경우 max와 비교
            A:
            for (int i = N-1; i >= 0; i--) {
            	for (int j = i-1; j >= 0; j--) {
                    int dan = nums[i] * nums[j];
                    if (dan <= max) {
                    	
                    	// 만약 j == i-1이고 둘이 곱한 것이 max보다 작으면 break;
                        if ( j == i-1 ) {
                        break A;
                        }
                        continue;
                    }
                    if (isDan(dan)) {
                        max = dan;
                    }
                }
            }
            
            // 정답 출력
            System.out.println("#"+test_case+" "+max);
        }
	}
	
	// 삽입 정렬 하기
    public static int[] sort(int[] nums, int num, int i) {
    	int j;
        for (j = i-1; j >= 0  && num < nums[j] ; j--) {
        	nums[j+1] = nums[j];
        }
        nums[j+1] = num;
        return nums;
    }
    
    
    // 단조인지 검사 (계속 10 나누어가며 커지는지 아닌지 검사)
    public static boolean isDan(int dan) {
        int a = dan%10;
        dan /= 10;
        while(dan != 0) {
        	int b = dan%10;
            dan /= 10;
            if (a >= b) {
            a = b;
            continue;
            }
            return false;
        }
        return true;
    }
}