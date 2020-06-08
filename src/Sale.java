
public class Sale
{
	private Product product;
	private int quantity;
	
	public Sale(Product product, int quantity)
	{
		this.product = product;
		this.quantity = quantity;
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
	
	//set Methods
	public void setProduct(Product product)
	{
		this.product = product;
	}
	
	public void setQuantity(int quantity)
	{
		this.quantity = quantity;
	}
}
