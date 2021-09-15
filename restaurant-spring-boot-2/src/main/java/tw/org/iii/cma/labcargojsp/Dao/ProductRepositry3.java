package tw.org.iii.cma.labcargojsp.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tw.org.iii.cma.labcargojsp.domain.Product2;
import tw.org.iii.cma.labcargojsp.domain.Product3;

@Repository
public interface ProductRepositry3 extends JpaRepository<Product3, Long> {

}
