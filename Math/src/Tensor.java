
public class Tensor {

	
	//total order = n + m 
	private int order;
	private int contravariantI; 	// n


	private int covariantI; 	// m

	
//CONSTRUCT
	public Tensor(){};
	
	public Tensor(int m, int n)
	{
		setCo(m);
		setContra(n);
		setOrder(m+n);
		
	}
	
//SET	
	public void setContra(int m)
	{	if (m >= 0) contravariantI = m;	
	else System.out.println(" bad m value");

	}
	
	public void setCo(int n )
	{		if ( n >= 0) covariantI = n;
	else System.out.println(" bad n value");
	}
	
	public void setOrder(int a) 		//restrictions? 
	{	order = a;	}
	
	
//GET
	
	public int getContra()	{	return contravariantI;	}
	
	public int getCo()		{	return covariantI;		}
	
	public int getOrder()	{ 	return order;			}
	
	
	
	
}
