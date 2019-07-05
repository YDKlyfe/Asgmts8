import java.io.File;
import java.util.Scanner;

public class StringTree {

	private Node head;

	public StringTree()
	{
		head = null;
	}

	public void add(String value)
	{
		if(head == null)
		{
			head = new Node(value);
		}
		else
		{
			if(head.value.compareTo(value) > 0)
			{
				if(head.left == null)
					head.left = new Node(value);
				else
					addRecursive(head.left, value);
			}
			else
			{
				if(head.right == null)
					head.right = new Node(value);
				else
					addRecursive(head.right, value);
			}
		}
	}

	private void addRecursive(Node n, String value)
	{
		if(n.value.compareTo(value) > 0)
		{
			if(n.left == null)
				n.left = new Node(value);
			else
				addRecursive(n.left, value);
		}
		else
		{
			if(n.right == null)
				n.right = new Node(value);
			else
				addRecursive(n.right, value);
		}

	}

	//Print method for the tree
	public void printTree()
	{
		if(head == null)
			System.out.println("The tree is empty");
		else
		{
			System.out.println("Strings in alphabetical order:");
			printRecursive(head);
		}


	}

	private void printRecursive(Node n)
	{
		//First, print the left if it exists
		if(n.left != null)
			printRecursive(n.left);
		//Then, print the parent
		System.out.println(n.value);
		//Finally, print the right if it exists
		if(n.right != null)
			printRecursive(n.right);
	}

	//Main method, starts the program
	public static void main(String[] args) throws Exception
	{
		//Reads the file
		File file = new File("./src/FruitsAndVegetables.txt");
		Scanner imTheReader = new Scanner(file);

		StringTree tree = new StringTree();
		while(imTheReader.hasNextLine())
		{
			String word = imTheReader.nextLine();
			tree.add(word);
		}

		tree.printTree();


	}
}