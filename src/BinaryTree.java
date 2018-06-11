import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree<E extends Comparable<? super E>> {
	TreeNode<E> root;
	
	public BinaryTree()
	{
		this.root=null;
	}
	
	public BinaryTree(E val)
	{
		this.root=new TreeNode<E>(val,null);
	}
	
	public boolean insert(E val)
	{
		TreeNode<E> curr = root;
		int comp = val.compareTo(curr.getData());		
		
		while((comp<0 && curr.getLeftChild()!=null) ||
				(comp>0 && curr.getRightchild()!=null)) 
		{			
			if(comp < 0)
				curr = curr.getLeftChild();
			else if(comp > 0)
				curr = curr.getRightchild();
			
			comp = val.compareTo(curr.getData());	
		}
		
		if(comp<0)
			curr.addLeft(val);
		else if(comp>0)
			curr.addRight(val);
		else
			return false;
		
		return true;
			
	}
	
	private void preOrder(TreeNode<E> node)
	{
		if(node!=null)
		{
			node.visit();
			preOrder(node.getLeftChild());
			preOrder(node.getRightchild());
		}
	}
	
	public void preOrder()
	{
		preOrder(root);
	}
	
	public void levelOrder(){
		Queue<TreeNode<E>> q = new LinkedList<TreeNode<E>>();
		q.add(root);
		while(!q.isEmpty())
		{
			TreeNode<E> curr = q.remove();
			if(curr!=null)
			{
				curr.visit();
				q.add(curr.getLeftChild());
				q.add(curr.getRightchild());
			}
		}
	}
	
	public boolean contains(E find)
	{
		boolean found=false;
		TreeNode<E> curr = root;
		int comp;
		
		
		while(curr!=null) {
			comp = find.compareTo(curr.getData());
			
			if(comp < 0)
				curr = curr.getLeftChild();
			else if(comp > 0)
				curr = curr.getRightchild();
			else 
				return true;
		}
		
		return found;
	}
	
	public static void main(String args[])
	{
		BinaryTree<Integer> btree = new BinaryTree<Integer>(20);		
		btree.insert(10);
		btree.insert(5);
		btree.insert(15);
		btree.insert(12);
		btree.insert(30);
		btree.insert(25);
		
		//btree.preOrder();
		
		System.out.println(btree.contains(15));
		
	}
}
