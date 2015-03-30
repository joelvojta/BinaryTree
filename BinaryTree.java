public class BinaryTree 
{
	//private Node root;
	private boolean isEmpty;
	private int payload;
	private BinaryTree leftTree;
	private BinaryTree rightTree;
	
	
	public BinaryTree()
	{
		this.isEmpty = true;
		this.leftTree = null;
		this.rightTree = null;
	}
	
	public boolean search(int value)
	{
		if(this.isEmpty)  //if this tree is empty
		{
			System.out.println("Value " + value + " not found.  Empty Tree."); //return false
			return false;
		}
		else
		{
			if(this.payload == value) //if the payload equals the value
			{
				System.out.println("Value " + value + " found.");  //return true
				return true;
			}
			else if(this.payload > value) //if the payload is greater than the incoming value
			{
				if(this.leftTree == null)  //check to the left
				{
					System.out.println("Value " + value + " not found.");  //if nothing is there, return false
					return false;
				}
				else  //if something is there, start the search over again
				{
				return this.leftTree.search(value);	
				}
			}
			else if(this.payload < value) //if the payload is less than the incoming value
			{
				if(this.rightTree == null) //check to the right
				{
					System.out.println("Value " + value + " not found."); //if nothing is there, return false
					return false;
				}
				else  //if something is there, restart your search
				{
					return this.rightTree.search(value);	
				}
			}
		}
		return false;
	}
	
	private void visitInOrder()
	{
		if(this.leftTree != null)
		{
			this.leftTree.visitInOrder();
		}
		System.out.println(this.payload);
		if(this.rightTree != null)
		{
			this.rightTree.visitInOrder();
		}
	}

	public void displayInOrder()
	{
		System.out.println("**** In Order ****");
		if(this.isEmpty)
		{
			System.out.println("Empty Tree");
		}
		else
		{
			this.visitInOrder();
		}
	}
	
	private void visitPreOrder()
	{
		System.out.println(this.payload);
		if(this.leftTree != null)
		{
			this.leftTree.visitPreOrder();
		}
		if(this.rightTree != null)
		{
			this.rightTree.visitPreOrder();
		}
	}
	
	public void displayPreOrder()
	{
		System.out.println("**** Pre Order ****");
		if(this.isEmpty)
		{
			System.out.println("Empty Tree");
		}
		else
		{
			this.visitPreOrder();
		}
	}
	
	private void visitPostOrder()
	{
		if(this.leftTree != null)
		{
			this.leftTree.visitPostOrder();
		}
		if(this.rightTree != null)
		{
			this.rightTree.visitPostOrder();
		}
		System.out.println(this.payload);
	}
	
	public void displayPostOrder()
	{
		System.out.println("**** Post Order ****");
		if(this.isEmpty)
		{
			System.out.println("Empty Tree");
		}
		else
		{
			this.visitPostOrder();
		}
	}
	
	public void add(int value)
	{
		if(this.isEmpty)
		{
			this.payload = value;
			this.isEmpty = false;
		}
		else
		{
			if(value <= this.payload)
			{
				if(this.leftTree == null)
				{
					this.leftTree = new BinaryTree();	
				}
				this.leftTree.add(value);
			}
			else
			{
				if(this.rightTree == null)
				{
					this.rightTree = new BinaryTree();
				}
				this.rightTree.add(value);
			}
		}
	}
}
