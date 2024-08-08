package SWEA_1974_스도쿠검증;

import java.util.Scanner;
import java.util.Arrays;
 
class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        A:
        for(int test_case = 1; test_case <= T; test_case++)
        {
            int ans = 1;
            int[] sum = new int[8];
            int[] pro = new int[8];
            Arrays.fill(pro, 1);
            boolean[] B = new boolean[9];
            int[] SSum = new int[4];
            int[] PPro = new int[4];
            Arrays.fill(PPro, 1);
            boolean[] BB = new boolean[4];
            for (int i = 0 ; i < 9 ; i ++) {
                boolean three = false;
                int S = 0;
                int P = 1;
                for (int j = 0; j < 9; j++) {
                    int num = sc.nextInt();
                    if (num == 3) {
                        three = true;
                        B[j] = true;
                    }
                    S += num;
                    P *= num;
                    if ( i < 3 && j < 3) {
                        SSum[0] += num;
                        PPro[0] *= num;
                        if (num == 3) BB[0] = true;
                    }
                    else if ( i < 3 && 3<= j && j < 6) {
                        SSum[1] += num;
                        PPro[1] *= num;
                        if (num == 3) BB[1] = true;
                    }
                    else if ( j < 3 && 3<= i && i < 6) {
                        SSum[2] += num;
                        PPro[2] *= num;
                        if (num == 3) BB[2] = true;
                    }
                    else if ( 3<= j && j < 6 && 3<= i && i < 6) {
                        SSum[3] += num;
                        PPro[3] *= num;
                        if (num == 3) BB[3] = true;
                    }
                    if (j == 8) continue;
                    sum[j] += num;
                    pro[j] *= num;
                }
                if (S != 45 || P != 362880) {
                    ans = 0;
                }
                else if (!three) {
                    ans = 0;
                }
            }
            if (ans == 0) {
                System.out.println("#"+test_case+" "+ans);
                continue A;
            }
            for (int i = 0; i < 8; i++) {
                if (sum[i] != 45 || pro[i] != 362880) {
                    ans = 0;
                    System.out.println("#"+test_case+" "+ans);
                    continue A;
                }
                else if (!B[i]) {
                    ans = 0;
                    System.out.println("#"+test_case+" "+ans);
                    continue A;
                }
            }
            for (int i = 0; i < 4; i++) {
                if (SSum[i] != 45 || PPro[i] != 362880) {
                    ans = 0;
                    System.out.println("#"+test_case+" "+ans);
                    continue A;
                }
                else if (!BB[i]) {
                    ans = 0;
                    System.out.println("#"+test_case+" "+ans);
                    continue A;
                }
            }           
            System.out.println("#"+test_case+" "+ans);
        }
    }
}