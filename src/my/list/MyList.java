package my.list;

import java.util.ArrayList;

public class MyList<T> {
	private static class Node<T> {
		T object;
		Node<T> next = null;
	}

	private Node<T> head;
	private Node<T> last;
	private Integer size = 0;

	public MyList() {
	}

	public MyList<T> add(T object) {
		Node<T> last = new Node<>();
		last.object = object;
		if (size == 0) {
			this.head = last;
			this.last = last;
			size++;
			return this;
		}
		this.last.next = last;
		this.last = last;

		size++;
		return this;
	}

	public MyList<T> addToHead(T object) {
		Node<T> head = new Node<>();
		head.object = object;
		if (size == 0) {
			this.head = head;
			this.last = head;
			size++;
			return this;
		}
		head.next = this.head;
		this.head = head;
		size++;
		return this;
	}

	public MyList<T> add(int index, T object) {
		if (index == 0) {
			addToHead(object);
		}
		if (index == size) {
			add(object);
		}
		if (index > size) {
			throw new IndexOutOfBoundsException("Index more then size");
		}
		if (index < 0) {
			throw new IndexOutOfBoundsException("Index is negative");
		}

		Node<T> needPos = this.head;
		for (int i = 0; i < index - 1; i++) {
			needPos = needPos.next;
		}
		Node<T> element = new Node<>();
		element.object = object;
		element.next = needPos.next;
		needPos.next = element;
		size++;
		return this;
	}

	public T get(int index) {
		if (index > size - 1) {
			throw new IndexOutOfBoundsException("Index more then size");
		}
		if (index < 0) {
			throw new IndexOutOfBoundsException("Index is negative");
		}
		Node<T> needPos = this.head;
		for (int i = 0; i < index; i++) {
			needPos = needPos.next;
		}
		return needPos.object;
	}

	public MyList<T> revers() {
		if (head == null) {
			throw new IllegalStateException("List is empty");
		}
		revers(head, null);
		return this;
	}

	private void revers(Node<T> head, Node<T> tail) {
		if (head.next != null) {
			Node<T> newHead = head.next;
			head.next = tail;
			revers(newHead, head);
		} else {
			head.next = tail;
			this.head = head;
		}
		this.last = head;

	}

	public int size() {
		return size;
	}

	public String toString() {
		if (size == 0) {
			return "[]";
		}
		StringBuilder sb = new StringBuilder();
		Node<T> head = this.head;
		sb.append("[");
		while (head.next != null) {
			sb.append(head.object);
			sb.append(", ");
			head = head.next;
		}
		sb.append(head.object);
		sb.append("]");
		return sb.toString();

	}
}
