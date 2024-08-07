package SWEA_7102_준홍이의카드놀이;

import java.util.Scanner;
 
class Solution
{
    public static void main(String args[]) throws Exception
    {
         
        Scanner sc = new Scanner(System.in);

        // test_case 입력 받기
        int T;
        T=sc.nextInt();

        // 그만큼 loop
        for(int test_case = 1; test_case <= T; test_case++)
        {
            // N, M 입력 받기
            int N = sc.nextInt();
            int M = sc.nextInt();
            int num;
            int sub;

            // N, M 중 작은 수는 num으로, 둘의 차는 sub로 저장
            if (N > M) {
                num = M;
                sub = N - M;
            }
            else {
                num = N;
                sub = M - N;
            }

            // 둘의 차이만큼 ++num 하면서 출력 (둘의 카드셋 크기가 동일할 때 작은 수 +1인 수가 가장 확률이 높음,
            // 크기가 동일하지만 구성하는 수가 커질 경우 첫 카드가 1보다 커진 만큼 또 +1 해주면 확률이 동일함.)
            System.out.print("#"+test_case);
            for (int i = 0; i <= sub; i++) {
                ++num;
                System.out.print(" "+num);
            }
            System.out.println();
        }
    }
}