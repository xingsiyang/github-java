package xsy.lab4;

import java.util.Arrays;

public class Matrix
{
	private double [][] matrix;
	private int m, n;
	
	public Matrix(int m, int n)
	{
		this.m = m;
		this.n = n;
		this.matrix = new double[m][n];
	}
	
	public double[][] getMatrix() 
	{
		return matrix;
	}
	
	public double getMatrix(int m, int n) 
	{
		return matrix[m][n];
	}
	
	public void setMatrix(int i, int j, double a) 
	{
		if (i <= this.m && j <= this.n)
		{
			this.matrix[i][j] = a;
		}
	}
	
	public void printMatrix()
	{
		for (int i = 0; i < this.m; i++)
		{
			for (int j = 0; j < this.n; j++)
			{
				System.out.print(this.matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public int getM() 
	{
		return m;
	}
	
	public int getN() 
	{
		return n;
	}
	
	@Override
	public boolean equals(Object obj) 
	{
		if (obj == null)
		{
			return false ;
		}
		else
		{
		    if (obj instanceof Matrix)
		    {
		    	Matrix c = (Matrix) obj;
		    	if (this.m != c.getM() || this.n != c.getN())
				{
					return false;
				}
		    	else
		    	{
		    		for (int i = 0; i < this.m; i++)
		    		{
		    			for (int j = 0; j < this.n; j++)
		    			{
		    				if (this.matrix[i][j] != c.getMatrix(i, j))
		    				{
		    					return false;
		    				}
		    			}
		    		}
		    		return true;
		    	}
		    }
		    else
		    {
		    	return false;
		    }
		}
	}
}
