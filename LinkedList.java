
public class LinkedList<T> implements List<T> {
	private LinkedListNode<T> head;
	
	@Override
	public T getFirst() {
		return head.getData();
	}

	@Override
	public LinkedListNode<T> getFirstNode() {
		return head;
	}

	@Override
	public T getLast() {
		LinkedListNode<T> temp = head;
		while(temp.next != null) {
			temp = temp.getNext();
		}
		return temp.getData();
		
	}

	@Override
	public void insertFirst(T data) {
		if(head == null) {
			head = new LinkedListNode<T>(data);
		} else {
			LinkedListNode<T> temp = head;
			head = new LinkedListNode<T>(data);
			head.setNext(temp);
		}
	}
	
	@Override
	public void insertAfter(LinkedListNode<T> currentNode, T data) {
		LinkedListNode<T> temp = new LinkedListNode<T>(data);
		temp.setNext(currentNode.getNext());
		currentNode.setNext(temp);
	}
	
	@Override
	public void insertLast(T data) {
		if(head == null) {
			head = new LinkedListNode<T>(data);
		} else {
			LinkedListNode<T> temp = head;
			while(temp.next != null) {
				temp = temp.getNext();
			}
			temp.setNext(new LinkedListNode<T>(data));
		}
		
	}

	@Override
	public void deleteFirst() {
		head = head.getNext();
	}

	@Override
	public void deleteLast() {
		LinkedListNode<T> temp = head;
		while((temp.getNext().getNext()) != null) {
			temp = temp.getNext();
		}
		temp = temp.getNext();
		temp.setNext(null);
		
	}

	@Override
	public void deleteNext(LinkedListNode<T> currentNode) {
		LinkedListNode<T> temp = currentNode.getNext();
		currentNode.setNext(temp.getNext());
	}

	@Override
	public int size() {
		int size = 0;
		LinkedListNode<T> temp = head;
		while(temp != null) {
			size++;
			temp = temp.getNext();
		}
		return size;
	}

	@Override
	public boolean isEmpty() {
		if (head == null) {
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public String toString() {
		String result = "";
		LinkedListNode<T> temp = head;
		while(temp.getNext() != null) {
			result += temp.getData();
			if(temp.getNext() != null) {
				result += " -> ";
			}
			temp = temp.getNext();
		}
		if(temp.getNext() == null) {
			result += temp.getData();
		}
		return result;
	}
}
