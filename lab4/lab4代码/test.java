package xsy.lab4;

public class test 
{	
	public static void main(String[] args) throws InterruptedException 
	{
		int size = 10;
		
		Matrix matrix1 = new MatrixGenerator(size, size).getMatrix();
		Matrix matrix2 = new MatrixGenerator(size, size).getMatrix();
		
		long time1 = System.nanoTime();
		Matrix resultSequentially = MatrixMultiplication.multiplySequentially(matrix1, matrix2);
		long time2 = System.nanoTime();
		Matrix resultParallelTwoThread = MatrixMultiplication.multiplyParallelTwoThread(matrix1, matrix2);
		long time3 = System.nanoTime();
		Matrix resultParallelThreeThread = MatrixMultiplication.multiplyParallelThreeThread(matrix1, matrix2);
		long time4 = System.nanoTime();
		Matrix resultParallelFourThread = MatrixMultiplication.multiplyParallelFourThread(matrix1, matrix2);
		long time5 = System.nanoTime();

		assert resultSequentially.equals(resultParallelTwoThread);
		assert resultSequentially.equals(resultParallelThreeThread);
		assert resultSequentially.equals(resultParallelFourThread);

		System.out.println("当矩阵大小为: " + size + " * " + size + " 时:");
		System.out.println("串行方法使用时间: " + (time2 - time1) + "ns");
		System.out.println("两个线程使用时间: " + (time3 - time2) + "ns");
		System.out.println("三个线程使用时间: " + (time4 - time3) + "ns");
		System.out.println("四个线程使用时间: " + (time5 - time4) + "ns");
	}	
}
