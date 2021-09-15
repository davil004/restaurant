package tw.org.iii.cma.labcargojsp.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tw.org.iii.cma.labcargojsp.domain.Product2;

@Repository
public interface ProductRepositry2 extends JpaRepository<Product2, Long> {

}
