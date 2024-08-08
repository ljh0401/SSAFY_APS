package SWEA_1966_숫자를정렬하자;

import java.util.Scanner;

class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
         
        for(int test_case = 1; test_case <= T; test_case++)
        {
            int N = sc.nextInt();
            int[] ans = new int[N];
            for (int i = 0; i < N; i++) {
                ans[i] = sc.nextInt();
            }
            for (int j = 1; j < N; j++) {
                int num = ans[j];
                int i;
                for (i = j-1; i >= 0 && num < ans[i]  ; i--) {
                    ans[i+1] = ans[i];
                }
                ans[i+1] = num;
            }
            System.out.print("#"+test_case);
            for (int j = 0; j < N; j++) {
                System.out.print(" "+ans[j]);
            }
            System.out.println();
        }
    }
}