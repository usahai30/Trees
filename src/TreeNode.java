
public class TreeNode<E> {
	
	private E data;
	private TreeNode<E> parent;
	private TreeNode<E> left;
	private TreeNode<E> right;
	
	
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
	
	public TreeNode<E> addRight(E val)
	{
		this.right = new TreeNode<E>(val,this);
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
	}

	public TreeNode<E> getParent() {
		return parent;
	}

	public void setParent(TreeNode<E> parent) {
		this.parent = parent;
	}
	
	public String toString()
	{
		E temp;
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
		
		
		return "Parent: "+parent+"\n"+
				"Left: "+left+"\n"+
				"Right: "+right+"\n";
	}
	
	/*
	public static void main(String args[])
	{
		TreeNode<Integer> node = new TreeNode<Integer>(1);
		node.addLeft(2).addLeft(4);
		node.addRight(3);
		
		TreeNode<Integer> temp = node;
		while(temp.getLeftChild()!=null)
		{
			System.out.println(temp.data);
			temp = temp.getLeftChild();
		}
		System.out.println(temp.data);
	}
	*/
}
