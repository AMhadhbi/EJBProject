package metier;

import java.util.List;
import javax.ejb.Local;

@Local
public interface IProductLocal  {

	public void  addProduct(Product p);
	public List<Product> getAllProducts();
	public List<Product> getProductbySW(String sw);
	public Product getProducts(Long idP);
	public void deleteProduct(Long idP);
	public void updateProduct(Product p);
}
