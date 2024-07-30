package SWEA_2001_파리퇴치;

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
            int N = sc.nextInt();
            int M = sc. nextInt();
            int[][] pari = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j= 0; j < N; j++) pari[i][j] = sc.nextInt();
            }
            int max = 0;
            for (int i = 0; i < N-M+1; i++) {
                for (int j = 0; j < N-M+1; j++) {
                    int kill = 0;
                    for (int p = 0; p < M; p++) {
                        for (int r = 0; r < M; r++) {
                            kill += pari[i+p][j+r];
                        }
                    }
                    if (max < kill) max = kill;
                }
            }
            System.out.println("#"+test_case+" "+max);
        }
    }
}