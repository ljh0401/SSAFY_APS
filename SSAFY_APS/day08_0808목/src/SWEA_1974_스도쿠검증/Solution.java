package SWEA_1974_스도쿠검증;

import java.util.Scanner;
import java.util.Arrays;
 
/**	2805 농작물 문제와 같이 입력한 결과를 저장하지 아니하고 최대한 풀어보고자 노력한 결과 너무 긴 스파게티가 나와버렸습니다. ㅜㅜ
 * 	간단하게 사용한 원리를 설명하겠습니다.
 * 	
 * 	우선 1~9까지의 합과 곱이 모두 동일한 경우는 1가지 특이 케이스(이 때 해당 숫자열엔 3이 존재하지 않아 합과 곱이 동일할 때
 * 	스도쿠가 올바른지 판단하기 위해 3의 유무를 검사합니다.)를 제외하면 없다는 점에 착안, 합과 곱을 가지고 가로, 세로, 3*3 행렬을 검사 했습니다.
 * 
 * 이 때 가로는 9줄 모두, 세로는 8줄만 (1~9가 총 9개씩 있으므로 8개만 검사하면 나머지는 자동 입증), 
 * 3*3 행렬은 4개만 (9개 중 큰 한 줄에 2개씩만 검사하면 나머지 1개는 자동으로 입증) 검사하여 스도쿠인지를 판별하였습니다.
 * 
 */

class Solution
{
    public static void main(String args[]) throws Exception
    {
    	
    	// test case 입력 받기
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        
        // A로 loop 라벨, test 수 만큼 loop
        A:
        for(int test_case = 1; test_case <= T; test_case++)
        {
            int ans = 1;
            
            // 세로줄 검사 위한 배열 생성
            int[] sum = new int[8];
            int[] pro = new int[8];
            Arrays.fill(pro, 1);
            boolean[] B = new boolean[9];
            
            // 3*3 검사 위한 배열 생성
            int[] SSum = new int[4];
            int[] PPro = new int[4];
            Arrays.fill(PPro, 1);
            boolean[] BB = new boolean[4];
            
            // 입력 + 가로줄 검사 + 검사 위한 세로줄, 3*3 행렬 수 입력
            for (int i = 0 ; i < 9 ; i ++) {
            	
            	// 가로줄 검사 위한 변수 설정
                boolean three = false;
                int S = 0;
                int P = 1;
                
                // 숫자 입력 받으면서 필요한 곳에 모두 입력
                for (int j = 0; j < 9; j++) {
                    int num = sc.nextInt();
                    
                    // 3이 나올 경우 가로, 세로 줄에 3이 나왔음을 입력
                    if (num == 3) {
                        three = true;
                        B[j] = true;
                    }
                    
                    // 가로줄 합, 곱 추가
                    S += num;
                    P *= num;
                    
                    // 3*3 행렬 판단 위한 값 추가
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
                    
                    // 세로 줄 판단 위한 값 추가 (9 한 줄은 그냥 넘어가도 괜찮으므로 8 continue)
                    if (j == 8) continue;
                    sum[j] += num;
                    pro[j] *= num;
                }
                
                // 이 때 가로줄의 합, 곱이 1~9까지의 합과 곱가 동일하지 않다면, 혹은 동일하더라도 3이 없다면 스도쿠 아님. (전체 입력을 위해 continue A를 하지 않았습니다.)
                if (S != 45 || P != 362880) {
                    ans = 0;
                }
                else if (!three) {
                    ans = 0;
                }
            }
            
            // ans = 0 이라면 정답 출력, continue A
            if (ans == 0) {
                System.out.println("#"+test_case+" "+ans);
                continue A;
            }
            
            // 세로줄 검증
            for (int i = 0; i < 8; i++) {
            	
            	// 이 때 세로줄의 합, 곱이 1~9까지의 합과 곱가 동일하지 않다면, 혹은 동일하더라도 3이 없다면 스도쿠 아님.
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
            
            // 3*3 행렬 검증
            for (int i = 0; i < 4; i++) {
            	
            	// 이 때 행렬의 합, 곱이 1~9까지의 합과 곱가 동일하지 않다면, 혹은 동일하더라도 3이 없다면 스도쿠 아님. (전체
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
            
            // 모두 통과했을 경우 1 출력
            System.out.println("#"+test_case+" "+ans);
        }
    }
}