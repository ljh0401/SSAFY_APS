package SWEA_1228_암호문1;

import java.util.Scanner;
import java.util.List;
import java.util.LinkedList;
 
class Solution
{
	// scanner global 설정
    static Scanner sc = new Scanner(System.in);
    
    // 저장하고 변경할 list global 설정
    static List<Integer> list;
    public static void main(String args[]) throws Exception
    {
         
    	// 10번 동안 loop
        int T = 10;
        for(int test_case = 1; test_case <= T; test_case++)
        {
            int N = sc.nextInt();
            
            // 매 test 마다 새로 list 참조
            list = new LinkedList<>();
            
            // 일단 입력 받기
            for (int i = 0; i < N; i++) {
                list.add(sc.nextInt());
            }
            
            // M개의 지시 이행
            int M = sc.nextInt();
            for (int i = 0; i < M; i++) {
                String word = sc.next();
                
                // I인 경우만 있으므로  I 실행 (혹시 모르니 if)
                if (word.equals("I")) {
                    I();
                }
            }
            
            // 결과 출력
            System.out.print("#"+test_case);
            for (int i = 0; i < 10; i++) {
                System.out.print(" "+list.get(i));
            }
            System.out.println();
        }
    }
     
    // I 일 때 지시문 이행
    public static void I() {
    	
    	// x, y 입력 받기
        int x = sc.nextInt();
        int y = sc.nextInt();
        
        // y번 돌리면서 x 이후에 입력
        for (int i = 0; i < y; i++) {
            list.add(x+i, sc.nextInt());
        }
    }
     
}