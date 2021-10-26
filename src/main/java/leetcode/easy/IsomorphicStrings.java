package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 205. Isomorphic Strings
 * https://leetcode.com/problems/isomorphic-strings/
 */
public class IsomorphicStrings {
    public static void main(String[] args) {
        IsomorphicStrings isomorphicStrings = new IsomorphicStrings();

        System.out.println(isomorphicStrings.isIsomorphic("egg", "add") == true);
        System.out.println(isomorphicStrings.isIsomorphic("foo", "bar") == false);
        System.out.println(isomorphicStrings.isIsomorphic("paper", "title") == true);
        System.out.println(isomorphicStrings.isIsomorphic("badc", "baba") == false);

    }
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        if(s.length() != t.length()){
            return false;
        }
        if(s.equals(t)){
            return true;
        }

        for (int i = 0; i < s.length(); i++) {
            char mainCh = s.charAt(i);
            char targetCh = t.charAt(i);
            if(map.containsKey(mainCh)){
                if(targetCh != map.get(mainCh)){
                    return false;
                }
            } else {
                if(map.containsValue(targetCh)){
                    return false;
                }
                map.put(mainCh, targetCh);
            }

        }

        return true;
    }
}
