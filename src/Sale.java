
public class Sale
{
	private Product product;
	private String date;
	private int quantity;
	
	public Sale(Product product, String date, int quantity)
	{
		this.product = product;
		this.date = date;
		this.quantity = quantity;
	}
	//get Methods
	public Product getProduct()
	{
		return this.product;
	}
	
	public String getDate()
	{
		return this.date;
	}
	
	public int getQuantity()
	{
		return this.quantity;
	}
	
	//set Methods
	public void setProduct(Product product)
	{
		this.product = product;
	}
	
	public void setDate(String date)
	{
		this.date = date;
	}
	
	public void setQuantity(int quantity)
	{
		this.quantity = quantity;
	}
}
