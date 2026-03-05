package testpkg;

import org.testng.annotations.Test;

import basepkg.kpbaseclass;
import pagepkg.prptyinfopage;

public class prptyinfotest extends kpbaseclass {

    @Test
    public void fillPropertyInfo() {
        prptyinfopage info = new prptyinfopage(driver);

        info.setPropertyLabel("New Villa");
        info.selectCategory("House");
        info.setExpectedPrice("5000000");
        info.selectDistrict("Ernakulam");
        info.setLocation("Vallam");      // Wait is handled inside the page class
        info.setnoofbed("10");
        info.setAddress("Near Infopark, Kochi");
    }
}
