package SWEA_1222_계산기1;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		
		// 10번의 test_case가 주어지므로 T = 10 입력
		int T;
		T=10;
		for(int test_case = 1; test_case <= T; test_case++)
		{
            int  N = sc.nextInt();
            
            // 식 입력 받기 (모두 쪼개서)
            String[] words = sc.next().split("");
            
            // 후위 표기로 저장할 cal, 기호만 잠시 저장할 idx 생성
            List<String> cal = new ArrayList<>();
            List<String> idx = new ArrayList<>();
            
            // 모든 식을 살펴보면서
            for (int i = 0; i < N; i++) {
            	
            	// +가 나올 경우 일단 임시 저장
            	if (words[i].equals("+")) {
                	idx.add("+");
                    continue;
                }
            	
            	// 숫자가 나올 경우 바로 cal에 저장, 만약 + 기호가 임시 저장되어 있다면 바로 이어서 저장
				cal.add(words[i]);
                if (idx.size() != 0) {
                	cal.add(idx.get(0));
                    idx.remove(0);
                }
            }
            
            // 후위 표기 식 계산 위한 loop
            while(cal.size() != 1) {
            	
            	// 연속으로 나오는 숫자 각각 등록
            	int num1 = Integer.parseInt(cal.get(0));
                int num2 = Integer.parseInt(cal.get(1));
   				
                // 다음에 나오는 것이 + 이면 (항상 + 이지만 구현해봄)
                if (cal.get(2).equals("+")) {
                	
                	// 숫자 제거
                    cal.remove(0);
                    cal.remove(1);
                    
                    // + 자리에 숫자 입력 (이 때 ArrayList는 remove 할 시 예전 참조값을 참조하여 다시 만들기에 remove 후에 set 필요)
                    cal.set(0, Integer.toString(num1+num2));
                }
            }
            
            // 다 더해진 값 ans로 입력
            int ans =  Integer.parseInt(cal.get(0)); 
            
            // 정답 출력
			System.out.println("#"+test_case+" "+ans);
		}
	}
}