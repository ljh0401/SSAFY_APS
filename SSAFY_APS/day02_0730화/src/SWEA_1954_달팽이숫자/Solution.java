package SWEA_1954_달팽이숫자;

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
            int[][] nMap = new int[N][N];
            int x = 0;
            int y = 0;
            int a = 0;
            int b = N-1;
            int num = 1;
            while(true) {
                if (x < b && y == a) {
                    nMap[y][x] = num;
                    num++;
                    x++;
                    if (num == N*N+1) break;
                }
                else if (x == b && y < b) {
                    nMap[y][x] = num;
                    num++;
                    y++;
                    if (num == N*N+1) break;
                }
                else if (y == b && x > a) {
                    nMap[y][x] = num;
                    num++;
                    x--;
                    if (x == a) b--;
                    if (num == N*N+1) break;
                }
                else if (x == a && y > a+1) {
                    nMap[y][x] = num;
                    num++;
                    y--;
                    if (y == a+1) {
                    a++;
                    }
                    if (num == N*N+1) break;
                }
                if (num == N*N) {
                    nMap[y][x] = num;
                    break;
                }
            }
            System.out.println("#"+test_case);
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                System.out.print(nMap[i][j]+" ");
                }
                System.out.print("\n");
            }
        }
    }
}