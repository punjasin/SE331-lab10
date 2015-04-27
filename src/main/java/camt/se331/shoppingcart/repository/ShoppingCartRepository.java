package camt.se331.shoppingcart.repository;

import camt.se331.shoppingcart.entity.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Dto on 4/6/2015.
 */
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart,Long> {
}
