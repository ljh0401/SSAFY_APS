package SWEA_보물상자_비밀번호;

import java.util.Scanner;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

class Solution
{
	static int N, K;
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{
			N = sc.nextInt();
			K = sc.nextInt();
			String[] words = sc.next().split("");
			List<String> list = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				list.add(words[i]);
			}
			List<String> nums = new ArrayList<>();
			int tmp = N/4;
			for (int i = 0; i < tmp; i++ ) {
				for (int j = 0; j<4; j++) {
					String num = "";
					for (int s = tmp*j; s<tmp*(j+1); s++) {
					num += list.get(s);
					}
					if(!nums.contains(num)) {
						nums.add(num);	
					}
				}
				String move = list.get(0);
				list.remove(0);
				list.add(move);
			}
			int[] num10 = new int[nums.size()];
			for (int i = 0; i < nums.size(); i++) {
				int plus = M10(nums.get(i), tmp);
				num10[i] = plus;
			}
			Arrays.sort(num10);
			System.out.println("#"+test_case+" "+ num10[nums.size()- K]);
        }
	}
	
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