package programmers.level2;

import java.util.Stack;

/**
 * 짝지어 제거하기
 * https://programmers.co.kr/learn/courses/30/lessons/12973?language=java
 */
public class MatchAndRemove {
    public static void main(String[] args) {
        MatchAndRemove matchAndRemove = new MatchAndRemove();
        System.out.println(matchAndRemove.solution("baabaa") == 1);
        System.out.println(matchAndRemove.solution("cdcd") == 0);
    }
    public int solution(String s)
    {


        Stack<Character> stack = new Stack<>();

        // 일치하지 않으면 push, 일치하면 pop
        for (char ch : s.toCharArray()) {
            if(!stack.isEmpty() &&  stack.peek() == ch){
                stack.pop();
            } else {
                stack.push(ch);
            }
        }

        return stack.isEmpty()? 1:0;
    }
}
