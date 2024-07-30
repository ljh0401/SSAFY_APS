package SWEA_1984_중간평균값구하기;

import java.util.Scanner;
import java.io.FileInputStream;
 
class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++)
        {
            int[] nums = new int[10];
            int max = 0;
            int min = 10001;
            int ans = 0;
            for(int i = 0; i < 10; i++) {
                nums[i] = sc.nextInt();
                ans += nums[i];
                if (max < nums[i]) max = nums[i];
                if (min > nums[i]) min = nums[i];
            }
            float result = ans - max - min;
            result /=8;
            int con = Math.round(result);
            System.out.println("#"+test_case+" "+con);
        }
    }
}