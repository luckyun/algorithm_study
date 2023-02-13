package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 1431. Kids With the Greatest Number of Candies
 * https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/
 */
public class KidsWithTheGreatestNumberOfCandies {
    public static void main(String[] args) {
        KidsWithTheGreatestNumberOfCandies ans = new KidsWithTheGreatestNumberOfCandies();
        int [] candies;
        int extraCandies = 0;
        candies = new int[]{2,3,5,1,3};
        extraCandies = 3;
        //[true,true,true,false,true]
        System.out.println(ans.kidsWithCandies(candies, extraCandies));

        candies = new int[]{4,2,1,1,2};
        extraCandies = 1;
        //[true,false,false,false,false]
        System.out.println(ans.kidsWithCandies(candies, extraCandies));


        candies = new int[]{12,1,12};
        extraCandies = 10;
        //[true,false,false,false,false]
        System.out.println(ans.kidsWithCandies(candies, extraCandies));
    }
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> ans = new ArrayList<>();
        int maxCandies = 0;

        for (int i = 0; i < candies.length; i++) {
            if(maxCandies < candies[i]){
                maxCandies = candies[i];
            }
        }
        for (int i = 0; i < candies.length; i++) {
            if(maxCandies > candies[i]+extraCandies){
                ans.add(false);
            } else {
                ans.add(true);
            }

        }

        return ans;
    }

}
