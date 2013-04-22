import java.io.File;
import java.io.FileNotFoundException;
import java.util.Hashtable;
import java.util.Scanner;


public class WordCounter 
{
	static Hashtable list;
	public static final int TABLE_LENGTH = 151;
	public static int amount = 1;
	public static void main(String[] args)
	{
		list=new Hashtable<Integer, Integer>(TABLE_LENGTH);
		
		
		try {
				File tempFile = new File("input.txt");
				Scanner in = new Scanner(tempFile);
					while(in.hasNext())
					{
						String temp = in.next();
						int hashCode = calculateHashCode(temp);
						
						if(list.containsKey(hashCode))
							list.put(hashCode,(int)(list.get(hashCode))+1);
						else
							list.put(hashCode,amount);
					}
			} 
		
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		
		System.out.println(list.toString());
	}
	
	public static int calculateHashCode(String s)
	{
		int result=0;
		for(int i=0;i<s.length();i++)
		{
			result+=(int)s.charAt(i);
			System.out.println((int)(s.charAt(i)));
		}
		
		if(result>TABLE_LENGTH)
			result=result%TABLE_LENGTH;
		
		return result;
		
	}

}
