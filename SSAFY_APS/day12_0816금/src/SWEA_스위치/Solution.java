package SWEA_스위치;

import java.util.Scanner;
 
class Solution
{
    static Scanner sc = new Scanner(System.in);
    static int N, stu;
    static int[] onOff;
    public static void main(String args[]) throws Exception
    {
        N =sc.nextInt();
        onOff = new int[N];
        for (int i = 0; i < N; i++) {
            onOff[i] = sc.nextInt();
        }
        stu = sc.nextInt();
        for(int i = 0; i <stu; i++) {
            if (sc.nextInt() == 2) {
                girl();
            }
            else {
                boy();
            }
        }
        int size = N/20 + 1;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < 20; j++) {
                try {
                    System.out.print(onOff[j+20*i]+ " ");
                } catch(Exception e) {
                    break;
                }
            }
            System.out.println();
        }
         
    }
     
    public static void boy() {
        int num = sc.nextInt();
        int idx = num-1;
        while(idx < N) {
            if (onOff[idx] == 1) onOff[idx] = 0;
            else onOff[idx] = 1;
            idx += num;
        }
    }
     
    public static void girl() {
        int num = sc.nextInt()-1;
        if (onOff[num] == 1) {
            onOff[num] = 0;
        }
        else {
            onOff[num] = 1;
        }
        int idx1 = num+1;
        int idx2 = num-1;
        while (idx2 >= 0 && idx1 < N) {
            if (onOff[idx1] == onOff[idx2]) {
                if (onOff[idx1] == 1) {
                    onOff[idx1] = 0;
                    onOff[idx2] = 0;
                }
                else {
                    onOff[idx1] = 1;
                    onOff[idx2] = 1;
                }
                idx1 += 1;
                idx2 -= 1;
            }
            else {
                break;
            }
        }
    }
}