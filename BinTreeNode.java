
public interface BinTreeNode<T> {
	public T getData();
	public BinTreeNode<T> getLeftChild();
	public BinTreeNode<T> getRightChild();
	public void setLeftChild(BinTreeNode<T> left);
	public void setRightChild(BinTreeNode<T> right);
	public void setData(T data);
	public boolean isLeaf();
}
