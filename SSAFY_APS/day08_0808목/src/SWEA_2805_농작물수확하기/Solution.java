package SWEA_2805_농작물수확하기;

import java.util.Scanner;

class Solution
{
    static int[] dMin = {-1, 1};
    static int[] dMax = {1, -1};
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++)
        {
            int N = sc.nextInt();
            int min = N/2;
            int max = N/2;
            int sum = 0;
            int idx = 0;
            for (int i = 0; i < N ; i++ ) {
                String nums = sc.next();
                for (int j = 0; j < N; j++) {
                    int num = nums.charAt(j) - '0';
                    if (min <= j && j <= max) {
                        sum += num;
                    }
                }
                if (i == N/2) {
                    idx = 1;
                }
                min += dMin[idx];
                max += dMax[idx];
            }
            System.out.println("#"+test_case+" "+sum);
        }
    }
}