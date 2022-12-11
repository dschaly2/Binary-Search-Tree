
public interface BinSearchTree<T> extends BinTree<T> {
	public void insert(T data);
	public BinTreeNode<T> search(T data);
	public T minElement();
	public T maxElement();
}
