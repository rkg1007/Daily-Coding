// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

class PeekingIterator implements Iterator<Integer> {
  Iterator<Integer> iterator;
  int peek;
  
	public PeekingIterator(Iterator<Integer> iterator) {
    this.iterator = iterator;
    this.peek = this.iterator.hasNext() ? this.iterator.next() : -1;
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
    return this.peek;
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	  int peekVal = this.peek;
    this.peek = this.iterator.hasNext() ? this.iterator.next() : -1;
    return peekVal;
	}
	
	@Override
	public boolean hasNext() {
	    return this.peek != -1;
	}
}