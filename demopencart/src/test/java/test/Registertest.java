package test;

import org.testng.annotations.Test;
import base.opencartbase;
import page.Registerpage;

public class Registertest extends opencartbase {

    @Test
    public void verifyUserCanRegisterWithNewsletterYes() {
       

        register.enterFirstName("arun");
        register.enterLastName("s");
        register.enterEmail("arunnns1232233456##221234@gmail.com");
        register.enterTelephone("12345678897");
        register.enterPassword("12334");
        register.enterConfirmPassword("12334");
        register.selectNewsletterYes();
        register.acceptPrivacyPolicy();
        register.clickContinue();
    }
    }
    
    
    

