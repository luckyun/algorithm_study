package leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 833. Find And Replace in String
 * https://leetcode.com/problems/find-and-replace-in-string/description/
 */
public class FindAndReplaceInString {
    public static void main(String[] args) {
        FindAndReplaceInString ans = new FindAndReplaceInString();
        String s;
        int[] indices;
        String[] sources;
        String[] targets;

        s = "abcd";
        indices = new int[]{0, 2};
        sources = new String[]{"a", "cd"};
        targets = new String[]{"eee", "ffff"};

        System.out.println(ans.findReplaceString(s, indices, sources, targets));
    }

    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        Map<Integer, Integer> idxMap = new HashMap<>();
        StringBuffer rtnVal = new StringBuffer();
        for (int i = 0; i < indices.length; i++) {
            idxMap.put(indices[i], i);
        }

        for (int i = 0; i < s.length(); i++) {
            if(idxMap.containsKey(i)){
                int index = idxMap.get(i);
                String tempStr = s.substring(i, indices[index]+sources[index].length());
                if(tempStr.equals(sources[index])){
                    rtnVal.append(targets[index]);
                    i = i + sources[index].length()-1;
                    continue;
                }
            }
            rtnVal.append(s.charAt(i));
        }
        return rtnVal.toString();
    }
}
