package xsy.lab1;

public abstract class CPU implements working
{
	private String name;
	private int coreNum;
	private double price;
	
	public CPU(String name, int coreNum, double price)
	{
		this.name = name;
		this.coreNum = coreNum;
		this.price = price;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public int getCoreNum()
	{
		return this.coreNum;
	}
	
	public double getPrice()
	{
		return this.price;
	}
	
	public void printMannerOfWork()
	{
		System.out.println(this.name + " work");
	}
}
