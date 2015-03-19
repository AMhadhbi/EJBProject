package metier;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless(name = "PRO")
public class ProductEJBImpl implements IProductRemote, IProductLocal {

	@PersistenceContext(unitName = "UP_PRO")
	private EntityManager em;

	@Override
	public void addProduct(Product p) {
		em.persist(p);

	}

	@Override
	public List<Product> getAllProducts() {
		Query query = em.createQuery("select p form Product p");
		return query.getResultList();
	}

	@Override
	public List<Product> getProductbySW(String sw) {
		Query query = em
				.createQuery("select p form Product p where p.nameProduct like:w");
		query.setParameter("w", "%" + sw + "%");
		return query.getResultList();
	}

	@Override
	public Product getProducts(Long idP) {
		Product p = em.find(Product.class, idP);
		return p;
	}

	@Override
	public void deleteProduct(Long idP) {
		Product p = em.find(Product.class, idP);
		if (p == null)
			throw new RuntimeException("Product not found");
		em.remove(p);

	}

	@Override
	public void updateProduct(Product p) {
		Product p1 = em.find(Product.class, p.getIdProduct());
		p1.setNameProduct(p.getNameProduct());
		p1.setAmount(p.getAmount());
		em.persist(p);

	}

}
