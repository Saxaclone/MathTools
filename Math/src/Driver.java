/*




public class Drive {

	public static void main(String args[])
	{

		Matrix a = new Matrix(2,3);
		int[] l = {1,3,5,99,8,7};
		System.out.println("L length " + l.length);
		a.fillMatrixLinear(l);
		a.printMatrix();
		System.out.println();
		a = a.transpose();
		a.printMatrix();
		System.out.println();
	}
}








public class Driver {
	
	
	public static void main(String args[])
	{
	
		Matrix a = new Matrix(2,3);
		Matrix b = new Matrix(3,2);
		
		int[] t = {2,2,2,2,2,2};
		int[] p = {5,5,5,5,5,5};
		
		a.fillMatrixLinear(t);
		b.fillMatrixLinear(p);
		
		System.out.println("A and B");

		a.printMatrix();
		System.out.println();
		b.printMatrix();
		
		Matrix m = new Matrix();
	//	m.add(a,b); this line is insufficient by itself to store the resultant.
		
	//	m = m.add(a, b); // this is how you full a matrix with it's addition. ....
	//	System.out.println("add: ");
	
	//	m.printMatrix();
		System.out.println();
		
		//		System.out.println("Subtract: ");
		//		m = m.subtract(a);
		//		m.printMatrix();
	
		System.out.println();
		System.out.println("Multiplication test: ");
		
		m = a.matrixProduct(b);
		m.printMatrix();
		
		
	//	System.out.println("Multiplication test INVERSE: ");
		// m = b.matrixProduct(b);
	//	m.printMatrix();
		
		
		
		System.out.println("Multiplication test of 3X1 and 1X3: ");
		
		Matrix threeone = new Matrix(3,1);
		Matrix onethree = new Matrix(1,3);
		
		int[] fill = {1,2,3};
		
		threeone.fillMatrixLinear(fill);
		onethree.fillMatrixLinear(fill);
		
		threeone.printMatrix();
		System.out.println();
		onethree.printMatrix();
		System.out.println();
		
		Matrix product = new Matrix();
		
		product = onethree.matrixProduct(threeone);
		product.printMatrix();
		System.out.println();
		
		Matrix pp = new Matrix();
		
		pp = threeone.matrixProduct(onethree);
		pp.printMatrix();
		System.out.println();
		
	
		
	}

}

*/