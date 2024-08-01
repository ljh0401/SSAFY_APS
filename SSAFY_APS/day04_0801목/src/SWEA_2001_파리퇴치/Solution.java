package SWEA_2001_파리퇴치;

import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
    // N, M 글로벌 선언
    static int N, M;
    static Scanner sc = new Scanner(System.in);
	public static void main(String args[]) throws Exception
	{
        // testcase 수 입력받기
		int T;
		T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{
            // N, M 입력 받기
			N = sc.nextInt();
            M = sc. nextInt();
            
            // 전문 파리 킬러 고용
           	int max = pari_killer();
            
            // 파리 킬러의 결과를 출력
            System.out.println("#"+test_case+" "+max);
		}
	}

    public static Integer pari_killer () {
    	// 파리 수 입력 받기
       	int[][] pari = new int[N][N];
        for (int i = 0; i < N; i++) {
           	for (int j= 0; j < N; j++) {
                pari[i][j] = sc.nextInt();
            }
        }
        
        // 어디를 때려야  가장 많이 죽일지 계산
        int max = 0;
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
        
        // 가장 많이 죽인 결과를 전달
        return max;
    }
}