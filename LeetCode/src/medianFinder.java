import java.util.*;

class medianFinder {
	// (1) can use insertion sort to insert the num
	// in stream to its correct position using binary search.
	// o(n)+o(logn)=o(n) o(n): elems should shif to inser the elem
	// (2) we can shift from end while search for the correct pos o(n)
	//
	PriorityQueue<Integer> lo, hi;
	/** initialize your data structure here. */
	public medianFinder() {
		lo = new PriorityQueue<Integer>(Collections.reverseOrder());
		hi = new PriorityQueue<Integer>();
	}

	public void addNum(int num) {
		if(lo.size() == hi.size()) { // add to hi (we keep +1 (odd) in hi)
			if(hi.isEmpty() || num >= hi.peek()) hi.offer(num);
			else {
				lo.offer(num);
				hi.offer(lo.poll());
			}
		} else { // hi size  == lo size+1. make them even len
			if(lo.isEmpty() && num <= hi.peek()) lo.add(num);
			else {
				hi.offer(num);
				lo.add(hi.poll());
			}
		}
	}

	public double findMedian() {
		if((lo.size()+hi.size())%2 == 0)
			return (1.0*lo.peek()+hi.peek())/2;
		return hi.peek();
	}
}

/**
* Your MedianFinder object will be instantiated and called as such:
* MedianFinder obj = new MedianFinder();
* obj.addNum(num);
* double param_2 = obj.findMedian();
*/