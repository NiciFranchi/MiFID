package dal;

import entity.Product;
import org.apache.log4j.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Created by u95599 on 2016.04.18.
 */
@Stateless
public class ProductFacade extends AbstractFacade<Product> {
    private static final Logger logger = Logger.getLogger(ProductFacade.class);

    @PersistenceContext
    private EntityManager em;

    public ProductFacade() {
        super(Product.class);
    }

    @Override
    protected EntityManager em() {
        return em;
    }

    public Product findByName(String name){
        logger.info("ProductFacade.findByName() called with parameter " + name);
        Query query = em.createNamedQuery("Product.findByName");
        query.setParameter("productName", name);
        return (Product)query.getSingleResult();
    }
}
