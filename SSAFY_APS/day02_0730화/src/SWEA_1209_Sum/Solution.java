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
            int T;
            T=sc.nextInt();
            int max = 0;

            // 100*100 배열 생성
            int[][] nums = new int[100][100];
            int S = 0;
            int R = 0;
            // 배열에 값 입력 + 대각선 합 구하기
            for (int i = 0 ; i < 100; i++) {
                for (int j = 0; j < 100; j++) {
                    nums[i][j] = sc.nextInt();
                    if(i == j) S += nums[i][j];
                    if(i+j == 99 ) R += nums[i][j];
                }
            }

            // 대각선 합 중 큰 값 max 지정
            max = S;
            if (R > max) max = R;

            // 가로 세로 합 구해서 max랑 비교 후 더 크면 max로 지정
            for (int i = 0 ; i < 100; i++) {
                int rSum = 0;
                int cSum = 0;
                for (int j = 0; j < 100; j++) {
                    rSum += nums[i][j];
                    cSum += nums[j][i];
                }
                if (max <rSum) max = rSum;
                if (max <cSum) max = cSum;
            }

            // 정답 출력
            System.out.println("#"+test_case+" "+max);
        }
    }
}