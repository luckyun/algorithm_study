package leetcode.easy;

/**
 * 383. Ransom Note
 * https://leetcode.com/problems/ransom-note/submissions/
 */
public class RansomNote {
    public static void main(String[] args) {
        RansomNote ransomNote = new RansomNote();
        System.out.println(ransomNote.canConstruct("a","b") == false);
        System.out.println(ransomNote.canConstruct("aa","ab") == false);
        System.out.println(ransomNote.canConstruct("aa","aab") == true);
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        int[] mArray = new int[26];
        boolean result = true;

        for (int i = 0; i < magazine.length(); i++) {
            int cIdx = magazine.charAt(i) - 'a';
            mArray[cIdx]++;
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            int cIdx = ransomNote.charAt(i) - 'a';
            mArray[cIdx]--;
            if(mArray[cIdx] < 0){
                result = false;
                break;
            }
        }
        return result;
    }
}
