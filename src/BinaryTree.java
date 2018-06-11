import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree<E> {
	TreeNode<E> root;
	
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
}
