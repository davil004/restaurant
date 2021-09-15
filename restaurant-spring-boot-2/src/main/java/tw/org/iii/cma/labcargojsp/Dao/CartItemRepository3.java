package tw.org.iii.cma.labcargojsp.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tw.org.iii.cma.labcargojsp.domain.CartItem3;

@Repository
public interface CartItemRepository3 extends JpaRepository<CartItem3,Long> {

}
