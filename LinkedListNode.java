
public class LinkedListNode<T> extends LinkedList<T> {
	public T data;
	public LinkedListNode<T> next;
	
	public LinkedListNode(T x){
		this.data = x;
		this.next = null;
	}
	
	public T getData(){
		return data;
	}
	
	public LinkedListNode<T> getNext() {
		return next;
	}
	
	public void setData(T data) {
		this.data = data;
	}
	
	public void setNext(LinkedListNode<T> next) {
		this.next = next;
	}
}
