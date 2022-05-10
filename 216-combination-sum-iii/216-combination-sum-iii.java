class Solution {
    List<List<Integer>> res;

    public int sum(List<Integer> list) {
        int total = 0;
        for (int i = 0; i < list.size(); i++) {
            total += list.get(i);
        }
        return total;
    }

    public void combinationSum3(int k, int n, List<Integer> list) {
        if (list.size() == k) {
            if (sum(list) == n) {
                this.res.add(new LinkedList<>(list));
            }
            return;
        }

        for (int i = list.get(list.size() - 1) + 1; i < 10; i++) {
            list.add(i);
            combinationSum3(k, n, list);
            list.remove(list.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        res = new LinkedList<>();
        List<Integer> list = new LinkedList<>();
        for (int i = 1; i < 10; i++) {
            list.add(i);
            combinationSum3(k, n, list);
            list.remove(list.size() - 1);
        }
        return res;
    }
}
