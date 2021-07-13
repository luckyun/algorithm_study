package leetcode.easy;

import java.util.Arrays;

/**
 *  Reverse String
 *  https://leetcode.com/problems/reverse-string/
 */
public class ReverseString {
    public static void main(String[] args) {

        char[] s1 = {'h', 'e','l','l','o'};
        char[] a1 = {'o', 'l','l','e','h'};
        char[] s2 = {'H','a','n','n','a','h'};
        char[] a2 = {'h','a','n','n','a','H'};
        ReverseString reverseString = new ReverseString();


        reverseString.reverseString(s1);
        reverseString.reverseString(s2);
        System.out.println(Arrays.equals(s1,a1));
        System.out.println(Arrays.equals(s2,a2));



    }


    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length-1;
        while (left<right){
            char tempCh = s[left];
            s[left] = s[right];
            s[right] = tempCh;
            left++;
            right--;
        }
    }
}
