package leetcode.medium;

import java.util.Arrays;

/**
 * Jump Game II
 * https://leetcode.com/problems/jump-game-ii/submissions/
 */
public class JumpGame2 {
    public static void main(String[] args) {
        JumpGame2 jg = new JumpGame2();
        System.out.println(jg.jump(new int[]{2,3,1,1,4}) == 2);
        System.out.println(jg.jump(new int[]{3,4,3,2,5,4,3}) == 3);



    }
    public int jump(int[] nums) {
        int[] result = new int[nums.length];
        Arrays.fill(result, Integer.MAX_VALUE);
        result[0] = 0;

        for (int i = 0; i < nums.length; i++) {
            int step = result[i];
            for (int j = i+1; j < nums.length && j <= i+nums[i]; j++) {

                    result[j] = Math.min(step+1,result[j] );



            }

        }


        return result[result.length-1];
    }



}
