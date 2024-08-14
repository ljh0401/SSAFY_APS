package SWEA_1248_공통조상;

import java.util.Scanner;
import java.util.List;
import java.util.LinkedList;
 
class Solution
{
	
	// 전체 정점의 개수 V, 간선의 개수 E, 조상을 찾아줘야 할 p1, p2 global 선언
    static int V, E, p1, p2;
    
    // 공통 조상을 찾을 때 사용할 배열 nums global 선언
    static int[] nums;
    
    // 모든 조상들을 나타내는 트리 myF global 선언
    static int[][] myF;
    
    // myF에 포함된 사람 수를 찾을 때 사용할 fM global 선언
    static int fM;
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++)
        {
        	
        	// V, E, p1, p2 입력 받기
            V = sc.nextInt();
            E = sc.nextInt();
            p1 = sc.nextInt();
            p2 = sc.nextInt();
            
            // leaf가 어느 root로 이어지는지를 나타낼 nums 배열 생성
            nums = new int[V+1];
            
            // 이진 트리를 선형으로 구현하기 위한 myF 설정
            myF = new int[V+1][3];
            
            // 모두 입력받으면서
            for (int i = 1; i < V; i++) {
                int first = sc.nextInt();
                int second = sc.nextInt();
                
                // nums엔 leaf가 어느 root로 향하는지
                nums[second] = first;
                
                // myF에는 왼쪽, 오른쪽 노드가 존재하면 넣어주고, 아니면 0으로 두기;
                if (myF[first][0] != 0) {
                    myF[first][2] = second;
                }
                else {
                    myF[first][0] = second;
                    myF[first][1] = first;
                }
                myF[second][1] = second;
            }
            
            // 우선 p1의 조상들 모두 찾기
            List<Integer> p1A = rUMyParent(p1);
            
            // p1의 조상들 중 p2와 가장 빨리 겹치는 조상 찾아놓기
            int ans = rUOurParent(p2, p1A);
            
            // 해당 조상이 포함된 부분 트리의 사람 수 측정
            fM = 0;
            myFam(ans);
            
            // 정답 출력
            System.out.println("#"+test_case+" "+ans+ " "+fM);
        }
    }
    
    // 특정 조상이 포함된 부분 트리의 노드 수를 측정하는 메서드
    public static void myFam(int ans) {
        fM+= 1;
        int L = myF[ans][0];
        int R = myF[ans][2];
        if (L != 0) {
            myFam(L);
        }
        if (R != 0) {
            myFam(R);
        }
    }
     
    // 입력된 사람 p와 다른 이의 조상들을 나타낸 pA 에서 가장 낮은 공통 조상을 찾는 메서드
    public static int rUOurParent(int p, List<Integer> pA) {
        while(p != 0) {
            if (pA.contains(p)) {
                return p;
            }
            p = nums[p];
        }
        return -1;
    }
     
    // 내 조상이 누구인지 찾는 메서드
    public static List<Integer> rUMyParent(int p) {
        List<Integer> pA = new LinkedList<>();
        while(p != 0) {
            pA.add(nums[p]);
            p = nums[p];
        }
        return pA;
    }
}