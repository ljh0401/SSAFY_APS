package SWEA_1860_진기의최고급붕어빵;

import java.util.*;
 
class Solution
{
    public static void main(String args[]) throws Exception
    {
         
        Scanner sc = new Scanner(System.in);
        
        // test_case 입력
        int T;
        T=sc.nextInt();
        
        // for A 라벨, test 수 만큼 반복 
        A:
        for(int test_case = 1; test_case <= T; test_case++)
        {
        	
        	// N, M, K 입력 받기
            int N = sc.nextInt();
            int M = sc.nextInt();
            int K = sc.nextInt();
            
            // 사람이 최대한 늦게 오는 것이 111111이므로 111112로 배열 생성
            int[] persons = new int[11112];
            
            // 시간 별로 오는 사람 수 체크
            for (int i = 0; i < N; i++) {
                persons[sc.nextInt()] += 1;
            }
            
            // 붕어빵 수 boo, 맛있게 먹은 사람 수 yam 설정
            int boo = 0;
            int yam = 0;
            
            // 일단 진기는 모든지 possible
            String jingi = "Possible";
            
            // 붕어빵을 만들어보면서
            for (int i = 0; i <= 11111; i++){
            	
            	// 주어진 시간이 지날 때마다 붕어빵 개수 추가
                if (i != 0 & i%M == 0) {
                    boo += K;
                }
                
                // 만약 오는 사람이 없으면 그냥 넘어감
                if (persons[i] == 0) continue;
                
                // 있다면 붕어빵을 팔려고 시도
                boo -= persons[i];
                
                // 만약 붕어빵이 부족하면 진기는 불가능함
                if (boo < 0) {
                    jingi = "Impossible";
                    System.out.println("#"+test_case+" "+jingi);
                    continue A;
                }
                
                // 잘 팔았으면 yam한 사람 추가
                else {
                    yam += persons[i];
                }
                
                // 만약 모두가 yam하면 장사 끝
                if (yam >= N) break;
            }
            
            // 장사가 가능했는지 출력
            System.out.println("#"+test_case+" "+jingi);
        }
    }
}