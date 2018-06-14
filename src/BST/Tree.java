package BST;

import java.util.LinkedList;
import java.util.Queue;

public class Tree<E extends Comparable<? super E>> {
	private TreeNode<E> root;
	private int size;
	
	public Tree()
	{
		this.root=null;
		size=0;
	}
	
	public Tree(E val)
	{
		this.root=new TreeNode<E>(val,null);
		size=1;
	}
	
	public int getSize() {
		return size;
	}
	
	public void setSize(int s) {
		this.size = s;
	}
	
	public void incSize() {
		this.size++;
	}
	
	public void decSize() {
		this.size--;
	}
	
	public TreeNode<E> getRoot()
	{
		return root;
	}
	
	public void setRoot(E val)
	{
		this.root = new TreeNode<E>(val,null);
	}
	
	public void setRoot(TreeNode<E> node)
	{
		this.root = node;
	}
	
	private void preOrder(TreeNode<E> node)
	{
		if(node!=null)
		{
			node.visit();
			preOrder(node.getLeftChild());
			preOrder(node.getRightChild());
		}
	}
	
	public void preOrder()
	{
		preOrder(root);
	}
	
	public void levelOrder()
	{
		Queue<TreeNode<E>> q = new LinkedList<TreeNode<E>>();
		q.add(root);
		while(!q.isEmpty()){
			TreeNode<E> curr = q.remove();
			if(curr!=null){
				curr.visit();
				q.add(curr.getLeftChild());
				q.add(curr.getRightChild());
			}
		}
	}
	
	public boolean contains(E find)
	{
		boolean found=false;
		TreeNode<E> curr = root;
		int comp;
		
		
		while(curr!=null){
			comp = find.compareTo(curr.getData());
			
			if(comp < 0)
				curr = curr.getLeftChild();
			else if(comp > 0)
				curr = curr.getRightChild();
			else 
				return true;
		}
		
		return found;
	}
	
	public TreeNode<E> getNodeDetails(E find)
	{
		boolean found=false;
		TreeNode<E> curr = getRoot();
		int comp;		
		
		while(curr!=null) {
			comp = find.compareTo(curr.getData());
			
			if(comp < 0)
				curr = curr.getLeftChild();
			else if(comp > 0)
				curr = curr.getRightChild();
			else{
				found=true;break;
			}				
		}
		
		if(found==true)
			return curr;
		else
			return null;		
	}
	
	public int height(TreeNode<E> node)
	{
		int height=0;
		if(node==null)
			return height;
		
		height=1+Math.max(height(node.getLeftChild()), height(node.getRightChild()));
		
		return height;
	}
	

	public boolean isBalanced(TreeNode<E> node)
	{
		boolean balanced=false;
		
		if(node==null)
			return true;
		
		int lh = height(node.getLeftChild());
		int rh = height(node.getRightChild());
		int diff = Math.abs(lh-rh);
				
		if(diff<=1 && isBalanced(node.getLeftChild()) && isBalanced(node.getRightChild()))
			balanced=true;
		
		return balanced;
	}
	
}
