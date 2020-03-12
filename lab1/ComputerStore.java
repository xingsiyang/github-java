package xsy.lab1;

public class ComputerStore 
{
	public static void main(String[] args)
	{
		CPU cpu1 = new IntelCPU("Intel i5-9400F", 6, 1199);
		CPU cpu2 = new AMDCPU("AMD r5-3600", 6, 1369);
		RAM ram1 = new SamsungRAM("Samsung DDR4 2666", "8G", 329);
		RAM ram2 = new KingstonRAM("Kingston DDR4 2666", "8G", 369);
		HardDisk harddisk1 = new SeagateHardDisk("Seagate ST2000DM008", "2T", 389);
		HardDisk harddisk2 = new WestDigitalsHardDisk("WestDigitals WD20EZAZ", "2T", 355);
		Mainboard mainboard1 = new AsusMainboard("Asus TUF B360M-PLUS", 0, 1028);
		Mainboard mainboard2 = new GigabyteMainboard("Gigabyte B450M", 0, 1048);
		
		Computer computer1 = new Computer("computer1", cpu1, ram1, harddisk1, mainboard1);
		Computer computer2 = new Computer("computer2", cpu2, ram2, harddisk2, mainboard2);
		Computer computer3 = new Computer("computer3", cpu1, ram2, harddisk1, mainboard2);
		
		System.out.println("Computer Name: "+ computer1.getName());
		System.out.println(computer1.getDescribe());
		System.out.println("Price: " + computer1.getPrice() + "\n");
		
		System.out.println("Computer Name: "+ computer2.getName());
		System.out.println(computer2.getDescribe());
		System.out.println("Price: " + computer2.getPrice() + "\n");
		
		System.out.println("Computer Name: "+ computer3.getName());
		System.out.println(computer3.getDescribe());
		System.out.println("Price: " + computer3.getPrice() + "\n");
	}
	
}
