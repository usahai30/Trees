package BST;

public class BalancedBinaryTree<E extends Comparable<? super E>> extends Tree<E> {
	
	public int rightShift;
	public int leftShift;
	
	public BalancedBinaryTree()
	{
		super();
		leftShift=0;
		rightShift=0;
	}
	
	public BalancedBinaryTree(E val)
	{
		super(val);
		leftShift=0;
		rightShift=0;
	}
	
	public boolean insert(E val)
	{
		if(this.getRoot()==null) {
			this.setRoot(val);
			this.incSize();
			return true;
		}
		
		TreeNode<E> curr = this.getRoot();
		int comp = val.compareTo(curr.getData());		
		
		while((comp<0 && curr.getLeftChild()!=null) ||
				(comp>0 && curr.getRightChild()!=null)) 
		{			
			if(comp < 0)
				curr = curr.getLeftChild();
			else if(comp > 0)
				curr = curr.getRightChild();
			
			comp = val.compareTo(curr.getData());	
		}
		
		if(comp<0)
		{
			TreeNode<E> temp = curr.addLeft(val);
			this.incSize();
			
			if(!isBalanced(temp.getParent().getParent()))
				rightShift(temp.getParent());			
		}
		else if(comp>0)
		{
			TreeNode<E> temp = curr.addRight(val);
			this.incSize();
			
			if(!isBalanced(temp.getParent().getParent()))
				leftShift(temp.getParent());
		}
		else
			return false;
		
		return true;
			
	}
	
	private void leftShift(TreeNode<E> node) {
		TreeNode<E> parent = node.getParent();
		
		if(parent==this.getRoot())
		{
			node.setParent(null);
			this.setRoot(node); 
		}else {
			parent.getParent().setRight(node);
			node.setParent(parent.getParent());
		}	
		parent.deleteLeft();
		parent.deleteRight();
		node.setLeft(parent);
		
		leftShift++;
	}

	private void rightShift(TreeNode<E> node) {
		TreeNode<E> parent = node.getParent();
		
		if(parent==this.getRoot())
		{
			node.setParent(null);
			this.setRoot(node);
		}else {
			parent.getParent().setLeft(node);
			node.setParent(parent.getParent());
		}
		parent.deleteLeft();
		parent.deleteRight();
		node.setRight(parent);	
		rightShift++;
	}	
	
	public void delete(E val)
	{
		TreeNode<E> curr = this.getRoot();		
		TreeNode<E> prev = curr;
		int comp;		
		
		while(curr!=null){
			comp = val.compareTo(curr.getData());
			
			if(comp < 0){
				prev = curr;
				curr = curr.getLeftChild();
			}else if(comp > 0){
				prev = curr;
				curr = curr.getRightChild();
			}else
				break;
		}
		
		if(curr.getLeftChild()==null){
			if(curr.getRightChild() == null){
				if(prev==curr){
					curr.delete();
				}else{
					comp = curr.getData().compareTo(prev.getData());
				
					if(comp<0)
						prev.deleteLeft();				
					else
						prev.deleteRight();
				}
			}else{
				curr.setData(curr.getRightChild().getData());
				curr.deleteRight();
			}
			
		}else if(curr.getRightChild() == null){
			curr.setData(curr.getLeftChild().getData());
			curr.deleteLeft();
		}else{
			TreeNode<E> smallest = curr.getRightChild();
			
			while(smallest.getLeftChild()!=null){
				smallest=smallest.getLeftChild();
			}
			
			E temp = smallest.getData();
			delete(temp);
			curr.setData(temp);
		}		
	}
	
	public static void main(String args[])
	{
		BalancedBinaryTree<Integer> btree = new BalancedBinaryTree<Integer>();	
		btree.insert(20);
		btree.insert(10);
		btree.insert(30);
		btree.insert(12);
		btree.insert(5);
		btree.insert(35);
		btree.insert(39);
		btree.insert(3);
		btree.insert(1);
		
		btree.levelOrder();
		//System.out.println("\nRoot Node -"+btree.getRoot());
		System.out.println("\nSize - "+btree.getSize()+" | Height - "+btree.height(btree.getRoot()));
		System.out.println("Left Shift - "+btree.leftShift+" | Right Shift - "+btree.rightShift);
		System.out.println("Balanced - "+btree.isBalanced(btree.getRoot()));
		System.out.println("**********************************************");
		
		
	}
}
