package SWEA_1209_Sum;

import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		for(int test_case = 1; test_case <= 10; test_case++)
		{
            // testcase 입력 받기
			int T;
			T=sc.nextInt();
            
            // max 값 설정
            int max = 0;
            
            // 100짜리 배열 설정
            int[] nums = new int[100];
            
            // / 대각선, 반대 대각선 값 위한 설정
            int S = 0;
            int R = 0;
            
            // 대각선 값 구하기, 100입력 받기 (세로 max 값 위해), 가로 값 구하기 (바로 max와 비교)
			for (int i = 0 ; i < 100; i++) {
                int rSum = 0;
            	for (int j = 0; j < 100; j++) {
                	int num = sc.nextInt();
                    rSum += num;
                    nums[j] += num;
                    if(i == j) S += num;
                    if(i+j == 99 ) R += num;
                }
                if (max <rSum) max = rSum;
            }
            
            // 대각선들 max 값 비교
            if (max < S) max = S;
            if (R > max) max = R;
            
            // 세로 max 값 비교
            for (int i = 0; i < 100; i++) {
            	if (max < nums[i]) max = nums[i] ;
            }
            
            // 출력
            System.out.println("#"+T+" "+max);
		}
	}
}