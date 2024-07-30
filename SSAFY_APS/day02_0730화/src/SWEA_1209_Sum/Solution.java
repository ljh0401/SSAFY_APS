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
            int[][] nums = new int[100][100];
            int S = 0;
            int R = 0;
            for (int i = 0 ; i < 100; i++) {
                for (int j = 0; j < 100; j++) {
                    nums[i][j] = sc.nextInt();
                    if(i == j) S += nums[i][j];
                    if(i+j == 99 ) R += nums[i][j];
                }
            }
            max = S;
            if (R > max) max = R;
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
            System.out.println("#"+test_case+" "+max);
        }
    }
}