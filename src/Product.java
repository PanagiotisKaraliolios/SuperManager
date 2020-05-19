public class Product
{
	private String name;
	private double price;
	private String stockType;
	private int productsID;
	private int suppliersID;
	
	//Constructor
	public Product(String name, double price, String stockType, int productsID, int suppliersID)
	{
		this.name = name;
		this.price = price;
		this.stockType = stockType;
		this.productsID = productsID;
		this.suppliersID = suppliersID;
	}
	
	//get methods
	public String getName()
	{
		return this.name;
	}
	
	public double getPrice()
	{
		return this.price;
	}
	
	public String getStockType()
	{
		return this.stockType;
	}
	
	public int getProductsID()
	{
		return this.productsID;
	}
	
	public int getSuppliersID()
	{
		return this.suppliersID;
	}
	
	
	//set methods
	public void setName(String name)
	{
		this.name = name;
	}
	
	public void setPrice(double price)
	{
		this.price = price;
	}
	
	public void setStockType(String st)
	{
		this.stockType = st;
	}
	
	public void setProductsID(int ID)
	{
		this.productsID = ID;
	}
	
	public void setSuppliersID(int suppID)
	{
		this.suppliersID = suppID;
	}
	
		
}
