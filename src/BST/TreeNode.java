package BST;

public class TreeNode<E> {
	
	private E data;
	private TreeNode<E> parent;
	private TreeNode<E> left;
	private TreeNode<E> right;
	
	public TreeNode()
	{
		this.data = null;
		this.left = null;
		this.right = null;
		this.setParent(null);
	}
	
	public TreeNode(E val, TreeNode<E> node) {
		this.data = val;
		this.setParent(node);
		this.left = null;
		this.right = null;
	}
	
	public TreeNode<E> addLeft(E val)
	{
		this.left = new TreeNode<E>(val,this);
		return this.left;
	}
	
	public TreeNode<E> setLeft(TreeNode<E> node)
	{
		this.left = node;
		return this.left;
	}
	
	public TreeNode<E> addRight(E val)
	{
		this.right = new TreeNode<E>(val,this);
		return this.right;
	}
	
	public TreeNode<E> setRight(TreeNode<E> node)
	{
		this.right = node;
		return this.right;
	}

	public void deleteLeft()
	{
		this.left = null;
	}
	
	public void deleteRight()
	{
		this.right = null;
	}
	
	public void visit() {
		System.out.print(this.data+" ");
	}

	public TreeNode<E> getLeftChild() {
		return this.left;
	}

	public TreeNode<E> getRightChild() {
		return this.right;
	}
	
	public void setData(E val)
	{
		this.data = val;
	}
	
	public E getData()
	{
		return this.data;
	}

	public void delete() {
		this.data = null;
		this.parent = null;
		this.left = null;
		this.right = null;
	}

	public TreeNode<E> getParent() {
		return parent;
	}
	
	public void setParent(TreeNode<E> parent) {
		this.parent = parent;
	}
	
	public String toString()
	{
		String parent,left,right;
		
		if(this.getParent()==null)
			parent = "";
		else
			parent = this.getParent().getData().toString();
		
		if(this.getLeftChild()==null)
			left = "";
		else
			left = this.getLeftChild().getData().toString();
			
		if(this.getRightChild()==null)
			right = "";
		else
			right = this.getRightChild().getData().toString();
		
		
		return "Data: "+this.data+"\n"+
				"Parent: "+parent+"\n"+
				"Left: "+left+"\n"+
				"Right: "+right+"\n";
	}
}
