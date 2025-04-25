import com.example.productapi.domain.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class JpaMain {
    private static final Logger logger = LogManager.getLogger(JpaMain.class);

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            // Your JPA code here
            // For example, creating a new entity or querying the database
//            createProduct(em);

        } catch (Exception e) {
            em.getTransaction().rollback();
            logger.error("An error occurred", e);
        } finally {
            em.close();
            emf.close();
        }

        System.out.println("JPA application finished.");
    }

//    private static void createProduct(EntityManager em) {
//        Product product = new Product();
//        product.setName("Sample Product");
//        product.setPrice(100);
//        product.setStock(50);
//        em.persist(product);
//        em.getTransaction().commit();
//    }

}
