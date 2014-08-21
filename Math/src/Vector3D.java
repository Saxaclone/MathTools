import java.math.*;

public class Vector3D extends Vector

// change dependency to make a more abstract class of Vector? 

{
	private double x;
	private double y; 
	private double z;

	private double theta;
//	private double phi;
//	private double kappa;
	
	private int dimension;
	
	private double magnitude;
//	double direction;
	private double r;
	
//CONSTRUCT	
	public Vector3D(){	super(3);setX(0); setY(0); setZ(0);}
	
	//public Vector3D(double i, double j, double k, double th, double ph, double kap)//{		}
	
	public Vector3D (double i, double j, double k)
	{
		super(3);
		setX(i);
		setY(j);
		setZ(k);
		setMAG(calcMAG());
		setTH(calcTHETA());
		setR(calcR());
	}
	
	public Vector3D(int i, int j)	{super(3); setX(i); setY(j); setZ(0);}
	
	public Vector3D(int i)			{super(3); setX(i); setY(0); setZ(0);}
	
//OPERATIONS
	public double calcMAG()
	{
		return Math.sqrt(Math.pow(this.getX(),2) + Math.pow(this.getY(),2) + Math.pow(this.getZ(),2)  	);
	}
	public double calcTHETA()
	{
		double thet = (Math.atan(this.getY()/this.getX()));
		if (x < 0) thet += Math.PI;
		else if (x > 0 && y < 0) thet += 2*Math.PI;
		return thet;
	}
	public double calcR(){	return Math.sqrt(Math.pow(this.getX(),2) + Math.pow(this.getY(),2) );	}
	
	public double dotProduct(Vector3D a) // this function could be much more general. 
	{		return (this.getX()*a.getX() + this.getY()*a.getY() + this.getZ()*a.getZ());	}
	
	public Vector3D crossProduct(Vector3D a)
	{
		Vector3D m = new Vector3D();
		m.setX(this.getY()*a.getZ() - this.getZ()*a.getY());
		m.setY(this.getZ()*a.getX() - this.getX()*a.getZ());
		m.setZ(this.getX()*a.getY() - this.getY()*a.getX());
		return m;	
	}
	
	public Vector3D add(Vector3D a)
	{
		Vector3D m = new Vector3D();
		m.setX(this.getX() + a.getX());
		m.setY(this.getY() + a.getY());
		m.setZ(this.getZ() + a.getZ());
		return m;
	}
	
	public Vector3D scalarProduct(double a)
	{
		Vector3D m = new Vector3D();
		m.setX(this.getX()*a);
		m.setY(this.getY()*a);
		m.setZ(this.getZ()*a);
		return m;	
	}
	
	public Vector3D subtract(Vector3D a)
	{
		a.scalarProduct(-1);
		Vector3D m =  new Vector3D();
		m = this.add(a);
		return m;
	}
	
	//this is actuall a bivector??? wtF?
	
	
//SET
	public void setX(double i) 		{ x = i; }
	public void setY(double j) 		{ y = j; }
	public void setZ(double k) 		{ z = k; }
	public void setTH(double i) 	{ theta = i; }
//	public void setPH(double j) 	{ phi = j; }
//	public void setKAP(double k) 	{ kappa = k; }
	public void setMAG(double m)	{ magnitude = m;}
	public void setR(double x)		{ r = x;		}
	
//GET
	public double getX()	{return x;}
	public double getY()	{return y;}
	public double getZ()	{return z;}
	public double getTH()	{return theta;}
//	public double getPH()	{return phi;}
//	public double getKA()	{return kappa;}
	public double getMAG() 	{return magnitude;}
	public double getR()	{return r;}

//	
	public String toString(){	return (this.getX() + "i " + this.getY() + "j " + this.getZ() + "k " );	}
	public boolean equals(Vector3D a){	return(this.getX() == a.getX() && this.getY() == a.getY() && this.getZ() == a.getZ());	}


}
