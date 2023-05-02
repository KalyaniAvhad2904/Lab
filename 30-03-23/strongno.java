// strong number
import java.util.*;
public class strongno
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a number");
		int num = sc.nextInt();
		
		for(int i = 1 ; i <= num ; i++)
		{
		    int sum = 0;
		    int flag1 = i;
		    int flag2 = i;
		    while(flag1 > 0)
		    {
		        int j = flag1 % 10;
		        sum += getFact(j);
		        flag1 = flag1/10;
		    }
		    if(sum == flag2)
		    {
		        System.out.print(sum + " ");
		    }
		}
	}
	public static int getFact(int num)
	{
	    int fact = 1;
	    for(int i = 1 ; i <= num ; i++)
	    {
	        fact = fact * i;
	    }
	    return fact;
	}
}