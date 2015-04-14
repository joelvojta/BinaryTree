import java.util.Random;

public class Driver 
{
	public static void main(String[] args) 
	{
		Random r = new Random();
		BinaryTree bt = new BinaryTree();
		/*for(int i = 0; i < 5000; i++)
		{
			bt.add(r.nextInt());
		}
		System.out.print(bt.isBalanced());
		*/
		bt.add(2);
		bt.add(4);
		bt.add(7);
		bt.add(8);
		bt.add(10);
		bt.add(12);
		bt.add(14);
		bt.displayInOrder();
		System.out.println(bt.isBalanced());
	}
}
