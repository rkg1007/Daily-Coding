// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

class PeekingIterator implements Iterator<Integer> {
  Iterator<Integer> iterator;
  int peek;
  
	public PeekingIterator(Iterator<Integer> iterator) {
	  this.iterator = iterator;
	  this.peek = this.iterator.hasNext() ? this.iterator.next() : -1;  
	}
	
  
  public Integer peek() {
    return this.peek;     
	}
	
	
	@Override
	public Integer next() {
	  int peekVal = this.peek;
    this.peek = this.iterator.hasNext() ? this.iterator.next() : -1;
    return peekVal;
	}
	
	
	public boolean hasNext() {
	  return this.peek != -1;
	}
}