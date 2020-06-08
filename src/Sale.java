
public class Sale
{
	private Product product;
	private int quantity;
	private String date;
	
	public Sale(Product product, int quantity, String date)
	{
		this.product = product;
		this.quantity = quantity;
		this.date = date;
	}
	
	//get Methods
	public Product getProduct()
	{
		return this.product;
	}
	
	public int getQuantity()
	{
		return this.quantity;
	}
	
	public String getDate()
	{
		return  this.date;
	}
	
	//set Methods
	public void setProduct(Product product)
	{
		this.product = product;
	}
	
	public void setQuantity(int quantity)
	{
		this.quantity = quantity;
	}
	
	public void setDate(String date)
	{
		this.date = date;
	}
}
