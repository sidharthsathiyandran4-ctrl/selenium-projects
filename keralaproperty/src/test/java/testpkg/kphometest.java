package testpkg;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;

import basepkg.kpbaseclass;

public class kphometest extends kpbaseclass{
	@Test
	public void display() {
		boolean text=homepage.propertydisplay();
		Assert.assertTrue(text,"property text not present");
		
	}
	



}
