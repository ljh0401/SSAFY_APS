package SWEA_1966_숫자를정렬하자;

import java.util.Scanner;

class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        
        // test_case 수 입력 받기
        int T;
        T=sc.nextInt();
         
        // test 수 만큼 loop
        for(int test_case = 1; test_case <= T; test_case++)
        {
        	
        	// 숫자열 크기 N 입력 받기
            int N = sc.nextInt();
            
            // 숫자를 입력받고 정렬하여 답을 저장할 배열 생성
            int[] ans = new int[N];
            
            // 숫자들 입력 받기
            for (int i = 0; i < N; i++) {
                ans[i] = sc.nextInt();
            }
            
            // 숫자들 정렬 (삽입 정렬)
            for (int j = 1; j < N; j++) {
                int num = ans[j];
                int i;
                for (i = j-1; i >= 0 && num < ans[i]  ; i--) {
                    ans[i+1] = ans[i];
                }
                ans[i+1] = num;
            }
            
            // 정렬한 숫자열 출력하기
            System.out.print("#"+test_case);
            for (int j = 0; j < N; j++) {
                System.out.print(" "+ans[j]);
            }
            System.out.println();
        }
    }
}