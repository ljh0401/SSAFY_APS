package SWEA_6485_삼성시의_버스;

import java.util.*;
 
class Solution
{
    static Scanner sc = new Scanner(System.in);
    static int N, P;
    public static void main(String args[]) throws Exception
    {
        int T =sc.nextInt();
        for (int test = 1; test <= T; test++) {
            N = sc.nextInt();
             
            int[] bus = new int[5001]; 
            for (int i = 0; i< N; i++) {
                int A = sc.nextInt();
                int B = sc.nextInt();
                for (int j = A; j <= B; j++) {
                    bus[j] += 1;
                }
            }
            P = sc.nextInt();
            System.out.print("#"+test);
 
            for (int i = 0; i < P; i++) {
                System.out.print(" "+ bus[sc.nextInt()]);
            }
            System.out.println();
        }
    }
}