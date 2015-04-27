package camt.se331.shoppingcart.entity;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.test.context.TestContextManager;

import java.util.Arrays;
import java.util.List;

import static junitparams.JUnitParamsRunner.$;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;
/**
 * Created by Dto on 2/7/2015.
 */

@RunWith(JUnitParamsRunner.class)
public class ShoppingCartTest {

    private TestContextManager testContextManager;
    // initiate parameterize testing


    @Test
    @Parameters(method = "parameterForTestGetTotalProductPrice")
    public void TestGetTotalProductPrice(List<SelectedProduct> productList, Double expectedResult){
        ShoppingCart sc = new ShoppingCart(productList);
        assertThat(sc.getTotalProductPrice(),is(expectedResult));
    }

    public Object[] parameterForTestGetTotalProductPrice(){
        Product p1 =  new Product(1l,"iphone 6","The worst iphone ever",25000.00);
        Product p2 = new Product(2l, "Note II","The old",6500.00);
        Product p3 = new Product (3l, "Chair", "Older chair",250.00 );
        return $(
                $(Arrays.asList(new SelectedProduct(p1,0),
                        new SelectedProduct(p2,0),
                        new SelectedProduct(p3,0)),0.0),
                $(Arrays.asList(new SelectedProduct(p1, 1),
                        new SelectedProduct(p2, 1),
                        new SelectedProduct(p3, 1)), 31750.00),
                $(Arrays.asList(new SelectedProduct(p1, 1),
                        new SelectedProduct(p2, 3)), 44500.00)
        );
    }

    @Test
    public void  TestGetTotalProductPrice(){
        SelectedProduct sp1 = Mockito.mock(SelectedProduct.class);
        SelectedProduct sp2 = Mockito.mock(SelectedProduct.class);
        when(sp1.getTotalPrice()).thenReturn(250.00);
        when(sp2.getTotalPrice()).thenReturn(500.00);
        verify(sp1,times(1)).getTotalPrice();
        verify(sp2,times(1)).getTotalPrice();

        ShoppingCart sp = new ShoppingCart(Arrays.asList(sp1,sp2));
        assertThat(sp.getTotalProductPrice(),is(750.00));
    }
}
