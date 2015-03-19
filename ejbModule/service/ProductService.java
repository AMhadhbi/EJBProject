package service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import metier.IProductLocal; 
import metier.Product;

@Stateless
@WebService
public class ProductService {
	@EJB
	private IProductLocal metier;
	
	@WebMethod
	public List<Product> getAllProduct(@ WebParam(name="search word")String sw) { 
		return metier.getAllProducts();
		
	}

}


