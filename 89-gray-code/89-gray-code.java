class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> ansList = new LinkedList<>();
        ansList.add(0);
        for (int i = 0; i < n; i++) {
            int size = ansList.size();
            for (int j = size-1; j >= 0; j--) {
                ansList.add(ansList.get(j) | 1 << i);
            }
        }
        return ansList;
    }
}