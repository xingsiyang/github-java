package xsy.lab4;

public class MatrixMultiplication
{
	public static Matrix multiplySequentially(Matrix x, Matrix y)
	{
		int a = x.getM();
		int b1 = x.getN();
		int b2 = y.getM();
		int c = y.getN();
		if (b1 == b2)
		{
			Matrix result = new Matrix(a, c);
			for (int i = 0; i < a; i++)
			{
				for (int j = 0; j < c; j++)
				{
					double sum = 0;
					for (int k = 0; k < b1; k++)
					{
						sum += x.getMatrix(i, k) * y.getMatrix(k, j);
					}
					result.setMatrix(i, j, sum);
				}
			}
			return result;
		}
		else	
		{
			return null;
		}	
	}
	
	public static Matrix multiplyParallelTwoThread(Matrix x, Matrix y) throws InterruptedException
	{
		int a = x.getM();
		int b1 = x.getN();
		int b2 = y.getM();
		int c = y.getN();
		if (b1 == b2)
		{
			Matrix result = new Matrix(a, c);
			TwoThread tt = new TwoThread(x, y, result);
			Thread thread1 = new Thread(tt, "线程1");
			Thread thread2 = new Thread(tt, "线程2");
			thread1.start();
//			thread1.join();
			thread2.start();
//			thread2.join();
			while (thread1.isAlive() || thread2.isAlive()){}
			return result;
		}
		else	
		{
			return null;
		}
	}
	
	public static Matrix multiplyParallelThreeThread(Matrix x, Matrix y) throws InterruptedException
	{
		int a = x.getM();
		int b1 = x.getN();
		int b2 = y.getM();
		int c = y.getN();
		if (b1 == b2)
		{
			Matrix result = new Matrix(a, c);
			ThreeThread tt = new ThreeThread(x, y, result);
			Thread thread1 = new Thread(tt, "线程1");
			Thread thread2 = new Thread(tt, "线程2");
			Thread thread3 = new Thread(tt, "线程3");
			thread1.start();
//			thread1.join();
			thread2.start();
//			thread2.join();
			thread3.start();
//			thread3.join();
			while (thread1.isAlive() || thread2.isAlive() || thread3.isAlive()){}
			return result;
		}
		else	
		{
			return null;
		}
	}
	
	public static Matrix multiplyParallelFourThread(Matrix x, Matrix y) throws InterruptedException
	{
		int a = x.getM();
		int b1 = x.getN();
		int b2 = y.getM();
		int c = y.getN();
		if (b1 == b2)
		{
			Matrix result = new Matrix(a, c);
			FourThread tt = new FourThread(x, y, result);
			Thread thread1 = new Thread(tt, "线程1");
			Thread thread2 = new Thread(tt, "线程2");
			Thread thread3 = new Thread(tt, "线程3");
			Thread thread4 = new Thread(tt, "线程4");
			thread1.start();
//			thread1.join();
			thread2.start();
//			thread2.join();
			thread3.start();
//			thread3.join();
			thread4.start();
//			thread4.join();
			while (thread1.isAlive() || thread2.isAlive() || thread3.isAlive() || thread4.isAlive()){}
			return result;
		}
		else	
		{
			return null;
		}
	}
}

class TwoThread implements Runnable
{
	Matrix matrix1, matrix2, result;
	
	public TwoThread(Matrix matrix1, Matrix matrix2, Matrix result)
	{
		this.matrix1 = matrix1;
		this.matrix2 = matrix2;
		this.result = result;
	}
	
	@Override
	public void run() 
	{
		if (Thread.currentThread().getName().equals("线程1"))
		{
			firstThread();
		}
		else if (Thread.currentThread().getName().equals("线程2"))
		{
			secondThread();
		}
	}
	
	public void firstThread()
	{
		for (int i = 0; i < matrix1.getM(); i += 2)
		{
			for (int j = 0; j < matrix2.getN(); j++)
			{
				double sum = 0;
				for (int k = 0; k < matrix1.getN(); k++)
				{
					sum += matrix1.getMatrix(i, k) * matrix2.getMatrix(k, j);
				}
				result.setMatrix(i, j, sum);
			}
		}

	}
	
	public void secondThread()
	{
		for (int i = 1; i < matrix1.getM(); i += 2)
		{
			for (int j = 0; j < matrix2.getN(); j++)
			{
				double sum = 0;
				for (int k = 0; k < matrix1.getN(); k++)
				{
					sum += matrix1.getMatrix(i, k) * matrix2.getMatrix(k, j);
				}
				result.setMatrix(i, j, sum);
			}
		}
	}
}

