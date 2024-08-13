package SWEA_4613_러시아국기같은깃발;

import java.util.Scanner;
import java.io.FileInputStream;
class Solution
{
    static int N, M;
    static int[][] mR;
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		
		// test_case 수 입력
		int T;
		T=sc.nextInt();
		
		// test_case만큼 loop
		for(int test_case = 1; test_case <= T; test_case++)
		{
			// N, M 입력 받기
			N = sc.nextInt();
            M = sc.nextInt();
            String line;
            
            //각 줄의 W, B, R 수 입력 할 배열 생성
            mR = new int[N][3];
            
            // 입력받기
            for (int i = 0; i < N; i++) {
                line = sc.next();
                for (int j = 0; j < M; j++) {
                	switch (line.charAt(j)) {
                        case 'W' :
                        	mR[i][0] += 1;
                            break;
                        case 'B' : 
                        	mR[i][1] += 1;
                            break;
                        case 'R' : 
                        	mR[i][2] += 1;
                            break;
                    }
                }
            }
            
            // 범위 s, t를 계속 변화시켜 W, B, R인 부분 모두 설정하여 find 돌리기
            int min = 100000;
            int s = 1;
            int ans;
           while (s < N-1) {
            	int t = s+1;
                while (t < N) {
                    ans = find(s, t);
                    if ( ans < min) min = ans;
                	t++;
                }
               s++;
            }
           
           // 정답 출력
            System.out.println("#"+test_case+" "+min);
		}
	}
	
	// 주어지는 s, t를 기준으로 얼마나 칠해야 하는지 찾는 메소드
    public static int find (int s, int t)
        {
            int cor = 0;
            
            // s 미만은 흰색
            for (int i = 0;i < s; i++){
            	cor += (mR[i][1] + mR[i][2]);
            }
            
            // s하고 t 사이는 파란색
            for (int i = s;i < t; i++){
                cor += (mR[i][0] + mR[i][2]);
            }
            
            // t 이상은 빨간색
            for (int i = t;i < N; i++){
               	cor += (mR[i][0] + mR[i][1]);
            }
            return cor;
        }
}