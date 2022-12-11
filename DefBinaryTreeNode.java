
public class DefBinaryTreeNode<T> implements BinTreeNode<T>{
	private T data;
	private BinTreeNode<T> leftChild;
	private BinTreeNode<T> rightChild;
	
	public DefBinaryTreeNode(T data){
		this.data = data;
	}
	
	@Override
	public T getData() {
		return data;
	}
	
	
	@Override
	public void setData(T data) {
		this.data = data;
	}

	@Override
	public BinTreeNode<T> getLeftChild() {
		return leftChild;
	}

	@Override
	public BinTreeNode<T> getRightChild() {
		return rightChild;
	}

	@Override
	public void setLeftChild(BinTreeNode<T> left) {
		this.leftChild = left;
		
	}

	@Override
	public void setRightChild(BinTreeNode<T> right) {
		this.rightChild = right;
	}

	@Override
	public boolean isLeaf() {
		if (this.rightChild == null && this.leftChild == null) {
			return true;
		} else {
		return false;
		}
	}

}
