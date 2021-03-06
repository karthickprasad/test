import java.io.*;

class bottom_up
{
	public static void main(String[] args) throws Exception
	{
		int no, loc=0, i, j;
		String str, stack="", temp;
		String[][] productions;
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter no. of productions: ");
		no = Integer.parseInt(in.readLine());
		productions = new String[no][2];
		System.out.println("Enter the productions:");
		for (i=0; i < no; i++)
		{
System.out.print("Enter production "+(i+1)+": ");
                        String inp = in.readLine();
                        String[] sp = inp.split("=");
			//System.out.print("LHS for production "+(i+1)+": ");
			productions[i][0] = sp[0];
			
			productions[i][1] = sp[1];
		}
		System.out.println("The productions are:");
		for (i=0; i < no; i++)
		{
			System.out.println(productions[i][0]+" -> "+productions[i][1]);
		}
		System.out.print("Enter a string: ");
		str = in.readLine();
		while (loc < str.length()-1)
		{
			temp = str.substring(loc, str.indexOf(' ', loc));
			loc = str.indexOf(' ', loc)+1;
			for (i=0; i < no; i++)
			{
				if (temp.equals(productions[i][1]))
				{
					temp = productions[i][0];
					break;
				}
			}
			stack = stack+temp;
			System.out.println("Stack contents: "+stack);
			for (i=0; i < no; i++)
			{
				if (stack.equals(productions[i][1]))
				{
					stack = productions[i][0];
					break;
				}
			}
		}
		System.out.println("Stack contents: "+stack);
		if (stack.equals(productions[0][0]))
			System.out.println("Accepted.");
		else
			System.out.println("Rejected.");
	}
}
