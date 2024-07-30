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

            // 100 * 102 배열 생성 (2는 양옆으로 탐색할 때 length 초과 나오지 않도록)
            int[][] lad = new int[100][102];
            int jidx = 0;

            // 값 입력, 마지막 2인 지점(도착 지점)의 위치 정보 저장
            for (int i = 0; i < 100; i++) {
                for (int j = 1; j<101; j++) {
                    lad[i][j] = sc.nextInt();
                    if (lad[i][j] == 2) {
                        jidx = j;
                    }
                }
            }

            // 2인 마지막 지점부터 위로 올라가면서 정답으로 향하는 처음 시작 지점 탐색
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

            // 102로 처음 배열 만들어서 달라진 값 조정
            jidx -= 1;

            // 정답 출력
            System.out.println("#"+test_case+" "+jidx);
        }
    }
}