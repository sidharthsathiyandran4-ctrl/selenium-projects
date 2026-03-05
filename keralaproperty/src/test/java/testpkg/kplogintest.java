package testpkg;

import org.testng.annotations.Test;

import basepkg.kpbaseclass;

public class kplogintest extends kpbaseclass {

	
	@Test
	public void test()throws Exception {
		login.setvalues("sidharthsathiyandran4@gmail.com", "12345678910");
		login.logicClick();
	}
}
