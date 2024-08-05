package SWEA_1218_괄호짝짓기;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T=10;
		
		// 10번의 테스트 케이스 반복
		for(int test_case = 1; test_case <= T; test_case++)
		{
			// 부호의 개수 N
            int N = sc.nextInt();
            
            // N개의 부호 배열
            String[] words = sc.next().split("");
            
            // int를 요소로 가지는 List stack
            List<Integer> stack = new ArrayList<>();
            
            // 기본 정답 ans 1 설정, stack의 길이 idx 설정
            int idx = 0;
            int ans = 1;
            
            // N개의 부호들을 하나 하나 보기
            for (int i = 0; i < N; i++) {
            	
            	// (,),[,],{,},<,> 마다 특정 num 부여 (이 때 서로 열고 닫는 부호는 - 붙이면 동일)
                int num = 0;
            	if (words[i].equals("(")) {
                	num = 1;
                }
                else if (words[i].equals("[")) {
                	num = 2;
                }
                else if (words[i].equals("{")) {
                	num = 3;
                }
                else if (words[i].equals("<")) {
                	num = 4;
                }
                else if (words[i].equals(")")) {
                	num = -1;
                }
                else if (words[i].equals("]")) {
                	num = -2;
                }
                else if (words[i].equals("}")) {
                	num = -3;
                }
                else if (words[i].equals(">")){
                	num = -4;
                }
            	
            	// 이 때 여는 부호이면 stack.add
                if (num > 0) {
                	stack.add(num);
                    idx++;
                }
                
                // 닫는 부호이면
                else if (num < 0) {
                	
                	// 여는 부호보다 닫는 부호가 더 많지 않을 때
                	if (idx-1 >= 0){
                		
                		// 여는 부호와 한 쌍이면 삭제, idx-1
		            	if (stack.get(idx-1) == -num) {
                            
		                	stack.remove(idx-1);
		                    idx--;
		                }
		            	
		            	// 아니면 break
                        else {
                			ans = 0;
                			break;
                		}
                	}
                	
                	// 여는 부호보다 닫는 부호가 많으면 break;
                	else {
                		ans = 0;
                		break;
                	}
                }
            }
            
            // 만약 여는 부호가 남았다면 ans = 0
           if (idx > 0) {
            	ans = 0;
            }
           
           // 정답 출력
            System.out.println("#"+test_case+" "+ans);
		}
	}
}