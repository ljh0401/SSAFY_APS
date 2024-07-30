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
            // 값 입력
            int N = sc.nextInt();
            int[][] nMap = new int[N][N];
            // 빙글빙글 돌면서 사용할 값들 지정 (x, y는 좌표 ; a, b는 어디까지 돌 지 정하는 지표 ; num은 입력할 값)
            int x = 0;
            int y = 0;
            int a = 0;
            int b = N-1;
            int num = 1;
            // loop를 돌며 값들 입력
            while(true) {
                // 왼 -> 오
                if (x < b && y == a) {
                    nMap[y][x] = num;
                    num++;
                    x++;
                    if (num == N*N+1) break;
                }
                // 위 -> 아래
                else if (x == b && y < b) {
                    nMap[y][x] = num;
                    num++;
                    y++;
                    if (num == N*N+1) break;
                }
                // 오 -> 왼
                else if (y == b && x > a) {
                    nMap[y][x] = num;
                    num++;
                    x--;
                    if (x == a) b--;
                    if (num == N*N+1) break;
                }
                // 아래 -> 위
                else if (x == a && y > a+1) {
                    nMap[y][x] = num;
                    num++;
                    y--;
                    if (y == a+1) {
                    a++;
                    }
                    if (num == N*N+1) break;
                }
                // 마지막 num은 직접 채워주기
                if (num == N*N) {
                    nMap[y][x] = num;
                    break;
                }
            }
            // 정답 출력
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