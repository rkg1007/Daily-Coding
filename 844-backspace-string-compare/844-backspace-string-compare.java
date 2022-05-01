class Solution {
    public boolean backspaceCompare(String s, String t) {
        char[] sStack = new char[s.length()];
        int pt1 = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '#') pt1 = Math.max(0, pt1 - 1);
            else {
                sStack[pt1] = ch;
                pt1++;
            }
        }
        
        char[] tStack = new char[t.length()];
        int pt2 = 0;
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            if (ch == '#') pt2 = Math.max(0, pt2 - 1);
            else {
                tStack[pt2] = ch;
                pt2++;
            }
        }
        
        boolean ans = true;
        if (pt1 != pt2) ans = false;
        else {
            for (int i = 0; i < pt1; i++) {
                if (sStack[i] != tStack[i]) {
                    ans = false;
                    break;
                }
            }
        }
        
        return ans;
    }
}