class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        for (int i = triangle.size() - 1; i > 0; i--) {
            List<Integer> currList = triangle.get(i);
            for (int j = 0; j < currList.size() - 1; j++) {
                int numToBeAdded = Math.min(currList.get(j), currList.get(j + 1));
                triangle.get(i - 1).set(j, triangle.get(i-1).get(j) + numToBeAdded);
            }
        }
        return triangle.get(0).get(0);
    }
}