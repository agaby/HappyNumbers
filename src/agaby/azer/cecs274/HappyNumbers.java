package agaby.azer.cecs274;

import java.util.ArrayList;
import java.util.Scanner;
/**Agaby Azer
 * 10/18/16
 *
 */

public class HappyNumbers {
	 static ArrayList<Integer> list= new ArrayList();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Welcome to the happiest numbers on earth!");
		Scanner input= new Scanner(System.in);
		boolean exit=false;
		do{
			
			System.out.println("choose one of the following: \n "
					+ "1. Show happy sequence for a number. 2. Show all happy numbers in a sequence. 3.Exit");
			int choice=input.nextInt();
			switch(choice)
			{
			case 1:
				System.out.println("Enter a postive number");
				int x=input.nextInt();
				while(x<0)
				{
					System.out.println("Enter a postive number");
					x=input.nextInt();
				}
				happy(x);
				display2();
				list.clear();
				break;
			case 2:
				System.out.println("Enter two postive numbers and I will show you the happy numbers between those numbers");
				System.out.print("number 1: ");
				int n1=input.nextInt();
				System.out.print("number 2: ");
				int n2=input.nextInt();
				while(n1<0 || n2<0)
				{
					System.out.println("Please enter postive numbers");
					System.out.print("number 1: ");
					n1=input.nextInt();
					System.out.print("number 2: ");
					n2=input.nextInt();
				}
				System.out.println("Here are the happy numbers");
				for(int i=n1;i<=n2;i++)
				{
					happy2(i);
				}
				
				display();
				list.clear();
				break;
			case 3:
				System.out.println("Thank you");
				exit=true;
				break;
				
			}
		}
		while(exit==false);
		
		
	}
	public static boolean happy2(int n)
	{
		//list.add(n);
		int m=sods(n);
		//list.add(m);
		while(m>9)
		{		
			 m=sods(m);
			//list.add(m);
		}
			if(m==1)
			{
			list.add(n);
			return true;
			}
			
			else
			{
				list.add(0);
			
			return false;
			
			}
			
	}
	public static boolean happy(int n)
	{
		list.add(n);
		int m=sods(n);
		list.add(m);
		while(m!=1)
		{		
			 m=sods(m);
			 if(list.contains(m))
			 {
				 list.add(m);
				 break;
			 }
			list.add(m);
		}
		
			if(m==1)
			{
			System.out.println("happy");
			return true;
			}
			
			else
			{
			System.out.println("not happy");
			return false;
			}
			
	}


	public static int sods(int n)
	{
		
		int output=0;
		if(n<10)
		{	
			int nsq=(char)Math.pow(n,2);
			return nsq;
		}
		else
		{
			output=(sods(n/10)+(sods(n%10)));
		}
		
		return output;
		
	}

	public static void display2()
	{
		//System.out.println(list);
		for(int i=0; i<list.size();i++)
		{
			if( i==list.size()-1)
			{
				System.out.println(list.get(i));
			}
			else
			System.out.print(list.get(i)+",");
		}
		System.out.println();
	}
	public static void display()
	{
		int counter=0;
		
		for(int i=0; i<list.size();i++)
		{
			counter++;
			if(counter>30)
				{
					counter=0;
					System.out.println();
				}
			
			if(list.get(i)==0)
				System.out.print(".");
			
			else
			{
				if(list.get(i) >= 1000)
					counter += 3;
				else if (list.get(i) >= 100)
					counter += 2;
				else if(list.get(i) >= 10)
					counter += 1;
				
				if(counter <= 30)
					System.out.print(list.get(i));
				else
				{
					System.out.println();
					counter = 0;
					
				}
			}
		}
		System.out.println();
	}
	
}
