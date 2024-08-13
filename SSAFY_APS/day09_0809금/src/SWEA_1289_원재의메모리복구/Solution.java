package SWEA_1289_원재의메모리복구;

import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		
		// test_case 입력 받기
		int T;
		T=sc.nextInt();
		
		// test_case 만큼 loop
		for(int test_case = 1; test_case <= T; test_case++)
		{
			
			// String으로 입력 받기
			String nums = sc.next();
            int ans = 0;
            
            // 1, 0 왔다갔다 판단할 find 설정
            boolean find = false;
            
            // 처음부터 끝까지 다 보면서 1, 0 혹은 0 ,1로 변하는 경우 찾기(find를 통해 좀 더 확실히)
            for (int i = 0; i < nums.length(); i++) {
                if (!find && nums.charAt(i) == '1') {
                    ans++;
                    find = true;
                }
                else if (find && nums.charAt(i) == '0') {
                    ans++;
                    find = false;
                }
            }
            
            // 정답 출력
            System.out.println("#"+test_case+" "+ans);
		}
	}
}