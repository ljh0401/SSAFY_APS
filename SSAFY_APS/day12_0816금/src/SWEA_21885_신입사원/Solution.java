package SWEA_21885_신입사원;

import java.util.Scanner;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
 
class Solution
{
    static Scanner sc = new Scanner(System.in);
    static int N, min, max;
    static int[] stu;
    static List<Integer> stuC;
    public static void main(String args[]) throws Exception
    {
        int T;
        T=sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++)
        {
            N = sc.nextInt();
            min = sc.nextInt();
            max = sc.nextInt();
            stu = new int[N];
            stuC = new ArrayList<>();
            for (int i = 0; i < N;i++) {
                int num = sc.nextInt();
                stu[i] = num;
            }
            Arrays.sort(stu);
            for (int i = 0; i < N;i++) {
                int num = stu[i];
                if(!stuC.contains(num)) stuC.add(num);
            }
            int dif = 100;
            for (int i = 0; i < stuC.size();i++) {
                for (int j = i+1; j < stuC.size();j++) {
                    if (find(stuC.get(i), stuC.get(j)) != -1) {
                        dif = Math.min(find(stuC.get(i), stuC.get(j)), dif);
                    }
                }
            }
            if (dif == 100) dif = -1;
            System.out.println("#"+test_case+" " + dif);
        }  
    }
    public static int find(int s, int t) {
        int sum1 = 0;
        int sum2 = 0;
        int sum3 = 0;
        for (int i = 0; i < N; i++) {
            if (stu[i] <= s) {
                sum1 += 1;
            }
            else if (s < stu[i] && stu[i] <t ) {
                sum2 += 1;
            }
            else if (t <= stu[i]) {
                sum3 += 1;
            }
        }
        if ( min > sum1 || max < sum1 || min > sum2 || max < sum2 || min > sum3 || max < sum3 ) {
            return -1;
        }
        int a = Math.abs(sum3 - sum1);
        int b = Math.abs(sum2 - sum1);
        int c = Math.abs(sum3 - sum2);
        int d = Math.max(a, b);
        return Math.max(c, d);
    }
}