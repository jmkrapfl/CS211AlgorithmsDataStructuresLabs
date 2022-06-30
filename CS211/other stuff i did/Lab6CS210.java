import java.util.Scanner;
public class Lab6CS210
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int size =  Integer.parseInt(sc.nextLine());
		Stack newStack = new Stack(size);
		String str;
		
		for(int i = size; i>0; i--)
		{
			str = sc.nextLine();
			if(str.matches("(?i)POP"))
			{
				if(newStack.isEmpty() == false)
				{
					newStack.pop();
				}
			}
			else
			{
				//split string
				String [] arrOfStr = str.split(" ");
				//make the num at the end of the string an integer
				//int num = Integer.parseInt(arrOfStr[1]);
				//put the num into the stack
				newStack.push(arrOfStr[1]);
			}
		}
		newStack.printStack();
		System.out.println("*******");
		if(newStack.isEmpty() == false)
		{
			System.out.println(newStack.peek());
		}
		else
		{
			System.out.println("Empty");
		}
	}
}
