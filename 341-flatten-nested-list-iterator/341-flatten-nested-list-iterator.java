/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    LinkedList<NestedInteger> stack;
    
    public NestedIterator(List<NestedInteger> nestedList) {
        this.stack = new LinkedList<>();
        processList(nestedList);
    }
    
    public void processList(List<NestedInteger> nestedList) {
        for (int i = nestedList.size() - 1; i >= 0; i--) {
            this.stack.add(nestedList.get(i));
        }
    }

    @Override
    public Integer next() {
        // while (stack.size() > 0 && !this.stack.getLast().isInteger()) {
        //     processList(this.stack.removeLast().getList());
        // }
        return this.stack.removeLast().getInteger();
    }

    @Override
    public boolean hasNext() {
        while (stack.size() > 0 && !this.stack.getLast().isInteger()) {
            processList(this.stack.removeLast().getList());
        }
        return this.stack.size() != 0;
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */