public class DefaultBinSearchTree<T extends Comparable<T>> implements BinSearchTree<T> {
	private BinTreeNode<T> root;
	
	public DefaultBinSearchTree() {
		this.root = null;
	}
	
	public BinTreeNode<T> getRoot() {
		return root;
	}
	
	public void setRoot(BinTreeNode<T> root) {
		this.root = root;
	}
	
	@Override
	public void insert(T data) {
		this.setRoot(insert(this.getRoot(), data));
	}
	
	
	public BinTreeNode<T> insert(BinTreeNode<T> root, T data) {
		if (root == null) {												//once a null space is found we can insert new node
			this.setRoot(new DefBinaryTreeNode<T>(data));
			return this.getRoot();
		}
		
		if (data.compareTo(root.getData()) < 0) {           			//if data is less than root insert on left sub tree
			root.setLeftChild(insert(root.getLeftChild(), data));
		} else if (data.compareTo(root.getData()) > 0) {				//if data is more than root insert on right sub tree
			root.setRightChild(insert(root.getRightChild(), data));
		}
		return root;  
	}
	

	@Override
	public BinTreeNode<T> search(T data) {
		return search(this.getRoot(), data);
	}
	
	public BinTreeNode<T> search(BinTreeNode<T> root, T data) {
		if (root == null || root.getData() == data) {
			return root;
		}
		if (data.compareTo(root.getData()) > 0) {
			return search(root.getRightChild(), data);
		}
		
		return search(root.getLeftChild(), data);
	}
	

	@Override
	public T minElement() {
		BinTreeNode<T> current = this.getRoot();
		
		while (current.getLeftChild() != null) {
			current = current.getLeftChild();
		}
		return current.getData();
		
	}

	@Override
	public T maxElement() {
		BinTreeNode<T> current = this.getRoot();
		
		while (current.getRightChild() != null) {
			current = current.getRightChild();
		}
		return current.getData();
	}
	
	public BinTreeNode<T> maxNode(BinTreeNode<T> root) {  //function to return max Node not just value
        while (root.getRightChild() != null) {
            root = root.getRightChild();
        }
 
        return root;
    }
	
	public BinTreeNode<T> minNode(BinTreeNode<T> root) {  //function to return min Node not just value
        while (root.getLeftChild() != null) {
            root = root.getLeftChild();
        }
 
        return root;
    }


	public T getPredecessor(BinTreeNode<T> root, BinTreeNode<T> pre, T data){
		if (root == null) {
			return pre.getData();
		}
		
		if (root.getData() == data) {
			if (root.getLeftChild() != null) {
				return maxNode(root.getLeftChild()).getData();		//predecessor returns max node from left subtree
			}
		} else if (data.compareTo(root.getData()) < 0) {
			return getPredecessor(root.getLeftChild(), pre, data);
		} else {
			pre = root;
			return getPredecessor(root.getRightChild(), pre, data);
		}
		return pre.getData();
	}
	
	public T getSuccessor(BinTreeNode<T> root, BinTreeNode<T> suc, T data){
		if (root == null) {
			return suc.getData();
		}
		
		if (root.getData() == data) {
			if (root.getRightChild() != null) {
				return minNode(root.getRightChild()).getData();      //successor returns min node from right subtree
			}
		} else if (data.compareTo(root.getData()) > 0) {
			return getSuccessor(root.getRightChild(), suc, data);
		} else {
			suc = root;
			return getSuccessor(root.getLeftChild(), suc, data);
		}
		return suc.getData();
	}
	
	public BinTreeNode<T> deleteNode(BinTreeNode<T> root, T data) {
		if (root == null) {
			return root;
		}
		if (data.compareTo(root.getData()) > 0) {
			root.setRightChild(deleteNode(root.getRightChild(), data));
		} else if (data.compareTo(root.getData()) < 0) {
			root.setLeftChild(deleteNode(root.getLeftChild(), data));
		} else {  																	//found node to delete
			if (root.getLeftChild() == null && root.getRightChild() == null) {      //node is a leaf
				root = null;
			} else if (root.getRightChild() != null) {                              //has right child
				root.setData(this.getSuccessor(root, null, root.getData()));
				root.setRightChild(deleteNode(root.getRightChild(), root.getData()));
			} else {																//has left child
				root.setData(this.getPredecessor(root, null, root.getData()));
				root.setLeftChild(deleteNode(root.getLeftChild(), root.getData()));
			}
		}
		return root;
	}

	@Override
	public boolean isEmpty() {
		if (this.root == null) {
			return true;
		} else {
		return false;
		}
	}

	@Override
	public LinkedList<T> inorderTraversal() {
		inorderTraversal(this.getRoot());
		return inorder;
	}
	
	LinkedList<T> inorder = new LinkedList<T>();
	public LinkedList<T> inorderTraversal(BinTreeNode<T> node){
		if (node == null) {
			return null;
		}
		inorderTraversal(node.getLeftChild());
		inorder.insertLast(node.getData());
		inorderTraversal(node.getRightChild());
		
		return inorder;
	}

	@Override
	public LinkedList<T> preorderTraversal() {
		preorderTraversal(this.getRoot());
		return preorder;
	}
	
	LinkedList<T> preorder = new LinkedList<T>();
	public LinkedList<T> preorderTraversal(BinTreeNode<T> node){
		if (node == null) {
			return null;
		}
		preorder.insertLast(node.getData());
		preorderTraversal(node.getLeftChild());
		preorderTraversal(node.getRightChild());
		
		return preorder;
	}

	@Override
	public LinkedList<T> postorderTraversal() {
		postorderTraversal(this.getRoot());
		return postorder;
	}
	
	LinkedList<T> postorder = new LinkedList<T>();
	public LinkedList<T> postorderTraversal(BinTreeNode<T> node){
		if (node == null) {
			return null;
		}
		postorderTraversal(node.getLeftChild());
		postorderTraversal(node.getRightChild());
		postorder.insertLast(node.getData());
		
		return postorder;
	}

	@Override
	public String inorderString() {
		return this.inorderTraversal().toString();
	}
	

	@Override
	public String preorderString() {
		return this.preorderTraversal().toString();
	}
	

	@Override
	public String postorderString() {
		return postorderTraversal().toString();
	}
	
}


