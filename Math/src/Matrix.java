// Matrix Algebra
// Rich Hilliard 2014


public class Matrix {
	
	private int rows;
	private int columns;
	private int nums[][];
	private boolean square;
	
	private boolean diagonal; //	private boolean upperTri; //	private boolean lowTri;

		// direct sum 
		// power rules
		// reading from files, CSVs probably.
	//formatting for matrix elements of larger sizes. 
	// enable doubles
	// enable complex numbers! and the use of other expressions. 
	
	public Matrix(){}
	
	public Matrix(int r, int c)
	{
		setRows(r);
		setColumns(c);
		setNUMS(r,c);
		setSquare(this.checkSquare());
		this.setDiagonal(this.checkDiagonal());
	}
	
	public Matrix(Matrix m)
	{
		this.setRows(m.getRows());
		this.setColumns(m.getColumns());
		this.setNUMS(this.getRows(), this.getColumns());
	
		for (int i = 0; i < this.getRows(); i ++)
		{		for (int j = 0; j < this.getColumns(); j ++){	this.nums[i][j] = m.nums[i][j];	}	}
		this.setSquare(m.getSquare());
		this.setDiagonal(m.getDiagonal());
	}
	
	public void setRows(int r)
	{
		if (r >= 1)	rows  = r;
		else System.out.println("Invalid entry");
		setSquare(checkSquare());
	}
	
	public void setColumns(int c)
	{
		if (c >= 1)	columns  = c;
		else System.out.println("Invalid entry");
		setSquare(checkSquare());
	}
	
	public void setNUMS(int r, int c)
	{
		int k[][] = new int[r][c];
		nums = k;
	}
	
	public void setSquare(boolean b)	{		square = b;	}

	public void setDiagonal(boolean b)	{		diagonal = b; }
	
//GET	
	public int getRows()	{ return rows;}
	
	public int getColumns()	{ return columns; }
	
	public boolean getSquare()	{	return square;}
	
	public boolean checkSquare()
	{
		boolean b = false;
		if (this.getRows() == this.getColumns()) b = true;
		return b;
	}
	
	public boolean getDiagonal()	{	return diagonal;	}
	
	public boolean checkDiagonal() //untested
	{
		boolean di = false;
		if (this.getSquare() == true)
		{
			di = true;
			for (int i = 0; i < this.getRows(); i ++)
			{
				for (int j = 0; j < this.getColumns(); j ++)
				{
					if (i != j) {
						if (this.returnCell(i,j) != 0) 
						{
							di = false;
							i += this.getColumns();
						}
						
					}
				}
			}
		}
		
		return di;
	}
	
	
	public int returnCell(int r, int c)			{	return this.nums[r][c];	}	

	public void setCell(int r, int c, int xx)	{	this.nums[r][c] = xx;	}
	
	public void printMatrix()
	{
		for (int i = 0; i < this.getRows(); i ++)
		{
			for (int j = 0; j < this.getColumns(); j ++)
			{
				System.out.print(this.nums[i][j] + " ");		
			}
			System.out.println();
		}
	}
	
	
	// this not done. 
	public int getFormatSize()
	{
		int size = 1;
		int[] t = this.linearMatrixOut();
		
		for (int i = 0; i < t.length; i++ )
		{
			// turn this int to String
			//int a  = t[i] 
			// .length
			
			// if ( a > size) size = a;
			
			
		}
		
		
		return size;
		
	}
	
	
	
	public void fillMatrixLinear(int[] t)

	{
		if (t.length == this.getColumns() * this.getRows())
		{
	
			int iterator = 0;
			
			for (int i = 0; i < this.getRows(); i ++)
			{
				for (int j = 0; j < this.getColumns(); j ++)
				{
					setCell(i,j,t[iterator]);
					//this.nums[i][j] = t[iterator];
					iterator++;
				} // end for j
			}// end for i 
		}
		else System.out.println("Matrix, array size mismatch");
	}
	
	public void fillMatrixLinearTranspose(int[] t)
	// this method is a dulplicate of fill matrix linear, except the argument for setCell, 
	// has the i and j switched.
	
	// now, this.getColumns() and this.getRows() have been switched. 
	
	{
		if (t.length == (this.getColumns() * this.getRows()))
		{
			int iterator = 0;	
			for (int i = 0; i < this.getColumns(); i ++)
			{
				for (int j = 0; j < this.getRows(); j ++)
				{
					setCell(j,i,t[iterator]);
					iterator++;
				} // end for j
			}// end for i 
		}
		else System.out.println("Matrix, array size mismatch");
		
		
		
	}
	
