import org.junit.Assert;
import org.junit.jupiter.api.Test;

class BinSearchTreeJUnitTest {

	@Test
	void test() {
		
		//Create Binary Search Tree
		DefaultBinSearchTree<Integer> test = new DefaultBinSearchTree<>();
		test.insert(50);
		test.insert(40);
		test.insert(60);
		test.insert(80);
		test.insert(20);
		test.insert(100);
		
		//Confirm Root is 50
		int root = test.getRoot().getData();
		Assert.assertEquals(50, root);
		
		//Confirm Root Left Child is 40 and Right child is 60 to confirm insertion
		int rootLeft = test.getRoot().getLeftChild().getData();
		int rootRight = test.getRoot().getRightChild().getData();
		Assert.assertEquals(40, rootLeft);
		Assert.assertEquals(60, rootRight);
		
		//Confirm Search for 20 returns a node
		int searched = test.search(20).getData();
		Assert.assertEquals(searched, 20);
		
		//Searching for a node that doesn't exist returns null
		Assert.assertNull(test.search(545));
		
		//Min element is 20
		int min = test.minElement();
		Assert.assertEquals(20, min);
		
		//Max element is 100
		int max = test.maxElement();
		Assert.assertEquals(100, max);
		
		
		//Successor of 80 is 100
		int suc = test.getSuccessor(test.getRoot(), null, 80);
		Assert.assertEquals(suc, 100);
		
		
		//Predecessor of 60 is 50
		int pre = test.getPredecessor(test.getRoot(), null, 60);
		Assert.assertEquals(pre, 50);
		
		//After inserting 55, the predecessor of 60 is 55
		test.insert(55);
		pre = test.getPredecessor(test.getRoot(), null, 60);
		Assert.assertEquals(pre, 55);
		
		//Confirms 55 was placed as left child of 60
		int child = test.getRoot().getRightChild().getLeftChild().getData();
		Assert.assertEquals(55, child);
		
		//Testing delete node - deleting 20 will change min value to 40
		test.deleteNode(test.getRoot(), 20);
		min = test.minElement();
		Assert.assertEquals(40, min);
		
		//Deleting 80 means replacing 60's right child with 100
		test.deleteNode(test.getRoot(), 80);
		child = test.getRoot().getRightChild().getRightChild().getData();
		Assert.assertEquals(child, 100);
		
		//Confirm that no nodes are left behind after deletion
		Assert.assertNull(test.getRoot().getRightChild().getRightChild().getRightChild());
		
		//Deleting root node maintains proper balancing
		test.deleteNode(test.getRoot(), test.getRoot().getData());
		root = test.getRoot().getData();
		Assert.assertEquals(root, 55);
		Assert.assertNull(test.getRoot().getRightChild().getLeftChild());
		
		//Test the traversals
		Assert.assertEquals("40 -> 55 -> 60 -> 100", test.inorderString());
		Assert.assertEquals("55 -> 40 -> 60 -> 100", test.preorderString());
		Assert.assertEquals("40 -> 100 -> 60 -> 55", test.postorderString());
		
	}

}
