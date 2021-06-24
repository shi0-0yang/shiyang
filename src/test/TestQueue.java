package test;

import com.shiyang.Collection.EmptyQueueException;
import com.shiyang.Collection.MyQueue;

public class TestQueue {
	public static  void main(String[] args) {
		MyQueue q=new MyQueue();
		q.enqueue("first!");
		q.enqueue("second!");
		q.enqueue("third!");
		try {
			q.dequeue();
		} catch (EmptyQueueException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
