package SWEA_보물상자_비밀번호;

import java.util.Scanner;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

class SolutionWComment
{
	
	// 숫자의 개수 N, 몇 번째로 큰 걸 택하는 지 알려주는 K global 선언
	static int N, K;
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		
		// T 만큼 loop
		int T;
		T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{
			
			// 숫자의 개수 N 입력 받기
			N = sc.nextInt();
			
			// 몇 번째 선택할 것인지 알려주는 K 입력 받기
			K = sc.nextInt();
			// 숫자들 입력 받고 ArratList로 만들어주기 (지금 생각해보면 왜 했는지 싶습니다.)
			String[] words = sc.next().split("");
			List<String> list = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				list.add(words[i]);
			}
			
			// 나누어진 숫자들 입력받을 List nums 생성
			List<String> nums = new ArrayList<>();
			
			// 4 부분으로 나누어지므로 기준이 될 tmp 설정
			int tmp = N/4;
			
			// tmp만큼 회전 반복하면서
			for (int i = 0; i < tmp; i++ ) {
				
				// 4개의 숫자를 nums에 등록
				for (int j = 0; j<4; j++) {
					String num = "";
					for (int s = tmp*j; s<tmp*(j+1); s++) {
					num += list.get(s);
					}
					
					// 만약 nums에 num이 이미 있다면 등록하지 않음
					if(!nums.contains(num)) {
						nums.add(num);	
					}
				}
				
				// 회전하기 위해 0번째 지우고 add
				String move = list.get(0);
				list.remove(0);
				list.add(move);
			}
			
			// 숫자로 변환한 nums를 입력할 행렬 num10 생성
			int[] num10 = new int[nums.size()];
			
			// 모든 수를 M10 메서드를 통해 10진수로 변환
			for (int i = 0; i < nums.size(); i++) {
				int plus = M10(nums.get(i), tmp);
				num10[i] = plus;
			}
			
			// 정렬하여 원하는 순서의 정답 출력
			Arrays.sort(num10);
			System.out.println("#"+test_case+" "+ num10[nums.size()- K]);
        }
	}
	
	
	// 입력된 16진수의 한 부분을 10진수 기준으로 변경
	public static int m10(char c) {
		int tmp = 0;
		if (c == 'A') {
			tmp = 10;
		}
		else if (c == 'B') {
			tmp = 11;
		}
		else if (c == 'C') {
			tmp = 12;
		}
		else if (c == 'D') {
			tmp = 13;
		}
		else if (c == 'E') {
			tmp = 14;
		}
		else if (c == 'F') {
			tmp = 15;
		}
		else {
			tmp = c - '0';
		}
		return tmp;
	}
	
	// 입력받은 16진수를 10진수로 표현
	public static int M10(String s, int tmp) {
		int a = 1;
		int sum = 0;
		for (int i = tmp-1; i >=0; i--) {
			sum += m10(s.charAt(i))*a;
			a *= 16;
		}
		return sum;
	}
}