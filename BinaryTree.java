public class BinaryTree 
{
	private Node root;
	private Node currNode;
	public int count;
	
	public BinaryTree()
	{
		this.root = null;
		this.currNode = null;
		this.count = 0;
	}
	
	public void count()
	{
		System.out.println("Count is: " + count);
	}
	
	
	public void displayInOrder()
	{
		System.out.println("**** In Order ****");
		if(this.root == null)
		{
			System.out.println("Empty Tree");
		}
		else if(count > 0)
		{			
			if(currNode.getVisited() == false) //checks currNode to see if it has been displayed yet
			{
				System.out.print(currNode.getPayload() + ", ");
				currNode.setVisited(true);
				count--;
			}		
			
			if(currNode.getLeftNode() != null)//checks to see if there's a node on the left
			{							
				currNode = currNode.getLeftNode();//change currNode to whatever is on the left				
				displayInOrder(); //go back and restart the method
			}		
			
			if(currNode.getRightNode() != null)  //checks to see if there's a node on the right
			{
				currNode = currNode.getRightNode(); //change currNode to whatever is on the right
				displayInOrder(); //restart method
			}			
			
			if(currNode.getLeftNode() == null && currNode.getRightNode() == null) //if the node has no children
			{		
				
				
				if(currNode.getParentNode().getLeftNode() != null)  //go up to the node above
				{
					currNode.getParentNode().setLeftNode(null); //Destroy the node connection,  not what we want to do, but we don't have a good alternative
					currNode = root; //currNode is now the root
					displayInOrder(); //restart the method
				}
				else
				{
					currNode.getParentNode().setRightNode(null); //Destroy the node connection
					currNode = root;  //currNode is now the root
					displayInOrder();
				}
			}
			
			
		}
	}
	
	
	public void displayPostOrder()
	{
		System.out.println("**** Post Order ****");
		if(this.root == null)
		{
			System.out.println("Empty Tree");
		}
		else if(count > 1)
		{
			if(currNode.getLeftNode() != null) //is there a node on the left?
			{							
				currNode = currNode.getLeftNode();//set it to currNode					
				displayPostOrder();			//start over	
			}
			if(currNode.getVisited() == false)  //if the node hasn't been visited
			{
				System.out.print(currNode.getPayload() + ", ");  //print it out
				currNode.setVisited(true);  //set it to visited
				count--;			
			}
			else 
			{
				if(currNode.getRightNode() == null)  //if there is no right node
				{
					if(currNode.getParentNode().getLeftNode() != null) //if the parent has a left node
					{
						currNode.getParentNode().setLeftNode(null); //set it to null, destroying the connection
						currNode = root;   
					}
					else 
					{
						currNode.getParentNode().setRightNode(null); //destroy the connection
						currNode = root;
					}
					displayPostOrder(); //start over
				}
				else
				{
					currNode = currNode.getRightNode();
					displayPostOrder();
				}
			}			
		}
	}
	
	public void add(int value)
	{
		Node theNode = new Node(value);
		if(this.root == null)
		{
			this.root = theNode;
		}
		else
		{
			this.root.addNode(theNode);
		}
	}
}
