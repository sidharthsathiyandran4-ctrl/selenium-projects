package test;

import org.testng.annotations.Test;
import base.opencartbase;

public class Producttest extends opencartbase {

    @Test
    public void selectDateAndQuantityTest() {

    



        
        product.setQuantity("2");

   
        product.clickAddToCart();
        
        product.cartbutton();
    }
}
