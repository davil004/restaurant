package tw.org.iii.cma.labcargojsp.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tw.org.iii.cma.labcargojsp.domain.CartItem;
import tw.org.iii.cma.labcargojsp.domain.CartItem2;

@Repository
public interface CartItemRepository2 extends JpaRepository<CartItem2,Long> {

}
