package xsy.lab1;

public abstract class HardDisk implements working
{
	private String name;
	private String volume;
	private double price;
	
	public HardDisk(String name, String volume, double price)
	{
		this.name = name;
		this.volume = volume;
		this.price = price;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public String getVolume()
	{
		return this.volume;
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
