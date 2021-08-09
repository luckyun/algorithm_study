package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 241. Different Ways to Add Parentheses
 * https://leetcode.com/problems/different-ways-to-add-parentheses/
 */
public class DifferentWaysToAddParentheses {

    public static void main(String[] args) {
        DifferentWaysToAddParentheses dwap = new DifferentWaysToAddParentheses();

        System.out.println(new ArrayList<Integer>(Arrays.asList(0,2)).containsAll(dwap.diffWaysToCompute("2-1-1")));
        System.out.println(new ArrayList<Integer>(Arrays.asList(-34,-14,-10,-10,10)).containsAll(dwap.diffWaysToCompute("2*3-4*5")));
    }

    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> result = new ArrayList<>();
        // 모든 인수들은 분해하여 list에 넣는다.
        // 연산자 기반으로 모든경우로 분해 후 모든수를 반복해서 연산한다.
        for (int i = 0; i < expression.length(); i++) {
            char cho = expression.charAt(i);
            if(cho== '+' || cho == '-' || cho == '*'){
                String left = expression.substring(0, i);
                String right = expression.substring(i + 1);

                List<Integer> part1 = diffWaysToCompute(left);
                List<Integer> part2 = diffWaysToCompute(right);

                for (Integer num1 : part1) {
                    for (Integer num2 : part2) {
                        if(cho == '+'){
                            result.add(num1 + num2);
                        } else if(cho == '-'){
                            result.add(num1 - num2);
                        } else if(cho == '*'){
                            result.add(num1 * num2);
                        }
                    }

                }


            }
        }
        if(result.size() == 0){
            result.add(Integer.valueOf(expression));
        }
        return result;

    }
}
