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
            // 값 입력
            int N = sc.nextInt();
            int M = sc. nextInt();
            // 파리 배열 생성
            int[][] pari = new int[N][N];
            // 파리 값 입력
            for (int i = 0; i < N; i++) {
                for (int j= 0; j < N; j++) pari[i][j] = sc.nextInt();
            }
            // max 생성
            int max = 0;

            // N-M까지 loop 돌며 pari kill 수 측정, max보다 클 시 max로 지정 
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
            // 정답 출력
            System.out.println("#"+test_case+" "+max);
        }
    }
}