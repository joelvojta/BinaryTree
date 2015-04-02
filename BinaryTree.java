public class BinaryTree 
{
	//private Node root;
	private boolean isEmpty;
	private int payload;
	private BinaryTree leftTree;
	private BinaryTree rightTree;
	private int depth;
	
	public int differ; //what's the difference between two trees
	
	public BinaryTree()
	{
		this(0);
	}
	
	private BinaryTree(int depth)
	{
		this.isEmpty = true;
		this.leftTree = null;
		this.rightTree = null;
		this.depth = depth;
	}
	
	public boolean search(int value)
	{
		//return true if value is in the tree
		//return false if value is not in the tree
		if(this.isEmpty)
		{
			return false;
		}
		else
		{
			if(this.payload == value)
			{
				return true;
			}
			else
			{
				if(value < payload)
				{
					//check the left
					if(this.leftTree == null)
					{
						return false;
					}
					else
					{
						return this.leftTree.search(value);
					}
				}
				else
				{
					//check the right
					if(this.rightTree == null)
					{
						return false;
					}
					else
					{
						return this.rightTree.search(value);
					}
				}
			}
		}
	}
	
	private void visitInOrder()
	{
		if(this.leftTree != null)
		{
			this.leftTree.visitInOrder();
		}
		System.out.println(this.payload + " : " + this.depth);
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
	
	private int getMaxDepth()
	{
		if(this.leftTree == null && this.rightTree == null)
		{
			return this.depth;
		}
		else if(this.leftTree == null)
		{
			return this.rightTree.getMaxDepth();
		}
		else if(this.rightTree == null)
		{
			return this.leftTree.getMaxDepth();
		}
		else
		{
			return Math.max(this.leftTree.getMaxDepth(), this.rightTree.getMaxDepth());
		}
	}
	
	public boolean isBalanced()
	{
		if(this.isEmpty)
		{
			return true;
		}
		else
		{
			//boolean-expr?true-val:false-val
			int currMaxLeftDepth = this.leftTree == null?0:this.leftTree.getMaxDepth();
			int currMaxRightDepth = this.rightTree == null?0:this.rightTree.getMaxDepth();
			System.out.println("Max Left = " + currMaxLeftDepth);
			System.out.println("Max Right = " + currMaxRightDepth);
			return Math.abs(currMaxLeftDepth - currMaxRightDepth) <= 1;
		}
	}

	
	public int findDiffer()   //finds difference between two trees
	{
		int currMaxLeftDepth = this.leftTree == null?0:this.leftTree.getMaxDepth();
		int currMaxRightDepth = this.rightTree == null?0:this.rightTree.getMaxDepth();
		differ = currMaxLeftDepth - currMaxRightDepth;
		return differ;
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
			if(value < this.payload) //add to left
			{
				if(this.leftTree == null)
				{
					this.leftTree = new BinaryTree(this.depth+1);	
				
				this.leftTree.add(value);
				
				if(this.findDiffer() > 1)// finds difference
				{
					if ( value < this.leftTree.payload) 
					{
	                    this.leftTree = rotateLeft(this);
	                } 
					else 
					{
	                    this.leftTree = doubleLeft(this);
	                }
					}
				}
			}
			
			else if(value > this.payload)  					 //add to right
			{
				if(this.rightTree == null)
				{
				this.rightTree = new BinaryTree(this.depth+1);
				this.rightTree.add(value);
				
				if(this.findDiffer() < 1)// finds difference
				{
					this.leftTree = rotateRight(this);
				}
				else
				{
					this.leftTree = doubleRight(this);
				}
				
				}
			}
			else
			{
		         this.depth = Math.max(this.leftTree.getMaxDepth(), this.rightTree.getMaxDepth()) + 1; 
		         
			}
		}
	}
	
	public BinaryTree rotateLeft(BinaryTree n) 
	{
		BinaryTree r = n.rightTree;  //make a copy of n's rightTree
        n.rightTree = r.leftTree;  //n's rightTree is now r's leftTree
        r.leftTree = n;
        n.depth = Math.max(n.leftTree.getMaxDepth(), n.rightTree.getMaxDepth()) + 1;  //which one is bigger
	    r.depth = Math.max(r.leftTree.getMaxDepth(), r.rightTree.getMaxDepth()) + 1;
	    return r;
	}
	
	
	private BinaryTree rotateRight(BinaryTree n) 
	{
	     BinaryTree r = n.leftTree;
	     n.leftTree = r.rightTree;
	     r.rightTree = n;
	     n.depth = Math.max(n.leftTree.getMaxDepth(), n.rightTree.getMaxDepth()) + 1;
	     r.depth = Math.max(r.leftTree.getMaxDepth(), r.rightTree.getMaxDepth()) + 1;
	     return r;
	}
	
	private BinaryTree doubleLeft(BinaryTree k3)
    {
        k3.leftTree = rotateRight( k3.leftTree );
        return rotateLeft( k3 );
    }
	
	private BinaryTree doubleRight(BinaryTree k1)
    {
        k1.rightTree = rotateLeft( k1.rightTree );
        return rotateRight( k1 );
    } 
	
	
}

