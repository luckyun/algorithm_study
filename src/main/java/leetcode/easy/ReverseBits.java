package leetcode.easy;

/**
 * 190. Reverse Bits
 * https://leetcode.com/problems/reverse-bits/
 */

public class ReverseBits {
    public static void main(String[] args) {
        ReverseBits reverseBits = new ReverseBits();
        System.out.println(reverseBits.reverseBits(43261596) == 964176192 );

    }

    public int reverseBits(int n) {

        String binaryNum =  Integer.toBinaryString(n);
        StringBuffer sb = new StringBuffer();

        for (int i = 32- binaryNum.length()-1; i > -1; i--) {
            sb.append(0);
        }

        String convertNum = sb.toString() + binaryNum ;
        int ans = 0;
        for (int i = 0; i < convertNum.length(); i++) {
            if(convertNum.charAt(i) == '1'){
                ans = ans + (1 << i);
            }
        }

        return ans;
    }
}
