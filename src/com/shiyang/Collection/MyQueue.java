package com.shiyang.Collection;

public class MyQueue {
	public class Node {
		Object m_Data;
		Node m_Next;

		public Node(Object data) {
			m_Data = data;
			m_Next = null;
		}

		public Node(Object data, Node next) {
			m_Data = data;
			m_Next = next;
		}

		public Node getNext() {
			return m_Next;
		}

		public void setNext(Node next) {
			m_Next = next;
		}

		public Object getObject() {
			return m_Data;
		}

		public void setObject(Object data) {
			m_Data = data;
		}
	}

	Node m_FirstNode;

	public boolean isEmpty() {
		if (m_FirstNode == null) {
			return true;
		} else
			return false;
	}

	public void enqueue(Object newNode) { // 入队
		Node next = m_FirstNode;
		if (next == null) {
			m_FirstNode = new Node(newNode);
		} else {
			while (next.getNext() != null) {
				next = next.getNext();
				next.setNext(new Node(newNode));
			}
		}
	}

	public Object dequeue() throws EmptyQueueException {
		Object node;
		if (isEmpty()) {
			throw (new EmptyQueueException());
		} else {
			node = m_FirstNode.getObject();
			m_FirstNode = m_FirstNode.getNext();
			return node;
		}
	}
}
