public class Drive{
	
	public static void main(String args[])
	{
		
		Vector3D u = new Vector3D(3,-3,1);
		Vector3D v = new Vector3D(4,9,2);
		
		u = u.crossProduct(v);
		System.out.println(u.toString());

		Matrix a = new Matrix(2,2);
		int[] k = {2,2,2,2};
		int[] p = {3,6,8,12};
		a.fillMatrixLinear(k);
		Matrix b = new Matrix(2,2);
		b.fillMatrixLinear(p);
		
		Matrix m = new Matrix(a.directProduct(b));
		
		m.printMatrix();
		
		Matrix n = new Matrix(b.directProduct(a));
		n.printMatrix();
		
	}
	
	
	
	
	
}