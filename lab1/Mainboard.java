package xsy.lab1;

public abstract class Mainboard implements working
{
	private String name;
	private int speed;
	private double price;
	
	public Mainboard(String name, int speed, double price)
	{
		this.name = name;
		this.speed = speed;
		this.price = price;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public int getSpeed()
	{
		return this.speed;
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
