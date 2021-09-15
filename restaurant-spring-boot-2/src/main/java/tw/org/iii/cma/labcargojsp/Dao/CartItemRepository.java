package tw.org.iii.cma.labcargojsp.Dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tw.org.iii.cma.labcargojsp.domain.CartItem;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem,Long> {
	
}
