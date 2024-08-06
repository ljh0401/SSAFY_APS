package SWEA_1224_계산기3;

import java.util.Scanner;
import java.util.Stack;
 

// 계산기 3은 stack 한 번 사용해보고 싶어서 util.Stack으로 구현 해봤습니다.
class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
         
        // 10번의 test_case가 주어지므로 T = 10 입력
        int T;
        T=10;
        for(int test_case = 1; test_case <= T; test_case++)
        {
            int  N = sc.nextInt();
             
            // 식 입력 받기
            String words = sc.next();
             
            // postfix 저장할 String 생성
            String postfix = "";
             
            // 임시 저장할 stack 생성
            Stack<Character> save  = new Stack<>();
             
            // 모든 식을 살펴보면서
            for (int i = 0; i < N; i++) {
                char word = words.charAt(i);
                
                // 숫자가 나올 경우 바로 postfix에 저장
                if ('0' <= word && word <= '9') {
                    postfix += word; 
                } 
                     
                // ( 가 나올 경우 일단 저장
                else if (word == '(') {
                    save.push(word);
                } 
                     
                // ) 가 나올 경우 (가 나올 때까지 pop, 그 직전까지 나온 pop들은 postfix에 저장
                else if (word == ')') {
                    char popItem = save.pop();
                    while(popItem != '(') {
                        postfix += popItem;
                        popItem = save.pop();
                    }
                } 
                 
                // + 나 *의 경우
                else {
                    // * 이면
                    if (word == '*') {
                        // 앞에 * 있으면 다음이 *일 때만 출력
                        while (!save.isEmpty() && save.peek() == '*') {
                            postfix += save.pop();
                        }
                    }
                    // + 이면
                    else {
                        // 다음이 괄호 일 때 멈추고, 그 직전까지는 모두 출력
                        while (!save.isEmpty() && save.peek() != '(') {
                            postfix += save.pop();
                        }
                    }
                    // 현재 값 임시 저장
                    save.push(word);
                }
            }
            
            // 남은 기호들 전부 출력
            while (!save.isEmpty()) {
                postfix += save.pop();
            }
             
            // 계산 위한 또 다른 stack 생성
            Stack<Integer> stack = new Stack<>();
            
            // 후위 표기 식 계산 위한 loop
            for (int i = 0; i < postfix.length(); i++) {
                char word = postfix.charAt(i);
 
                // 만약 숫자면 stack에 int 값으로 추가
                if ('0' <= word && word <= '9') {
                    stack.push(word - '0');
                } 
                
                // 기호면 앞에 저장된 숫자를 통해 계산
                else {
                    int num2 = stack.pop();
                    int num1 = stack.pop();
                    int result;
                    if (word == '+') {
                        result = num1 + num2;
                    } else {
                        result = num1 * num2;
                    } 
                    stack.push(result);
                }
            }
             
            // 다 더해진 값 ans로 입력
            int ans =  stack.pop();
             
            // 정답 출력
            System.out.println("#"+test_case+" "+ans);
        }
    }
}