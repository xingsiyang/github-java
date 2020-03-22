package xsy.lab2;

import java.util.List;
import java.io.File;
import java.io.IOException;
import java.util.Map;

public class text 
{
	public static void statisticByReaderWriter(Statistic sta) throws IOException
	{
		String str = sta.readByReader();
		List<Map.Entry<String, Integer>> list = sta.count(str);
		sta.writeByWriter(list);
		System.out.println("统计成功");
	}
	
	public static void statisticByInputStreamOutputStream(Statistic sta) throws IOException
	{
		String str = sta.readByInputStream();
		List<Map.Entry<String, Integer>> list = sta.count(str);
		sta.writeByOutputStream(list);
		System.out.println("统计成功");
	}
	
	public static void main(String[] args) throws IOException
	{
		String file1 = "D:" + File.separator + "demo2020" + File.separator + "了不起的盖茨比英文.txt";
		String file2 = "D:" + File.separator + "demo2020" + File.separator + "output.txt";
		Statistic sta = new Statistic(file1, file2);
		
//		statisticByInputStreamOutputStream(sta);
		statisticByInputStreamOutputStream(sta);	
	}
}
