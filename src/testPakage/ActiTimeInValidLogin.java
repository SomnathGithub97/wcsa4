package testPakage;

import java.io.IOException;

import org.testng.annotations.Test;

import genericPakage.BaseTest;
import genericPakage.Flib;
import pagePakage.LoginPage;

public class ActiTimeInValidLogin extends BaseTest {
	@Test
	public void setUp() throws InterruptedException, IOException
	{
		Flib flib = new Flib();
		LoginPage lp = new LoginPage(driver);
		lp.actiTimeValidLogin(flib.readProertyData(PROP_PATH,"username"), flib.readProertyData(PROP_PATH, "password"));
	}

}
