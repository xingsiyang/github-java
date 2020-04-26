package xsy.lab4;

import java.util.Random;

public class MatrixGenerator 
{
	private Matrix matrix;
	
	public MatrixGenerator(int m, int n)
	{
		this.matrix = new Matrix(m, n);
		this.initMatrix();
	}
	
	public void initMatrix()
	{
		Random r = new Random();
		for (int i = 0; i < this.matrix.getM(); i++)
		{
			for (int j = 0; j < this.matrix.getN(); j++)
			{
				this.matrix.setMatrix(i, j, r.nextInt(100));
			}
		}
	}
	
	public Matrix getMatrix()
	{
		return this.matrix;
	}
}
