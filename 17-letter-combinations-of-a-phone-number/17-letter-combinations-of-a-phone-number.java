class Solution {
    List<String> res;
    
    public void findAllLetterCombinations(String digits, int i, StringBuilder s) {
        if (i == digits.length()) {
            if (s.length() > 0) res.add(s.toString());
            return;
        }
         
        String[] arr = new String[]{"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        int digitPos = digits.charAt(i) - '2';
        for (int j = 0; j < arr[digitPos].length(); j++) {
            s.append(arr[digitPos].charAt(j));
            findAllLetterCombinations(digits, i + 1, s);
            s.deleteCharAt(s.length() - 1);
        }
    }
    
    public List<String> letterCombinations(String digits) {
        res = new LinkedList<>();
        findAllLetterCombinations(digits, 0, new StringBuilder());
        return res;
    }
}