
// In mathematics, physics, and engineering, 
// a Euclidean vector (sometimes called a geometric[1] or spatial vector,

public class Vector {
	
	int dimensions;
	double[] parameters;
	
	
	public Vector (int d)
	{		setDimensions(d);	}
	
/*	public double dotProduct(Vector a)
	{
		if (this.getDimensions() == a.getDimensions())
		double cross = 	
		
	}*/
	
	public int getDimensions() {	return dimensions;	}
	public void setDimensions(int dimensions) {	this.dimensions = dimensions;	}


	
}
