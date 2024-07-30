package SWEA_1210_ladder1;

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
            int[][] lad = new int[100][102];
            int jidx = 0;
            for (int i = 0; i < 100; i++) {
                for (int j = 1; j<101; j++) {
                    lad[i][j] = sc.nextInt();
                    if (lad[i][j] == 2) {
                        jidx = j;
                    }
                }
            }
            for (int i =99; i >=0; i--) {
                if (lad[i][jidx-1] == 0 && lad[i][jidx+1] == 0) {
                    continue;
                }
                if (lad[i][jidx-1] == 1) {
                    while (true) {
                        if (lad[i][jidx-1] == 1) jidx -= 1;
                        else break;
                    }
                }
                else if (lad[i][jidx+1] == 1) {
                    while (true) {
                        if (lad[i][jidx+1] == 1) jidx += 1;
                        else break;
                    }
                }
            }
            jidx -= 1;
            System.out.println("#"+test_case+" "+jidx);
        }
    }
}