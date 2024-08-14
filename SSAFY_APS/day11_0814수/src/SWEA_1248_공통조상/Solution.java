package SWEA_1248_공통조상;

import java.util.Scanner;
import java.util.List;
import java.util.LinkedList;
 
class Solution
{
    static int V, E, p1, p2;
    static int[] nums;
    static int[][] myF;
    static int fM;
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++)
        {
            V = sc.nextInt();
            E = sc.nextInt();
            p1 = sc.nextInt();
            p2 = sc.nextInt();
            nums = new int[V+1];
            myF = new int[V+1][3];
            for (int i = 1; i < V; i++) {
                int first = sc.nextInt();
                int second = sc.nextInt();
                nums[second] = first;
                if (myF[first][0] != 0) {
                    myF[first][2] = second;
                }
                else {
                    myF[first][0] = second;
                    myF[first][1] = first;
                }
                myF[second][1] = second;
            }
            List<Integer> p1A = rUMyParent(p1);
            int ans = rUOurParent(p2, p1A);
            fM = 0;
            myFam(ans);
            System.out.println("#"+test_case+" "+ans+ " "+fM);
        }
    }
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
     
    public static int rUOurParent(int p, List<Integer> pA) {
        while(p != 0) {
            if (pA.contains(p)) {
                return p;
            }
            p = nums[p];
        }
        return -1;
    }
     
    public static List<Integer> rUMyParent(int p) {
        List<Integer> pA = new LinkedList<>();
        while(p != 0) {
            pA.add(nums[p]);
            p = nums[p];
        }
        return pA;
    }
}