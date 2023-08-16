package leetcode.easy;

import sun.security.util.ArrayUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 67. Add Binary
 * https://leetcode.com/problems/add-binary/
 */
public class AddBinary {


    public static void main(String[] args) {
        AddBinary addBinary = new AddBinary();
        String a = "11";
        String b = "1";
        System.out.println(addBinary.addBinary(a,b));
        a = "1010";
        b = "1011";
        System.out.println(addBinary.addBinary(a,b));
    }
    public String addBinary(String a, String b) {
        StringBuffer result = new StringBuffer();
        int binASize = a.length() - 1;
        int binBSize = b.length() - 1;
        int carry = 0;
        while( binASize>=0 || binBSize>=0 || carry > 0){
            int tempA = 0;
            int tempB = 0;
            if(binASize >= 0){
                tempA = a.charAt(binASize) - '0';
                binASize--;
            }
            if(binBSize >= 0){
                tempB = b.charAt(binBSize) - '0';
                binBSize--;
            }
            result.insert(0, (tempA + tempB + carry) % 2);
            carry = (tempA + tempB + carry) / 2;
        }
        return result.toString();
    }


}
