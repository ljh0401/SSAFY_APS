package SWEA_1225_암호생성기;

import java.util.*;
 
class Solution
{
    public static void main(String args[]) throws Exception
    {
         
        Scanner sc = new Scanner(System.in);
         
        // test_case 10번
        int T;
        T=10;
        for(int test_case = 1; test_case <= T; test_case++)
        {
            // test 번호 입력 받기
            int test = sc.nextInt();

            // queue 처럼 기능할 List queue 생성
            List<Integer> queue = new ArrayList<>();
            for (int i = 0; i < 8; i++) {
                queue.add(sc.nextInt());
            }
            
            // 처음 뺄 값 1 설정
            int n = 1;

            // 0이 나올 때까지 loop
            while (true) {

                // 맨 앞 숫자 - n 이 0보다 크면 맨 앞 숫자에 n을 빼고 없앤 뒤 맨 뒤에 다시 추가
                if (queue.get(0) - n > 0) {
                    int tmp = queue.get(0)-n;
                    queue.remove(0);
                    queue.add(tmp);
                    n++;
                }

                // 0 이 나오거나 0보다 작으면 맨 뒤로 보내고 break
                else {
                    int tmp = 0;
                    queue.remove(0);
                    queue.add(tmp);
                    break;
                }

                // n이 6일때마다 초기화
                if (n == 6) {
                    n = 1;
                }
            }
            
            // 정답 출력
            System.out.print("#"+test);
            for (int i = 0; i < 8; i++) {
                System.out.print(" "+queue.get(i));
            }
            System.out.println();
        }
    }
}