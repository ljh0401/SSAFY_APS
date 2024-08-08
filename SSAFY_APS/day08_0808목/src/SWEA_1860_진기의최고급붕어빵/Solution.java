package SWEA_1860_진기의최고급붕어빵;

import java.util.*;
 
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
            int N = sc.nextInt();
            int M = sc.nextInt();
            int K = sc.nextInt();
            int[] persons = new int[11112];
            for (int i = 0; i < N; i++) {
                persons[sc.nextInt()] += 1;
            }
            int boo = 0;
            int yam = 0;
            String jingi = "Possible";
            for (int i = 0; i <= 11111; i++){
                if (i != 0 & i%M == 0) {
                    boo += K;
                }
                if (persons[i] == 0) continue;
                boo -= persons[i];
                if (boo < 0) {
                    jingi = "Impossible";
                    System.out.println("#"+test_case+" "+jingi);
                    continue A;
                }
                else {
                    yam += persons[i];
                }
                if (yam >= N) break;
            }
            System.out.println("#"+test_case+" "+jingi);
        }
    }
}