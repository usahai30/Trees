package BST;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree<E extends Comparable<? super E>> {
	private TreeNode<E> root;
	private int size;
	
	public int getSize() {
		return size;
	}

	public BinaryTree()
	{
		this.root=null;
		size=0;
	}
	
	public BinaryTree(E val)
	{
		this.root=new TreeNode<E>(val,null);
		size=1;
	}
	
	public TreeNode<E> getRoot()
	{
		return root;
	}
	
	public boolean balancedInsert(E val)
	{
		TreeNode<E> curr = root;
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
			size++;
			
			if(!isBalanced(temp.getParent().getParent()))
				rightShift(temp.getParent());			
		}
		else if(comp>0)
		{
			TreeNode<E> temp = curr.addRight(val);
			size++;
			
			if(!isBalanced(temp.getParent().getParent()))
				leftShift(temp.getParent());
		}
		else
			return false;
		
		return true;
			
	}
	
	public boolean insert(E val)
	{
		TreeNode<E> curr = root;
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
			curr.addLeft(val);
			size++;
		}
		else if(comp>0)
		{
			curr.addRight(val);
			size++;
		}
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
	
	public void delete(E val)
	{
		TreeNode<E> curr = root;		
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
	
	public TreeNode<E> getNodeDetails(E find)
	{
		boolean found=false;
		TreeNode<E> curr = root;
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
	
	public static void main(String args[])
	{
		BinaryTree<Integer> btree = new BinaryTree<Integer>(20);		
		btree.insert(10);
		btree.insert(5);
		btree.insert(15);
		btree.insert(12);
		btree.insert(30);
		btree.insert(25);
		btree.insert(35);
		btree.insert(7);
		btree.insert(23);
		
		btree.preOrder();
		System.out.println();
		System.out.println("Size - "+btree.getSize());
		System.out.println("Height - "+btree.height(btree.getRoot()));
		
		System.out.println(btree.isBalanced(btree.getRoot()));
	}
}
