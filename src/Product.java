public class Product
{
	private String name;
	private double price;
	private String stockType;
	private int productsID;
	private int suppliersID;
	private int stock;
	
	//Constructor
	public Product(String name, double price, String stockType, int productsID, int suppliersID, int stock)
	{
		this.name = name;
		this.price = price;
		this.stockType = stockType;
		this.productsID = productsID;
		this.suppliersID = suppliersID;
		this.stock = stock;
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
	public int getStock()
	{
		return this.stock;
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
	public void setStock(int stock)
	{
		this.stock = stock;
	}
	
		
}
