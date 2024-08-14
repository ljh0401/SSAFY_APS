package SWEA_1232_사칙연산;

import java.util.Scanner;
import java.util.List;
import java.util.LinkedList;
 
class Solution
{
    static int N;
    static List<String[]> words;
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=10;
        for(int test_case = 1; test_case <= T; test_case++)
        {
            N = sc.nextInt();
            words = new LinkedList<>();
            String[] nullS = {};
            words.add(nullS);
            for (int i = 1; i < N+1; i++) {
                sc.nextInt();
                String word = sc.next();
                if (word.equals("-") || word.equals("*") || word.equals("+") || word.equals("/")) {
                    String L= sc.next();
                    String R = sc.next();
                    String[] cal = {L, word ,R};
                    words.add(cal);
                }
                else {
                    String[] cal = {null, word ,null};
                    words.add(cal);
                }
            }
            int count = 1;
            int ans = (int) postOrder(count);
            System.out.println("#"+test_case+" "+ans);
        }
    }
     
    public static double postOrder(int count) {
        String word = words.get(count)[1];
        if (word.equals("-")) {
            double num1 = postOrder(Integer.parseInt(words.get(count)[0]));
            double num2 = postOrder(Integer.parseInt(words.get(count)[2]));
            return num1 - num2;
        }
        else if (word.equals("+")) {
            double num1 = postOrder(Integer.parseInt(words.get(count)[0]));
            double num2 = postOrder(Integer.parseInt(words.get(count)[2]));
            return num1 + num2;
        }
        else if (word.equals("*")) {
            double num1 = postOrder(Integer.parseInt(words.get(count)[0]));
            double num2 = postOrder(Integer.parseInt(words.get(count)[2]));
            return num1 * num2;
        }
        else if (word.equals("/")) {
            double num1 = postOrder(Integer.parseInt(words.get(count)[0]));
            double num2 = postOrder(Integer.parseInt(words.get(count)[2]));
            return num1 / num2;
        }
        return (double) Integer.parseInt(word);
    }
}