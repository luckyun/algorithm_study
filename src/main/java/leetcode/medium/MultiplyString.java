package leetcode.medium;

import sun.security.util.ArrayUtil;

import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 43. Multiply Strings
 * https://leetcode.com/problems/multiply-strings/
 */
public class MultiplyString {

    public static void main(String[] args) {
        MultiplyString multiplyString = new MultiplyString();
        String num1 = "2";
        String num2 = "3";
        System.out.println(multiplyString.multiply(num1, num2).equals("6"));
        String num3 = "123";
        String num4 = "456";
        System.out.println(multiplyString.multiply(num3, num4).equals("56088"));

    }

    public String multiply(String num1, String num2) {

        int[] inp1 =  num1.chars().map(i->i-'0').toArray();
        int[] inp2 = num2.chars().map(i->i-'0').toArray();

        //최대길이는 inp1길이 + inp2길이
        int [] ans = new int[num1.length()+num2.length()];

        for (int i = inp1.length-1; i > -1; i--) {
            int carryNum = 0;
            for (int j = inp2.length-1; j > -1; j--) {
                int tempNum = ((inp1[i] * inp2[j]) + ans[i+j+1] + carryNum);
                int setNum = tempNum % 10  ;
                ans[i+j+1] = setNum;
                carryNum = tempNum / 10  ;
            }
            //다음 자리수에 반영
            ans[i]  = ans[i]  + carryNum;


        }
        StringBuilder sb = new StringBuilder();
        for (int number : ans) {
            //처음 0일때만 예외
            if(!(sb.length() == 0 && number == 0)){
                sb.append(number);
            }
        }


        return sb.length()==0?"0":sb.toString();

    }
}
