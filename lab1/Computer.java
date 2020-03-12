package xsy.lab1;

public class Computer 
{
	private String name;
	private CPU cpu;
	private RAM ram;
	private HardDisk hardDisk;
	private Mainboard mainboard;
	private double price;
	
	public Computer(String name, CPU cpu, RAM ram, HardDisk hardDisk, Mainboard mainboard)
	{
		this.name = name;
		this.cpu = cpu;
		this.ram = ram;
		this.hardDisk = hardDisk;
		this.mainboard = mainboard;
		this.price = cpu.getPrice() + ram.getPrice() + hardDisk.getPrice() + mainboard.getPrice();
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public double getPrice()
	{
		return this.price;
	}
	
	public String getDescribe()
	{
		return "CPU: " + cpu.getName() + "\nRAM: " + ram.getName() 
		+ "\nHard Disk: " + hardDisk.getName() + "\nMainboard: " + mainboard.getName();
	}
}
