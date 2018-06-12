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
				(comp>0 && curr.getRightChild()!=null)) 
		{			
			if(comp < 0)
				curr = curr.getLeftChild();
			else if(comp > 0)
				curr = curr.getRightChild();
			
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
			preOrder(node.getRightChild());
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
				q.add(curr.getRightChild());
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
		
		while(curr!=null) {
			comp = val.compareTo(curr.getData());
			
			if(comp < 0)
			{
				prev = curr;
				curr = curr.getLeftChild();
			}
			else if(comp > 0)
			{
				prev = curr;
				curr = curr.getRightChild();
			}
			else
				break;
		}
		
		if(curr.getLeftChild()==null)
		{
			if(curr.getRightChild() == null)
			{
				if(prev==curr)
				{
					curr.delete();
				}else {
				
					comp = curr.getData().compareTo(prev.getData());
					if(comp<0)
						prev.deleteLeft();				
					else
						prev.deleteRight();
				}
			}else
			{
				curr.setData(curr.getRightChild().getData());
				curr.deleteRight();
			}
		}else if(curr.getRightChild() == null)
		{
			curr.setData(curr.getLeftChild().getData());
			curr.deleteLeft();
		}else
		{
			TreeNode<E> smallest = curr.getRightChild();
			
			while(smallest.getLeftChild()!=null)
			{
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
			else 
			{
				found=true;break;
			}				
		}
		
		if(found==true)
			return curr;
		else
			return null;
		
	}
	
	public static void main(String args[])
	{
		BinaryTree<String> btree = new BinaryTree<String>("east");		
		btree.insert("at");
		btree.insert("eat");
		btree.insert("am");
		btree.insert("ate");
		btree.insert("ear");
		
		btree.preOrder();
		System.out.println();
		
		TreeNode<String> node = btree.getNodeDetails("at");
		System.out.println(node.toString());
		
		
	}
}
