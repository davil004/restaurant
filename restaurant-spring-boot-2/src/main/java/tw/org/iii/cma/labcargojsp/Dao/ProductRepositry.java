package tw.org.iii.cma.labcargojsp.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tw.org.iii.cma.labcargojsp.domain.Product;

@Repository
public interface ProductRepositry extends JpaRepository<Product, Long> {

}
