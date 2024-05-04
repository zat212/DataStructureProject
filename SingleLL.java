package test_queue;

import Singly_LL.Node;

public class SingleLL<E> implements Queue<E> {
	private int size = 0;
	private Node<E> head;
    private Node<E> tail;

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return this.size;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return this.size == 0;
	}

	@Override
	public void enqueue(E e) {
		// TODO Auto-generated method stub
		 Node<E> newest = new Node<>();
	        newest.setElmemt(e);
	        if (isEmpty()) {
	            head = newest;
	            tail = newest;
	        } else {
	            tail.setNext(newest);
	            tail = newest;
	        }
	        size++;
		
	}

	@Override
	public E first() {
		// TODO Auto-generated method stub
		if (isEmpty()) {
            return null; // or throw an exception
        }
        return head.getElmemt();
	}

	@Override
	public E dequeue() {
		if (isEmpty()) {
            return null; // or throw an exception
        }
        E data = head.getElmemt();
        head = head.getNext();
        size--;
        return data;
    }
}
