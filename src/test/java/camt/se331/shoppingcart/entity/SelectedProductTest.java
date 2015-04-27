package camt.se331.shoppingcart.entity;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static junitparams.JUnitParamsRunner.$;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;
/**
 * Created by Dto on 2/7/2015.
 */
public class SelectedProductTest {




    @Test
    public void testGetTotalProductPrice(){
        Product p = new Product(1l,"iphone 6","The worst iphone ever",25000.00);
        SelectedProduct sp = new SelectedProduct(p,0);
        assertThat(sp.getTotalPrice(),is(0.0));
        sp.setAmount(1);
        assertThat(sp.getTotalPrice(),is(25000.0));
        sp.setAmount(2);
        assertThat(sp.getTotalPrice(),is(50000.0));
    }

    @Test void testGetTotalProductPriceUsingMock(){
        Product p = mock(Product.class);
        when(p.getTotalPrice()).thenReturn(1000.0);
        SelectedProduct sp = new SelectedProduct(p,0);
        assertThat(sp.getTotalPrice(),is(0.0));
        when(p.getTotalPrice()).thenReturn(2500.00);
        sp.setProduct(p);
        sp.setAmount(10);
        when(p.getTotalPrice()).thenReturn(25000.00);
    }
}
