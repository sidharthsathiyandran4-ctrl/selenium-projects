package test;

import org.testng.annotations.Test;
import base.opencartbase;
import page.Checkoutpage;

public class Checkouttest extends opencartbase {

    @Test
    public void completeCheckoutTest() {

        // FILL BILLING DETAILS 
    	  checkout.fillBillingDetails(
            "arun",       
            "s",        
            "1234 kannur",
            "kannur",   
            "670365",      
            "India",  
            "Kerala"      
        );

        checkout.clickContinueBilling();

        //  DELIVERY METHOD 
        checkout.enterDeliveryComments("Please deliver between 9 AM - 5 PM");
  

        // PAYMENT METHOD 
        checkout.agreeTerms();
        checkout.clickContinuePayment();
        checkout.confirmbutton();

  
    }
}
