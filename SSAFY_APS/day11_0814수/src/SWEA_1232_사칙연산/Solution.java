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
        
        // 10번 동안 loop
        int T;
        T=10;
        for(int test_case = 1; test_case <= T; test_case++)
        {
        	
        	// 정점의 개수 N 입력 받기
            N = sc.nextInt();
            
            // 순서대로 LinkedList에 입력
            words = new LinkedList<>();
            
            // 0번째에 null 값인 배열 입력
            String[] nullS = {};
            words.add(nullS);
                  
            for (int i = 1; i < N+1; i++) {
                sc.nextInt();
                String word = sc.next();
                // 만약 해당 정점에 사칙연산이 있다면, 연결된 노드들도 같이 입력
                if (word.equals("-") || word.equals("*") || word.equals("+") || word.equals("/")) {
                    String L= sc.next();
                    String R = sc.next();
                    String[] cal = {L, word ,R};
                    words.add(cal);
                }
                
                // 숫자면 연결된 노드가 없으므로 null로 입력
                else {
                    String[] cal = {null, word ,null};
                    words.add(cal);
                }
            }
            
            // 이를 후위 순서로 결과 출력
            int count = 1;
            int ans = (int) postOrder(count);
            System.out.println("#"+test_case+" "+ans);
        }
    }
    
    // 탐색은 전위, 계산은 후위로 진행
    public static double postOrder(int count) {
       // 만약 현재 기준인 부분이 사칙연산이면 왼쪽, 오른쪽 노드 먼저 탐색 후 계산하여 return
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
        
        // 숫자일 경우 그대로 return
        return (double) Integer.parseInt(word);
    }
}