class ThreeThread implements Runnable
{
	Matrix matrix1, matrix2, result;
	
	public ThreeThread(Matrix matrix1, Matrix matrix2, Matrix result)
	{
		this.matrix1 = matrix1;
		this.matrix2 = matrix2;
		this.result = result;
	}
	
	@Override
	public void run() 
	{
		if (Thread.currentThread().getName().equals("线程1"))
		{
			firstThread();
		}
		else if (Thread.currentThread().getName().equals("线程2"))
		{
			secondThread();
		}
		else if (Thread.currentThread().getName().equals("线程3"))
		{
			thirdThread();
		}
	}
	
	public void firstThread()
	{
		for (int i = 0; i < matrix1.getM(); i += 3)
		{
			for (int j = 0; j < matrix2.getN(); j++)
			{
				double sum = 0;
				for (int k = 0; k < matrix1.getN(); k++)
				{
					sum += matrix1.getMatrix(i, k) * matrix2.getMatrix(k, j);
				}
				result.setMatrix(i, j, sum);
			}
		}
	}
	
	public void secondThread()
	{
		for (int i = 1; i < matrix1.getM(); i += 3)
		{
			for (int j = 0; j < matrix2.getN(); j++)
			{
				double sum = 0;
				for (int k = 0; k < matrix1.getN(); k++)
				{
					sum += matrix1.getMatrix(i, k) * matrix2.getMatrix(k, j);
				}
				result.setMatrix(i, j, sum);
			}
		}
	}
	
	public void thirdThread()
	{
		for (int i = 2; i < matrix1.getM(); i += 3)
		{
			for (int j = 0; j < matrix2.getN(); j++)
			{
				double sum = 0;
				for (int k = 0; k < matrix1.getN(); k++)
				{
					sum += matrix1.getMatrix(i, k) * matrix2.getMatrix(k, j);
				}
				result.setMatrix(i, j, sum);
			}
		}
	}
}

class FourThread implements Runnable
{
	Matrix matrix1, matrix2, result;
	
	public FourThread(Matrix matrix1, Matrix matrix2, Matrix result)
	{
		this.matrix1 = matrix1;
		this.matrix2 = matrix2;
		this.result = result;
	}
	
	@Override
	public void run() 
	{
		if (Thread.currentThread().getName().equals("线程1"))
		{
			firstThread();
		}
		else if (Thread.currentThread().getName().equals("线程2"))
		{
			secondThread();
		}
		else if (Thread.currentThread().getName().equals("线程3"))
		{
			thirdThread();
		}
		else if (Thread.currentThread().getName().equals("线程4"))
		{
			fourthThread();
		}
	}
	
	public void firstThread()
	{
		for (int i = 0; i < matrix1.getM(); i += 4)
		{
			for (int j = 0; j < matrix2.getN(); j++)
			{
				double sum = 0;
				for (int k = 0; k < matrix1.getN(); k++)
				{
					sum += matrix1.getMatrix(i, k) * matrix2.getMatrix(k, j);
				}
				result.setMatrix(i, j, sum);
			}
		}
	}
	
	public void secondThread()
	{
		for (int i = 1; i < matrix1.getM(); i += 4)
		{
			for (int j = 0; j < matrix2.getN(); j++)
			{
				double sum = 0;
				for (int k = 0; k < matrix1.getN(); k++)
				{
					sum += matrix1.getMatrix(i, k) * matrix2.getMatrix(k, j);
				}
				result.setMatrix(i, j, sum);
			}
		}
	}
	
	public void thirdThread()
	{
		for (int i = 2; i < matrix1.getM(); i += 4)
		{
			for (int j = 0; j < matrix2.getN(); j++)
			{
				double sum = 0;
				for (int k = 0; k < matrix1.getN(); k++)
				{
					sum += matrix1.getMatrix(i, k) * matrix2.getMatrix(k, j);
				}
				result.setMatrix(i, j, sum);
			}
		}
	}
	
	public void fourthThread()
	{
		for (int i = 3; i < matrix1.getM(); i += 4)
		{
			for (int j = 0; j < matrix2.getN(); j++)
			{
				double sum = 0;
				for (int k = 0; k < matrix1.getN(); k++)
				{
					sum += matrix1.getMatrix(i, k) * matrix2.getMatrix(k, j);
				}
				result.setMatrix(i, j, sum);
			}
		}
	}
}
