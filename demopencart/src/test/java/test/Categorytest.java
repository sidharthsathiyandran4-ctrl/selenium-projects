package test;

import org.testng.annotations.Test;

import base.opencartbase;
import page.Categorypage;

public class Categorytest extends opencartbase {

    @Test
    public void sortHighToLowAndAddAllItemsToWishlist() {
 

        // Sort price High → Low
        category.sortByPriceHighToLow();

        // Show 100 products
        category.setShowLimitTo100();

        // Add all items to wishlist
        category.clickProductImage();
        
    
    }
}
