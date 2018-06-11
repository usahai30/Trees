
public class TreeNode<E> {
	
	private E data;
	private TreeNode<E> parent;
	private TreeNode<E> left;
	private TreeNode<E> right;
	
	public TreeNode(E val, TreeNode<E> node) {
		this.data = val;
		this.parent = node;
		this.left = null;
		this.right = null;
	}
	
	public TreeNode<E> addLeft(E val)
	{
		this.left = new TreeNode<E>(val,this);
		return this.left;
	}
	
	public TreeNode<E> addRight(E val)
	{
		this.right = new TreeNode<E>(val,this);
		return this.right;
	}

	public void visit() {
		// TODO Auto-generated method stub
		
	}

	public TreeNode<E> getLeftChild() {
		// TODO Auto-generated method stub
		return null;
	}

	public TreeNode<E> getRightchild() {
		// TODO Auto-generated method stub
		return null;
	}
}
