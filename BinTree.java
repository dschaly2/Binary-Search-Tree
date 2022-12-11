
public interface BinTree<T> {
	public BinTreeNode<T> getRoot();
	public void setRoot(BinTreeNode<T> root);
	public boolean isEmpty();
	public LinkedList<T> inorderTraversal();
	public LinkedList<T> preorderTraversal();
	public LinkedList<T> postorderTraversal();
	public String inorderString();
	public String preorderString();
	public String postorderString();
}
