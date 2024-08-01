package SWEA_1954_달팽이숫자;

import java.util.Scanner;
import java.io.FileInputStream;
import java.util.Arrays;

class Solution
{   
    // delta 지정
    static int[] rD = {1, 0, -1, 0};
    static int[] cD = {0, -1, 0, 1};
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);

        // testcase 입력
		int T;
		T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{
            // N 입력
			int N = sc.nextInt();

            // N*N 생성
            int[][] snail = new int [N][N];

            // 입력할 숫자(num), delta 지표(idx), snail의 좌표(c,r) 지정
            int num = 1;
            int idx = 0;
            int c = 0;
            int r = 0;

            // 시작 지점 1 입력
            snail[c][r] = num;
			while(true) {
                // snail 범위를 벗어나지 않을 때
                if (0 > c+cD[idx%4] || c+cD[idx%4] > N-1 || 0 > r+rD[idx%4] || r+rD[idx%4] > N-1) idx++;
                // delta를 더한 좌표가 0일 때 num 입력
                else if (snail[c+cD[idx%4]][r+rD[idx%4]] == 0) {
                	snail[c+cD[idx%4]][r+rD[idx%4]] = ++num;
                    c += cD[idx%4];
                    r += rD[idx%4];
                }
                // 그렇지 않다면 delta 값 변경
                else idx++;

                // 모두 입력했으면 break;
				if (num == N*N) {break;}
            }

            // 정답 입력
            System.out.println("#"+test_case);
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
            	System.out.print(snail[i][j]+" ");
                }
                System.out.print("\n");
            }
		}
	}