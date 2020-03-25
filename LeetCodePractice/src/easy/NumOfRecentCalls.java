package easy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 933. Number of Recent Calls
 * 
 * https://leetcode.com/problems/number-of-recent-calls/
 * 
 * Approach: Queue 
 * 
 * Intuition:
 * 
 * We only care about the most recent calls in the last 3000 ms, so let's use a
 * data structure that keeps only those.
 * 
 * Algorithm:
 * 
 * Keep a queue of the most recent calls in increasing order of t. When we see a
 * new call with time t, remove all calls that occurred before t - 3000.
 * 
 * @author srimeda
 *
 */
public class NumOfRecentCalls {
	Queue<Integer> q;
	
	public NumOfRecentCalls() {
		q = new LinkedList<Integer>();
	}
	
	public int ping(int t) {
		q.add(t);
		
		while(q.peek() < t - 3000) {
			q.poll();
		}
		
		return q.size();
	}
	
	public static void main(String[] args) {
		NumOfRecentCalls nc = new NumOfRecentCalls();
		
		System.out.println(nc.ping(1));
		System.out.println(nc.ping(100));
		System.out.println(nc.ping(3001));
		System.out.println(nc.ping(3002));
	}
}
