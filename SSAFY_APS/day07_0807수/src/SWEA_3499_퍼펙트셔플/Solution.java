package SWEA_3499_퍼펙트셔플;

import java.util.Scanner;

class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);

        // test_case 입력
        int T;
        T=sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++)
        {
            // 카드의 개수 입력 받기
            int N = sc.nextInt();

            // 셔플 다 한 카드들을 저장할 배열 설정
            String[] cards = new String[N];

            // N+1/2-1 보다 작거나 같은 idx를 기준으로 카드를 나누어 셔플
            for (int i = 0; i < N; i++) {
                if (i <= (N+1)/2-1) {
                    cards[2*i] = sc.next();
                }
                else {
                    cards[(i - (N+1)/2)*2+1] = sc.next();
                }
            }

            // 셔플된 카드들 출력
            System.out.print("#"+test_case);
            for  (int i = 0; i < N; i++) {
                System.out.print(" "+cards[i]);
            }
            System.out.println();
        }
    }
}