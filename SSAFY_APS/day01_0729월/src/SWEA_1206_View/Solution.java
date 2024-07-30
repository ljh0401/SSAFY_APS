package SWEA_1206_View;

import java.util.Scanner;
import java.io.FileInputStream;
 
class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T= 10;
        for(int test_case = 1; test_case <= T; test_case++)
        {
            int N = sc.nextInt();
            int[] bd = new int [N];
            for (int i = 0; i < N; i++) {
                bd[i] = sc.nextInt();
            }
            int sum = 0;
            for (int i = 2; i < N-2; i++) {
                int min = 255;
                if (bd[i] - bd[i-2] <= 0 || bd[i] - bd[i-1] <= 0 || bd[i] - bd[i+2] <= 0 || bd[i] - bd[i+1] <= 0  ) continue;
                if (min >bd[i] - bd[i-2]) min = bd[i] - bd[i-2];
                if (min >bd[i] - bd[i-1]) min = bd[i] - bd[i-1];
                if (min >bd[i] - bd[i+1]) min = bd[i] - bd[i+1];
                if (min >bd[i] - bd[i+2]) min = bd[i] - bd[i+2];
                sum += min;
            }
            System.out.println("#"+test_case+" "+sum);
        }
    }
}