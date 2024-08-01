package SWEA_1208_flatten;

import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		for(int test_case = 1; test_case <= 10; test_case++)
		{
            // 옮길 수 있는 횟수 입력
            int chance = sc.nextInt();

            // idx만큼의 박스만큼의 높이를 가지는 줄의 개수를 나타내는 배열 생성
            int[] boxes = new int[101];
            int find = 0;
            int ans = 0;

            // 배열에 입력, 후에 전체 boxes 수가 홀수 일 경우 0이 답으로 제시될 경우를 제외하기 위해 find 활용
            for (int i = 0; i < 100 ;i++) {
                int tmp = sc.nextInt();
                find += tmp%2;
            	boxes[tmp] += 1;
            }

            // 역으로 카운트
            for (int i = 99; i > 0 ;i--) {
                boxes[i] += boxes[i+1];
            }
            int usum = 0;
            int dsum = 0;
            int uIdx = 0;
            int dIdx = 0;

            // 아래서부터 boxes 채워 나가다 chance 보다 더 채워야하면 멈춤
            for (int i = 1; i < 101; i++) {
                dsum += (100 - boxes[i]);
                if (dsum > chance) {
                    dIdx = i-1;
                    break;
                }
            }

            // 위에서부터 boxes 빼다가 chance 보다 더 빠져야하면 멈춤
            for (int i = 100; i > 0; i--) {
                usum += boxes[i];
                if (usum >= chance) {
                    uIdx = i;
                    break;
                }
            }

            // 판정하여서 ans 부여
        	if (dIdx >= uIdx && find%2 == 0) {
        		ans = 0;
        	}
        	else if (dIdx >= uIdx) {
        		ans = 1;
        	}
        	else {
        		ans = uIdx-dIdx;
        	}

            //출력
        	System.out.println("#"+test_case+" "+ans);
		}
	}
}