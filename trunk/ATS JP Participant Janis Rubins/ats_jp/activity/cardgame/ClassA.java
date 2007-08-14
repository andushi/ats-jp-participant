package ats_jp.activity.cardgame;

public class ClassA {
	ClassA()
	{
		System.out.print("classA");
		
	}
}
class ClassB extends ClassA
{
	ClassB()
	{
	System.out.print("ClassB");
	
	}
	public static void main (String a[])
	{
		ClassB objB=new ClassB();
	}
}