class Solution {
    private class Node {
        char ch;
        int freq;
        Node(char ch, int freq) {
            this.ch = ch;
            this.freq = freq;
        }
    }
    
    public String removeDuplicates(String s, int k) {
        LinkedList<Node> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (stack.size() == 0 || stack.getLast().ch != ch) {
                stack.add(new Node(ch, 1));
            } else {
                int freq = stack.getLast().freq;
                stack.add(new Node(ch, freq + 1));
                
                if (freq == k - 1) {
                    for (int j = 0; j < k; j++) {
                        stack.removeLast();
                    }
                }
            }
        }
        
        StringBuilder res = new StringBuilder();
        while (stack.size() > 0) {
            res.append(stack.removeFirst().ch);
        }
        return res.toString();
    }
}