package SWEA_2068_최대수구하기;

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
            int max = 0;
            for (int i = 0 ; i < 10; i++) {
                int num = sc.nextInt();
                if(max < num) max = num;
            }
            System.out.println("#"+test_case+" "+max);
        }
    }
}