	public int[] linearMatrixOut()
	{
		int[] out = new int[this.getElementCount()];
	
		int k = 0;
		
		for (int i = 0; i < this.getRows(); i ++)
		{
			for (int j = 0; j < this.getColumns() ; j++)
			{
				out[k] = this.returnCell(i, j);
				k++;
			}
		}

		return out;
		
	}
	
	public int getElementCount()
	{	return (this.getColumns() * this.getRows()); }
	
	public Matrix add(Matrix a, Matrix b)
	{

		if (a.getRows() == b.getRows() && a.getColumns() == b.getColumns())
		{
			Matrix m = new Matrix(a.getRows(),a.getColumns());
			
			for (int i = 0; i < m.getRows(); i ++)
			{
				for (int j = 0; j < m.getColumns() ; j++)
				{
					int add = a.returnCell(i, j) + b.returnCell(i, j);
					
					//System.out.println("i:" + i + " j:" + j + " add:" +  add);
					
					m.setCell(i, j, add);
				}
			}
			return m;
		}
		else 
		{
			System.out.println("Invalid type addition");
			return null;
		}	
	
	}
	
	public Matrix subtract(Matrix a)
	{
		Matrix n = new Matrix(a);
		n = n.scalarMultiply(-1);
		n = add(this,n);
		return n;
	}
	
	public Matrix scalarMultiply(int scalar)
	{
		Matrix m = new Matrix(this);
		
		for (int i = 0; i < m.getRows(); i ++)
		{
			for (int j = 0; j < m.getColumns(); j ++)
			{
				int result = this.returnCell(i, j) * scalar;
				m.setCell(i, j, result);
			}
		}
		
		return m; 
	}
	
	public Matrix directSum(Matrix a, Matrix b) 
	// see https://en.wikipedia.org/wiki/Matrix_addition
	{
		Matrix m = new Matrix(); 

		return m;
	}
	
	public Matrix matrixProduct(Matrix a)
	{
		if(this.getColumns() == a.getRows())
		{
			Matrix m = new Matrix(this.getRows(),a.getColumns()); 
			System.out.println("r:" + m.getRows() + " c:" + m.getColumns() );


			for (int i = 0; i < m.getRows(); i ++)
			{
				for (int j = 0; j < m.getColumns(); j++)
				{
					int sum = 0;
					for (int x = 0; x < this.getColumns(); x++)
					{
//						System.out.println("i:" + i + " j:" + j + " x: " + x + " sum:" +  sum );
// the x terms below were going out of bounds because they were being assigned as i+x, j+x, etc
// of course, it finally became clear that x could, and had to replace them completely.
						sum += (this.returnCell(i,x) * a.returnCell(x,j));	
					}
					m.setCell(i, j, sum);
				}
			}
			
			return m;
			
		}
		else 
		{
			System.out.println("Invlaid matrix product, check yo self");
			return null;
		}
	}
	
	public Matrix transpose()
	{
		Matrix m = new Matrix(this.getColumns(), this.getRows());
		int[] inzo = this.linearMatrixOut();		
		m.fillMatrixLinearTranspose(inzo);
		return m;
	}
	
	public int determinant(Matrix a)
	{
		if (a.checkSquare() == true) 
		{
			int det = 0;
		
			for (int x = 0; x < a.getColumns(); x++)
			{
				int y = 0; 
				
				det += 
				y++;
			}
			
			return det;
		}
		
		
		else 
		{ 
			System.out.println("Dat's not a square matrix, dog.");
			return 0;
		}
	}

//THIS IS WRONG 	
	public Matrix directProduct(Matrix a )
	{
		if (this.checkSquare() == true && a.checkSquare() == true){
				
			Matrix m = new Matrix(this.getRows()*a.getRows(), this.getColumns()*a.getColumns());
		
			int[] all = new int[m.getRows()*m.getColumns()];
			int[] bcomp = new int[a.getColumns()*a.getRows()];
			bcomp = a.linearMatrixOut();
			int k = 0; int r = 0; int c = 0;
			for (int i = 0; i < all.length; i++)
			{
				all[i] = bcomp[k]*this.returnCell(r,c);
				k++;
				if (k == bcomp.length) 
				{
					k = 0;
					if ( r != this.getRows() - 1) r++;
					else 
					{
						c++; //lolz
						r = 0;
					}
					// how to change r and c? 
				}
				
			m.fillMatrixLinear(all);
				
			}
				
			return m;
		
		}
		else{ 
		System.out.println("matrixes aren't square");
		return null;
		}
		
	}
	
	

}
