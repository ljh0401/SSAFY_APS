package SWEA_1231_중위순회;

import java.util.Scanner;

class Solution
{
	
	// global N, words 지정
    static int N;
    static String[] words;
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        
     // 10번 loop
        int T;
        T=10;
        for(int test_case = 1; test_case <= T; test_case++)
        {
        	
        	// N 입력 받고
            N = sc.nextInt();
            
            // words를 N+1 크기의 배열로 생성
            words = new String[N+1];
            
            // 입력 받은 idx 위치에 글자 입력
            for (int i = 1; i < N+1; i++) {
                int idx = sc.nextInt();
                words[idx] = sc.next();
                sc.nextLine();
            }
            
            // 기본 출력 먼저 하고 중위 순회 하면서 자동 출력
            int count = 1;
            System.out.print("#"+test_case+" ");
            inOrder(count);
            System.out.println();
        }
    }
     
    
    // 중위 순회 하면서 바로바로 출력하기
    public static void inOrder(int count) {
        if (count > N) {
            return;
        }
        inOrder(2*count);
        System.out.print(words[count]);
        inOrder(2*count+1);
    }
}